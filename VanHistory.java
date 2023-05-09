import java.sql.Date;
import java.util.concurrent.ExecutionException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;

public class VanHistory {
    private String driverName;
    private String date;
    private String comments;
    private String managementResponse;
    private static Object firestore;

    public VanHistory(String driverName, String date, String comments, String managementResponse) {
        this.driverName = driverName;
        this.date = date;
        this.comments = comments;
        this.managementResponse = managementResponse;
    }

    public String getDriverName() {
        return driverName;
    }

    public String getDate() {
        return date;
    }

    public String getComments() {
        return comments;
    }

    public String getManagementResponse() {
        return managementResponse;
    }

    

    public static ObservableList<VanHistory> fetchVanHistory(String vin) {
        ObservableList<VanHistory> vanHistoryList = FXCollections.observableArrayList();

        try {
            ((Object) firestore).collection("vans").document(vin).collection("trips").get()
                    .addOnCompleteListener(task -> {
                        if (task.isSuccessful()) {
                            task.getResult().forEach(document -> {
                                String driverName = document.getString("driverName");
                                String date = document.getTimestamp("date").toDate().toString();
                                String comments = document.getString("comments");
                                String managementResponse = document.getString("managementResponse");

                                vanHistoryList.add(new VanHistory(driverName, date, comments, managementResponse));
                            });
                        } else {
                            System.err.println("Error fetching van history: " + task.getException());
                        }
                    }).get();
        } catch (InterruptedException | ExecutionException e) {
            ((Throwable) e).printStackTrace();
        }

        return vanHistoryList;
    }


    public static void main(String[] args) {
        Date currentDate = new Date(0, 0, 0);
        long thirtyDaysInMillis = 30L * 24 * 60 * 60 * 1000;

        Object task = null;

        task.getResult().forEach(document -> {
            Date tripDate = ((Object) document).getTimestamp("date").toDate();
            long timeDifference = currentDate.getTime() - tripDate.getTime();

            if (timeDifference <= thirtyDaysInMillis) {
                String driverName = ((Object) document).getString("driverName");
                String date = ((Object) document).getTimestamp("date").toDate().toString();
                String comments = ((Object) document).getString("comments");
                String managementResponse = ((Object) document).getString("managementResponse");

                vanHistoryList.add(new VanHistory(driverName, date, comments, managementResponse));
            }
        });
        

        ListView<VanHistory> listView = new ListView<>();
        String vin = "12345678901234567"; 
        ObservableList<VanHistory> vanHistoryList = fetchVanHistory(vin);
        listView.setItems(vanHistoryList);

        listView.setCellFactory(param -> new ListCell<VanHistory>() {
            @Override
            protected void updateItem(VanHistory item, boolean empty) {
                super.updateItem(item, empty);

                if (empty || item == null) {
                    setText(null);
                } else {
                    String historyText = String.format(
                            "Driver: %s\nDate: %s\nComments: %s\nManagement Response: %s",
                            item.getDriverName(),
                            item.getDate(),
                            item.getComments(),
                            item.getManagementResponse()
                    );
                    setText(historyText);
                }
            }
        });
    }
}



