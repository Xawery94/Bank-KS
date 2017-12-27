package Bank.Decorator;


import Bank.Command.Interface.BankOperation;

public interface BankAccount extends BankOperation {

    String getDescription();

    double getBalance();

    void sendMessage(String message);

}
