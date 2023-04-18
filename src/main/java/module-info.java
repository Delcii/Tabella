module com.example.tabdipendentilibro {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.tabella to javafx.fxml;
    exports com.example.tabella;
}