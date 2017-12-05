package BankOpertionCommand.Command;

import BankOpertionCommand.Command.Interface.BankOperation;
import BankOpertionCommand.Command.Interface.BankCommand;

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
