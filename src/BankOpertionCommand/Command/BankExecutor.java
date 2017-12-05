package BankOpertionCommand.Command;

import BankOpertionCommand.Command.Interface.BankCommand;

public class BankExecutor {

    BankCommand theBankCommand;

    public BankExecutor(BankCommand theBankCommand) {
        this.theBankCommand = theBankCommand;
    }

    public void makeOperation(){
        theBankCommand.execute();
    }
}
