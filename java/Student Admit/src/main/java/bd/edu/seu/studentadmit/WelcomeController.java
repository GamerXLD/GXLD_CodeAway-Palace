package bd.edu.seu.studentadmit;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class WelcomeController implements Initializable {
    @FXML
    public Label nameLabel;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        nameLabel.setText(RegistrationController.print);
    }
}
