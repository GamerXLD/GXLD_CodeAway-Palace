package bd.edu.seu.seucash4;

import java.util.ArrayList;
import java.util.List;

public class TransactionService {
    public static List<Transaction> transactionList = new ArrayList<>();

    void save(Transaction transaction){
        transactionList.add(transaction);

    }
    List<Transaction> getTransactionList(String mobile){
       return transactionList.stream().filter(t -> t.getMobileNumber().equals(mobile)).toList();

    }

    double getTotalDepositAmount(String mobile){
        return transactionList.stream().filter(t -> t.getMobileNumber().equals(mobile) && t.getType().equals("deposit")).mapToDouble(Transaction::getAmount).sum();
    }

    double getWithdrawAmount(String mobile){
        return transactionList.stream().filter(t -> t.getMobileNumber().equals(mobile) && t.getType().equals("withdraw")).mapToDouble(Transaction::getAmount).sum();
    }

    double getBalance(String mobile){
        return getTotalDepositAmount(mobile) - getWithdrawAmount(mobile);
    }
}
