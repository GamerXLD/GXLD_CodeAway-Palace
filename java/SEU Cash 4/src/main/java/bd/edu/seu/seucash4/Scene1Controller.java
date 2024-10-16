package bd.edu.seu.seucash4;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class Scene1Controller {

    @FXML
    private TextField depositeA0mountField;

    @FXML
    private TextField depositeMobileNumberField;

    @FXML
    private TextField withdrawAmountField;

    @FXML
    private TextField withdrawMobileNumberField;

    @FXML
    void depositeAction(ActionEvent event) {
        String mobileNumber = depositeMobileNumberField.getText();
        double amount = Double.parseDouble(depositeA0mountField.getText());
        Transaction transaction = new Transaction(mobileNumber, amount, "deposit");
        TransactionService transactionService = new TransactionService();
        transactionService.save(transaction);
       HelloApplication.change("scene2");


    }

    @FXML
    void withdrawAction(ActionEvent event) {
        String mobileNumber = withdrawMobileNumberField.getText();
        double amount = Double.parseDouble(withdrawAmountField.getText());
        Transaction transaction = new Transaction(mobileNumber, amount, "withdraw");
        TransactionService transactionService = new TransactionService();
        transactionService.save(transaction);
     HelloApplication.change("scene2");

    }

}
