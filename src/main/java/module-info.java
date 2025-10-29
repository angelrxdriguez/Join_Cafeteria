module com.join_cafeteria {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.join_cafeteria to javafx.fxml;
    exports com.join_cafeteria;
}