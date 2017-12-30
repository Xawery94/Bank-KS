package Bank.Command;


import Bank.Command.Interface.BankCommand;

public class BankExecutor {

    private BankCommand theBankCommand;

    public BankExecutor(BankCommand theBankCommand) {
        this.theBankCommand = theBankCommand;
    }

    public void makeOperation(){
        theBankCommand.execute();
    }
}
