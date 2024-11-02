package com.rakin.dresscollection101.Controller;

import com.rakin.dresscollection101.HelloApplication;
import com.rakin.dresscollection101.Model.DressCollection;
import com.rakin.dresscollection101.Model.Gender;
import com.rakin.dresscollection101.Service.Service;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    @FXML
    private CheckBox boostingCheck;
    @FXML
    private PasswordField codeField;
    @FXML
    private ColorPicker colorField;
    @FXML
    private DatePicker datePick;
    @FXML
    private TextArea detailsArea;
    @FXML
    private ImageView imageChoose;
    @FXML
    private Label money;
    @FXML
    private TextField nameField;
    @FXML
    private Slider priceSlider;
    @FXML
    private Spinner<Integer> quantitySpin;
    @FXML
    private ComboBox<String> sizeField;
    @FXML
    private ChoiceBox<String> typeField;
    @FXML
    private RadioButton male;
    @FXML
    private RadioButton female;
    @FXML
    private Label show;
    String imagePath;

    void alertShow(){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Information not Saved");
        alert.setHeaderText(null);
        alert.setContentText("You have successfully didnt save the dress collection");
        alert.showAndWait();
    }

    double priceRound () {
        double price = priceSlider.getValue();
        return (double) Math.round (price * 100) / 100;
    }

    @FXML
    void saveButton(ActionEvent event) {
        String name = nameField.getText();
        String type = String.valueOf(typeField.getValue());
        String size = String.valueOf(sizeField.getValue());
        String color = String.valueOf(colorField.getValue());
        double priceFinal = priceRound();
        String detail = detailsArea.getText();
        String date = String.valueOf(datePick.getValue());
        show.setText(date);
        int quantity = quantitySpin.getValue();
        String code =  codeField.getText();
        String gen = String.valueOf(Gender.Other);
        if (male.isSelected()){gen = String.valueOf(Gender.Male);} else if (female.isSelected()) gen = String.valueOf(Gender.Female);
        String boosting;
        if (boostingCheck.isSelected()) {boosting = "Enable";} else boosting = "Disable";
        String path = imagePath;

        DressCollection dressCollection = new DressCollection(name,type,size,color,priceFinal,detail,date,quantity,code,gen,boosting,path);
        System.out.println(dressCollection.toString());
        Service service = new Service();

        if (name.isEmpty()){
            alertShow();
        }else if (type.isEmpty()) {
            alertShow();
        }else if (size.isEmpty()) {
            alertShow();
        } else if (color.isEmpty()) {
            alertShow();
        } else if (!boostingCheck.isSelected()) {
            alertShow();
        } else if (detail.isEmpty()) {
            alertShow();
        } else if (code.isEmpty()) {
            alertShow();
        } else {
            service.save(dressCollection);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information not Saved");
            alert.setHeaderText(null);
            alert.setContentText("You have successfully saved the dress collection"+"\n"+
                    dressCollection.toString());
            alert.showAndWait();
        }
    }

    @FXML
    void showListButton(ActionEvent event) {
        HelloApplication.changeScene("sub");
    }

    @FXML
    void showPrice(MouseEvent event) {
        double price = priceRound();
        money.setText(String.valueOf(price));
    }

    @FXML
    void chooseButton(ActionEvent event) throws MalformedURLException {
        FileChooser fileChooser = new FileChooser();
        File file = fileChooser.showOpenDialog(new Stage());
        if (file != null) {
            Image img = new Image(file.toURI().toURL().toExternalForm());
            imagePath = file.toURI().toURL().toExternalForm();
            imageChoose.setImage(img);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        SpinnerValueFactory<Integer> valueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 500, 10);
        quantitySpin.setValueFactory(valueFactory);
        ObservableList<String> typeList = FXCollections.observableArrayList();
        typeList.add("T-shirt");typeList.add("Hoodie");typeList.add("Pants");typeList.add("Shoe");
        typeField.setItems(typeList);
        ObservableList<String> sizeList = FXCollections.observableArrayList();
        sizeList.add("L");sizeList.add("M");sizeList.add("XL");sizeList.add("XXL");sizeList.add("XXXL");
        sizeField.setItems(sizeList);

    }
}
