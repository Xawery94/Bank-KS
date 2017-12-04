package BankOpertionCommand.Command;

import BankOpertionCommand.Command.Interface.BankCommand;
import BankOpertionCommand.Command.Interface.BankOperation;

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
