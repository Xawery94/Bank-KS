package BankOpertionCommand.Command;

import BankOpertionCommand.Interface.BankCommand;
import BankOpertionCommand.Interface.BankOperation;

public class Transfer implements BankCommand {

    BankOperation bankOperation;

    public Transfer(BankOperation bankOperation) {
        this.bankOperation = bankOperation;
    }

    @Override
    public void execute() {
        bankOperation.transfer();
    }
}
