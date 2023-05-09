module com.carapp {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.carapp to javafx.fxml;
    exports com.carapp;
}
