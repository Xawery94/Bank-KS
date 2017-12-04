package BankOpertionCommand.Decorator;

public class DebitAccount extends BankAccountDecorator {

    public DebitAccount(BankAccount bankAccount) {
        super(bankAccount);
    }

    public String getDescription() {
        return tempBankAccount.getDescription() + " Plus Debit Account";
    }

}
