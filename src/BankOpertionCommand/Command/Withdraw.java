package BankOpertionCommand.Command;

import BankOpertionCommand.Interface.BankOperation;
import BankOpertionCommand.Interface.BankCommand;

public class Withdraw implements BankCommand {

    BankOperation bankOperation;

    public Withdraw(BankOperation bankOperation) {
        this.bankOperation = bankOperation;
    }

    @Override
    public void execute() {
        bankOperation.withdraw();
    }
}
