import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class DriverAppUI extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        // Create UI components
        Button btnScanVin = new Button("Scan VIN");
        TextField tfDriverName = new TextField();
        DatePicker dpDate = new DatePicker();
        ImageView ivBeforeTrip = new ImageView();
        ImageView ivAfterTrip = new ImageView();
        TextArea taComments = new TextArea();
        Button btnSave = new Button("Save");

        // Set component properties
        tfDriverName.setPromptText("Enter driver name");
        taComments.setPromptText("Comments/Suggestions");

        // Create the layout
        GridPane gridPane = new GridPane();
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(10, 10, 10, 10));

        // Add components to the layout
        gridPane.add(btnScanVin, 0, 0, 2, 1);
        gridPane.add(new Label("Driver Name:"), 0, 1);
        gridPane.add(tfDriverName, 1, 1);
        gridPane.add(new Label("Date:"), 0, 2);
        gridPane.add(dpDate, 1, 2);
        gridPane.add(new Label("Before Trip:"), 0, 3);
        gridPane.add(ivBeforeTrip, 1, 3);
        gridPane.add(new Label("After Trip:"), 0, 4);
        gridPane.add(ivAfterTrip, 1, 4);
        gridPane.add(new Label("Comments:"), 0, 5);
        gridPane.add(taComments, 1, 5);
        gridPane.add(btnSave, 0, 6, 2, 1);

        // Create the scene and show the stage
        Scene scene = new Scene(gridPane, 400, 600);
        primaryStage.setTitle("Driver App UI");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
