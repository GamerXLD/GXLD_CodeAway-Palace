module bd.edu.seu.seucash4 {
    requires javafx.controls;
    requires javafx.fxml;


    opens bd.edu.seu.seucash4 to javafx.fxml;
    exports bd.edu.seu.seucash4;
}