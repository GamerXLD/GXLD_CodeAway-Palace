module bd.edu.seu.studentadmit {
    requires javafx.controls;
    requires javafx.fxml;


    opens bd.edu.seu.studentadmit to javafx.fxml;
    exports bd.edu.seu.studentadmit;
}