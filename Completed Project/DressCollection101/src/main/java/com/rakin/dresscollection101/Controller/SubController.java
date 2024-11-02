package com.rakin.dresscollection101.Controller;

import com.rakin.dresscollection101.HelloApplication;
import com.rakin.dresscollection101.Model.DressCollection;
import com.rakin.dresscollection101.Service.Service;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;

import java.net.URL;
import java.util.*;
import java.util.stream.Collectors;

import javafx.scene.input.KeyEvent;

public class SubController implements Initializable {

    String g;
    boolean isHidden = false;
    String nameGet;
    @FXML
    private Label totalQuantityLabel;
    @FXML
    private TextField searchBar;
    @FXML
    private Label show;
    @FXML
    private TextField showNameField;
    @FXML
    private Label typeLabel;
    @FXML
    private Label sizeLabel;
    @FXML
    private Pane colorLabel;
    @FXML
    private Label priceLabel;
    @FXML
    private Label dateLabel;
    @FXML
    private Label genderLabel;
    @FXML
    private Label boostelabel;
    @FXML
    private ImageView imageLabel;
    @FXML
    private Label quantityLabel;
    @FXML
    private TableView<DressCollection> tableViewAll;
    @FXML
    private TableColumn<DressCollection, String> boostCollume;
    @FXML
    private TableColumn<DressCollection, String> colorCollume;
    @FXML
    private TableColumn<DressCollection, String> dateCollume;
    @FXML
    private TableColumn<DressCollection, String> nameCollume;
    @FXML
    private TableColumn<DressCollection, Number> priceCollume;
    @FXML
    private TableColumn<DressCollection, Number> quantityCollume;
    @FXML
    private TableColumn<DressCollection, String> typeCollume;

    @FXML
    void GoBack(ActionEvent event) {HelloApplication.changeScene("Main");}
    @FXML
    void hide(ActionEvent event) {
        if (tableViewAll.getSelectionModel().getSelectedItem() != null) {
            if (isHidden) {
                show.setText(g);
            } else {
                show.setText("*******");
            }
            isHidden = !isHidden;
        }
    }
    @FXML
    void showData(MouseEvent event) {
        DressCollection selectedDress = tableViewAll.getSelectionModel().getSelectedItem();
        if (selectedDress != null) {
            g = selectedDress.getDiscCode();
            if (!isHidden) {show.setText(g);}
        }
        String colo = selectedDress.getColor();
        Color color = Color.web(colo);
        colorLabel.setBackground(Background.fill(color));
        typeLabel.setText(selectedDress.getType());
        sizeLabel.setText(selectedDress.getSize());
        dateLabel.setText(selectedDress.getDate());
        genderLabel.setText(selectedDress.getGender());
        priceLabel.setText(String.valueOf(selectedDress.getPrice()));
        boostelabel.setText(selectedDress.getBoosting());
        imageLabel.setImage(new Image(selectedDress.getImage()));
        int quantity = selectedDress.getQuantity();
        if(quantity<=10){
            quantityLabel.setTextFill(Color.RED);
            quantityLabel.setText(String.valueOf(quantity));
        } else {
            quantityLabel.setTextFill(Color.GREEN);
            quantityLabel.setText(String.valueOf(quantity));
        }

        nameGet = selectedDress.getName();
        showNameField.setText(nameGet);
    }
    @FXML
    void serchDone(KeyEvent event) {
        String search = searchBar.getText();
        Service service = new Service();
        List<DressCollection> ls = service.list();
        List<DressCollection> ls2 = ls.stream().filter(s->
                s.getName().toLowerCase().contains(search.toLowerCase())
        ).collect(Collectors.toList());
        ObservableList<DressCollection> obs1 = FXCollections.observableArrayList();
        obs1.setAll(ls2);
        tableViewAll.setItems(obs1);
        //s.getName().toLowerCase().contains(search.toLowerCase()) || s.getType().toLowerCase().contains(search.toLowerCase())
    }
    @FXML
    void filtrei(ActionEvent event) {
        Service service = new Service();
        List<DressCollection> ls = service.list();
//        ls.sort(Comparator.comparing(DressCollection::getPrice));
        ObservableList<DressCollection> obs1 = FXCollections.observableArrayList();
        obs1.setAll(ls);
        tableViewAll.setItems(obs1);
    }
    @FXML
    void nameFilter(ActionEvent event) {
        Service service = new Service();
        List<DressCollection> ls = service.list();
        ls.sort(Comparator.comparing(dress -> dress.getName().toLowerCase()));
        ObservableList<DressCollection> obs1 = FXCollections.observableArrayList();
        obs1.setAll(ls);
        tableViewAll.setItems(obs1);
    }
    @FXML
    void sizeFilter(ActionEvent event) {
        Service service = new Service();
        List<DressCollection> ls = service.list();
        List<String> sizeOrder = Arrays.asList("M", "L", "XL", "XXL", "XXXL");
        List<DressCollection> filteredAndSorted = ls.stream()
                .filter(dress -> sizeOrder.contains(dress.getSize().toUpperCase()))
                .sorted(Comparator.comparingInt(dress -> sizeOrder.indexOf(dress.getSize().toUpperCase())))
                .collect(Collectors.toList());
        ObservableList<DressCollection> obs1 = FXCollections.observableArrayList();
        obs1.setAll(filteredAndSorted);
        tableViewAll.setItems(obs1);
    }
    @FXML
    void typeFilter(ActionEvent event) {
        Service service = new Service();
        List<DressCollection> ls = service.list();
        List<String> typeOrder = Arrays.asList("T-shirt", "Hoodie", "Pants", "Shoe");
        List<DressCollection> filteredAndSorted = ls.stream()
                .filter(dress -> typeOrder.contains(dress.getType()))
                .sorted(Comparator.comparingInt(dress -> typeOrder.indexOf(dress.getType())))
                .collect(Collectors.toList());
        ObservableList<DressCollection> obs1 = FXCollections.observableArrayList();
        obs1.setAll(filteredAndSorted);
        tableViewAll.setItems(obs1);
    }
    @FXML
    void deleteButton(ActionEvent event) {
        Service service = new Service();
        if (service.delete(nameGet)) {
            List<DressCollection> ls = service.list();
            ObservableList<DressCollection> os = FXCollections.observableArrayList();
            os.addAll(ls);
            tableViewAll.setItems(os);
        } else {
            System.out.println("Nothing to delete");
        }
        showNameField.setText("");
        typeLabel.setText("Not Selected");
        sizeLabel.setText("Not Selected");
        dateLabel.setText("Not Selected");
        genderLabel.setText("Not Selected");
        priceLabel.setText("Not Selected");
        boostelabel.setText("Not Selected");
        quantityLabel.setText("Not Selected");
        colorLabel.setBackground(Background.EMPTY);
        show.setText("******");
    }
    @FXML
    void updatebutton(ActionEvent event) {
        String updatedName = showNameField.getText();
        String previousName = nameGet;
        Service service = new Service();

        if(service.update(updatedName,previousName)){
            List<DressCollection> ls1 = service.list();
            ObservableList<DressCollection> os1 = FXCollections.observableArrayList();
            os1.addAll(ls1);
            tableViewAll.setItems(os1);
        } else {
            System.out.println("Nothing to update");
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        nameCollume.setCellValueFactory(c-> new SimpleStringProperty(c.getValue().getName()));
        typeCollume.setCellValueFactory(c-> new SimpleStringProperty(c.getValue().getType()));
        colorCollume.setCellValueFactory(c-> new SimpleStringProperty(c.getValue().getColor()));
        boostCollume.setCellValueFactory(c-> new SimpleStringProperty(c.getValue().getBoosting()));
        dateCollume.setCellValueFactory(c-> new SimpleStringProperty(c.getValue().getDate()));
        priceCollume.setCellValueFactory(c-> new SimpleDoubleProperty(c.getValue().getPrice()));
        quantityCollume.setCellValueFactory(c-> new SimpleIntegerProperty(c.getValue().getQuantity()));
        Service service = new Service();
        List<DressCollection> ls =service.list();
        ls.sort(Comparator.comparing(DressCollection::getPrice).reversed());
        ObservableList<DressCollection> obs = FXCollections.observableArrayList();
        obs.addAll(ls);

        OptionalDouble od = ls.stream().filter(s-> Objects.equals(s.getType(), "Hoodie")).mapToDouble(DressCollection::getPrice).average();
        if(od.isPresent()){
            System.out.println("Average : "+od.getAsDouble());
        }
        int total = ls.stream().mapToInt(DressCollection::getQuantity).sum();
        totalQuantityLabel.setText(String.valueOf(total));

        List<DressCollection> lsShort = ls.stream().sorted(Comparator.comparing(DressCollection::getPrice).reversed()).toList();
        System.out.println("Price High to Low : {");
        for(DressCollection dc : lsShort){
            System.out.println(dc.getPrice());
        }
        System.out.println("}");
        List<DressCollection> lsFilter = ls.stream().filter(s-> s.getPrice() > 1000).toList();
        System.out.println("Price More Than 1000 : {");
        for(DressCollection dc : lsFilter){
            System.out.println(dc.getPrice());
        }
        System.out.println("}");
        tableViewAll.setItems(obs);
//        double totalPrice = 0.0;
//        int count = 0;
//        for(DressCollection dc : obs){
//            totalQ = totalQ + dc.getQuantity();
//            if(dc.getType().equalsIgnoreCase("Hoodie")){
//                totalPrice+=dc.getPrice();
//                count++;
//            }
//        }
//        totalQuantityLabel.setText(String.valueOf(totalQ));
//        System.out.println(totalPrice/count);

        //Total Sum
        //double total = ls.stream().mapToDouble(DressCollection::getPrice).sum();
        // Image img = new Image(obs.getLast().getImage());
        //circle.setFill(new ImagePattern(img));

    }
}