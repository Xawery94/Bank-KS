package BankOpertionCommand.Command;

import BankOpertionCommand.Interface.BankCommand;
import BankOpertionCommand.Interface.BankOperation;

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
