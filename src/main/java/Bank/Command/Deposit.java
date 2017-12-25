package Bank.Command;


import Bank.Command.Interface.BankCommand;
import Bank.Command.Interface.BankOperation;

public class Deposit implements BankCommand {

    BankOperation bankOperation;

    private double amount;

    public Deposit(BankOperation bankOperation, double amount) {
        this.bankOperation = bankOperation;
        this.amount= amount;
    }

    @Override
    public void execute() {
        bankOperation.deposit(amount);
    }
}
