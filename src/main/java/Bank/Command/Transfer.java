package Bank.Command;


import Bank.Command.Interface.BankCommand;
import Bank.Command.Interface.BankOperation;
import Bank.Decorator.BankAccount;

public class Transfer implements BankCommand {

    BankOperation bankOperation;
    BankOperation bankOperationTO; // nie powinno tak byc
    double amount;

    public Transfer(BankOperation bankOperation, BankOperation bankOperationTO, double amount) {
        this.bankOperation = bankOperation;
        this.bankOperationTO = bankOperationTO;
        this.amount = amount;
    }

    @Override
    public void execute() {
        bankOperation.transfer(-amount);
        bankOperationTO.transfer(amount);
    }
}
