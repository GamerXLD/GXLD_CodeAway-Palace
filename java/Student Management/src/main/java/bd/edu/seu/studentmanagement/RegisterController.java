package bd.edu.seu.studentmanagement;

import javafx.fxml.FXML;
import javafx.scene.control.*;

public class RegisterController {
    @FXML
    public TextField nameField;
    @FXML
    public PasswordField passwordField;
    @FXML
    public ChoiceBox<String> programChoiceBox;
    @FXML
    public ToggleGroup genderToggle;
    @FXML
    public TextArea biographyArea;
    @FXML
    public CheckBox agreeCheckBox;

    public static String name;

    @FXML
    public void registerAction() {
        name = nameField.getText();
        String password = passwordField.getText();
        String biography = biographyArea.getText();
        boolean agree = agreeCheckBox.isSelected();

        System.out.println(agree);

        HelloApplication.changeScene("welcome");
    }

    @FXML
    public void changeScene() {
        System.out.println("Hello from first scene!");
        HelloApplication.changeScene("welcome");
    }
}
