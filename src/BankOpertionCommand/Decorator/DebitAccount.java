package BankOpertionCommand.Decorator;

public class DebitAccount extends BankAccountDecorator {

    double ammount = 155.00;

    public DebitAccount(BankAccount bankAccount) {
        super(bankAccount);
    }

    public String getDescription() {
        return tempBankAccount.getDescription() + " Plus Debit Account";
    }

    @Override
    public void transfer() {
        System.out.println("Przelano: "+ ammount + "zł");
    }

    @Override
    public void withdraw() {
        System.out.println("Wypłacono: "+ ammount + "zł");
    }

    @Override
    public void payment() {
        System.out.println("Wpłacono: "+ ammount + "zł");
    }

    @Override
    public void closeAccount() {
        System.out.println("Zamknięto konto");
    }

    @Override
    public void openDebit() {
        System.out.println("Otwarto debet na koncie");
    }

}
