package BankOpertionCommand.Command;

import BankOpertionCommand.Command.Interface.BankCommand;
import BankOpertionCommand.Command.Interface.BankOperation;

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
