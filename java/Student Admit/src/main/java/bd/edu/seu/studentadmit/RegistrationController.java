package bd.edu.seu.studentadmit;

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
    private TextArea biographyArea;

    @FXML
    private ToggleGroup genderToggle;

    @FXML
    private TextField nameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private ChoiceBox<String> programChoiceBox;

    public static String print;

    @FXML
    void saveAction(ActionEvent event) {
        String name = nameField.getText();
        String password = passwordField.getText();
        String program = programChoiceBox.getValue();
        String biography = biographyArea.getText();

        print = name + "," + password + "," + program + "," + biography + "\n";
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile("student.txt", "rw");
            randomAccessFile.seek(randomAccessFile.length());
            randomAccessFile.writeBytes(print);

            HelloApplication.changeScene("welcome");
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException exception) {
            exception.printStackTrace();
        }
        System.out.println(print);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.println("I am here");
        ObservableList<String> programList = FXCollections.observableArrayList();
        programList.add("CSE");
        programList.add("EEE");
        programList.add("BBA");
        programList.add("English");

        programChoiceBox.setItems(programList);
    }
}
