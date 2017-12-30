package Bank.Command;

import Bank.Command.Interface.BankCommand;
import Bank.Command.Interface.BankOperation;

public class Transfer implements BankCommand {

    private BankOperation bankOperation;
    private BankOperation bankOperationTO; // need to improve
    private double amount;

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
