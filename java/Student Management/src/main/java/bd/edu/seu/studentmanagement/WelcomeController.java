package bd.edu.seu.studentmanagement;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class WelcomeController implements Initializable {
    @FXML
    public Label nameLabel;

    @FXML
    public void logout() {
        HelloApplication.changeScene("register");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.println("I am called from welcome scene.");
        nameLabel.setText(RegisterController.name);
    }
}
