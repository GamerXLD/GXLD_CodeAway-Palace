package bd.edu.seu.seucash4;

import javafx.beans.property.SimpleDoubleProperty;
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

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class SceneController implements Initializable {

    @FXML
    private Label balanceLabel;

    @FXML
    private TableColumn<Transaction, String> mobileColum;

    @FXML
    private TableColumn<Transaction,Number > amounttabel;

    @FXML
    private TextField searchField;

    @FXML
    private TableView<Transaction> tabelView;

    @FXML
    private TableColumn<Transaction, String> typeColum;

    @FXML
    void searchAction(ActionEvent event) {

        String mobile = searchField.getText();

        TransactionService transactionService = new TransactionService();
        List<Transaction> transactionList = transactionService.getTransactionList(mobile);
        ObservableList<Transaction> observableList = FXCollections.observableArrayList();
        observableList.addAll(transactionList);
        tabelView.setItems(observableList);

        double balance = transactionService.getBalance(mobile);
        balanceLabel.setText("Balance: " +balance);

    }
    @FXML
     void back(){
        HelloApplication.change("scene1");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        mobileColum.setCellValueFactory(c ->new SimpleStringProperty(c.getValue().getMobileNumber()));
        amounttabel.setCellValueFactory(c ->new SimpleDoubleProperty(c.getValue().getAmount()));
        typeColum.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getType()));
    }
}
