package Bank.Decorator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DebitAccount extends BankAccountDecorator {

    private static final Logger logger = LoggerFactory.getLogger(DebitAccount.class);

    private double amount = 155.00;
    private double debitLimit = 200;

    public DebitAccount(BankAccount bankAccount) {
        super(bankAccount);
        this.debitLimit = debitLimit;
    }

    public String getDescription() {
        return tempBankAccount.getDescription() + " Plus Debit Account";
    }

    @Override
    public double getBalance() {
        return tempBankAccount.getBalance() + 200;
    }

    public double getDebitLimit(){
        return debitLimit;
    }

    @Override
    public void transfer() {
        logger.info("Przelano: {}zł", amount);
    }

    @Override
    public void withdraw(double amount) {
        logger.info("Wypłacono: {}zł", this.amount);
    }

    @Override
    public void deposit(double amount) {
        logger.info("Wpłacono: {}zł", this.amount);
    }

    @Override
    public void closeAccount(int accountNumber) {
        logger.info("Zamknięto konto");
    }

    @Override
    public void openDebit(int accountNumber) {
        logger.info("Otwarto debet na koncie");
    }

}
