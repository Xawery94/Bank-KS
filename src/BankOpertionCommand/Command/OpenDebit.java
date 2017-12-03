package BankOpertionCommand.Command;

import BankOpertionCommand.Interface.BankCommand;
import BankOpertionCommand.Interface.BankOperation;

public class OpenDebit implements BankCommand {

    BankOperation bankOperation;

    public OpenDebit(BankOperation bankOperation) {
        this.bankOperation = bankOperation;
    }

    @Override
    public void execute() {
        bankOperation.openDebit();
    }
}
