package Bank.Command;

import Bank.Command.Interface.BankCommand;
import Bank.Command.Interface.BankOperation;

public class Withdraw implements BankCommand {

    private BankOperation bankOperation;
    private double amount;

    public Withdraw(BankOperation bankOperation, double amount) {
        this.bankOperation = bankOperation;
        this.amount = amount;
    }

    @Override
    public void execute() {
        bankOperation.withdraw(amount);
    }
}
