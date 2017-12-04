package BankOpertionCommand.Command;

import BankOpertionCommand.Command.Interface.BankCommand;
import BankOpertionCommand.Command.Interface.BankOperation;

public class Deposit implements BankCommand {

    BankOperation bankOperation;

    public Deposit(BankOperation bankOperation) {
        this.bankOperation = bankOperation;
    }

    @Override
    public void execute() {
        bankOperation.payment();
    }
}
