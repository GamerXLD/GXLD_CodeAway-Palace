package bd.edu.seu.studentadmission;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.URL;
import java.util.ResourceBundle;

public class RegistrationController implements Initializable {

    @FXML
    private CheckBox agreeCheckBox;

    @FXML
    private TextArea biographyTextArea;

    @FXML
    private ToggleGroup genderToggle;

    @FXML
    private TextField nameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private ChoiceBox<String> programChoiceBox;

    @FXML
    void saveAction(ActionEvent event) {
        String name = nameField.getText();
        String password = passwordField.getText();
        String biography = biographyTextArea.getText();

        String line = name + "," + password + "," + biography + "\n";
        try {
            RandomAccessFile raf = new RandomAccessFile("admission.txt", "rw");
            raf.seek(raf.length());
            raf.writeBytes(line);
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ObservableList<String> programObservableList = FXCollections.observableArrayList();
        programObservableList.add("CSE");
        programObservableList.add("BBA");
        programObservableList.add("EEE");

        programChoiceBox.setItems(programObservableList);
    }
}






