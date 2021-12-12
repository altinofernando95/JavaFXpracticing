module com.example.javafxpracticing {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.javafxpracticing to javafx.fxml;
    exports com.example.javafxpracticing;
}