module com.rakin.dresscollection101 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.rakin.dresscollection101 to javafx.fxml;
    exports com.rakin.dresscollection101;

    opens com.rakin.dresscollection101.Controller to javafx.fxml;
    exports com.rakin.dresscollection101.Controller;
}