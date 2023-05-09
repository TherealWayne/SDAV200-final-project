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
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class DriversApp extends Application {

    private Button btnScanVin;
    private TextField tfDriverName;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        // Create UI components
        btnScanVin = new Button("Scan VIN");
        tfDriverName = new TextField();
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

        // Set button actions (barcode scanning, image capturing, saving data)
        btnScanVin.setOnAction(e -> scanBarcode());

        // Set image click event handlers
        ivBeforeTrip.setOnMouseClicked(e -> captureImage(ivBeforeTrip));
        ivAfterTrip.setOnMouseClicked(e -> captureImage(ivAfterTrip));

        // Create the scene and show the stage
        Scene scene = new Scene(gridPane, 400, 600);
        primaryStage.setTitle("Drivers App");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void scanBarcode() {
        // Create a new WebView to display the camera feed
        WebView webView = new WebView();
        WebEngine webEngine = webView.getEngine();
    
        // Load the ZXing QR code reader web app
        webEngine.load("https://zxing.appspot.com/scan");
    
        // Set the function to handle the result of the barcode scanning
        webEngine.locationProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue.startsWith("https://zxing.appspot.com/scan?result=")) {
                // Get the decoded VIN from the URL
                String decodedVin = newValue.substring(newValue.lastIndexOf('=') + 1);
    
                // Populate the driver name field with the decoded VIN
                populateVanInformation(decodedVin);
            }
        });
    
        // Create a new Scene to display the camera feed
        Scene cameraScene = new Scene(webView, 640, 480);
    
        // Show the camera scene in a new Stage
        Stage cameraStage = new Stage();
        cameraStage.setTitle("Scan VIN Barcode");
        cameraStage.setScene(cameraScene);
        cameraStage.show();
    }
    
    private void populateVanInformation(String decodedVin) {
        tfDriverName.setText(decodedVin);
    }
    
    private void captureImage(ImageView imageView) {
        Optional<CameraService> cameraServiceOpt = CameraService.create();
        if (!cameraServiceOpt.isPresent()) {
            System.err.println("No camera service available.");
            return;
        }
    
        CameraService cameraService = cameraServiceOpt.get();
    
        if (!cameraService.isCameraAvailable()) {
            System.err.println("No camera available.");
            return;
        }
    
        cameraService.snapshotProperty().addListener((obs, oldImage, newImage) -> {
            if (newImage != null) {
                imageView.setImage(newImage);
            }
        });
    
        cameraService.start();
        cameraService.takeSnapshot();
        cameraService.stop();
    }
}

