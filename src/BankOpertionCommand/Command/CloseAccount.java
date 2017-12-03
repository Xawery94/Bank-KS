package BankOpertionCommand.Command;

import BankOpertionCommand.Interface.BankCommand;
import BankOpertionCommand.Interface.BankOperation;

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
