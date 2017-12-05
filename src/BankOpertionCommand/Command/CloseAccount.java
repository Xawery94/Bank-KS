package BankOpertionCommand.Command;

import BankOpertionCommand.Command.Interface.BankCommand;
import BankOpertionCommand.Command.Interface.BankOperation;

public class CloseAccount implements BankCommand {

    BankOperation bankOperation;

    public CloseAccount(BankOperation bankOperation) {
        this.bankOperation = bankOperation;
    }

    @Override
    public void execute() {
        bankOperation.closeAccount();
    }
}
