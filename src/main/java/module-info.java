module com.example.sodoco {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.sodoco to javafx.fxml;
    exports com.example.sodoco;
}