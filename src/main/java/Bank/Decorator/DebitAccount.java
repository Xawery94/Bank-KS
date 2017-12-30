package Bank.Decorator;

import Bank.Exception.MinAmount;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DebitAccount extends BankAccountDecorator {

    private static final Logger logger = LoggerFactory.getLogger(DebitAccount.class);

    private double amount = 155.00;
    private double debitLimit = 200;
    private double BalancePlusDebitLimit = getBalance();
    private int numOfTransactions = getNumberOfTransactions();
    private double[] transactions = getTransactions();
    private String[] transactionsSummary = getTransactionsSummary();

    public DebitAccount(BankAccount bankAccount) {
        super(bankAccount);
        this.debitLimit = debitLimit;
    }

    public String getDescription() {
        return tempBankAccount.getDescription() + " Plus Debit Account";
    }

    @Override
    public double getBalance() {
        return tempBankAccount.getBalance() + debitLimit;
    }

    @Override
    public double[] getTransactions() {
        return transactions;
    }

    @Override
    public int getNumberOfTransactions() {
        return numOfTransactions;
    }

    @Override
    public String[] getTransactionsSummary() {
        return transactionsSummary;
    }

    @Override
    public void sendMessage(String message) {

    }

    public double getDebitLimit(){
        return debitLimit;
    }

    @Override
    public void transfer(double amount) {
        logger.info("Przelano: {}zł", amount);
    }

    @Override
    public void withdraw(double amount) {
        if (amount <= 0) {
            logger.warn("Amount to be withdrawn should be positive");
            throw new MinAmount();
        } else {
            if (getBalance() < amount) { //getBalance == BalancePlusDebitLimit -> aby nie wyrzucało duplikatu
                logger.warn("Insufficient balance");
            } else {
                BalancePlusDebitLimit = BalancePlusDebitLimit - amount;
                transactions[numOfTransactions] = amount;
                transactionsSummary[numOfTransactions] = "zł" + Double.toString(amount) + " was withdrawn.";
                numOfTransactions++;
            }
        }
        logger.info("Wypłacono: {}zł", this.amount);
    }

    @Override
    public void deposit(double amount) {
        if (amount <= 0) {
            logger.warn("Amount to be withdrawn should be positive");
            throw new MinAmount();
        } else {
            if (getBalance() < amount) { //getBalance == BalancePlusDebitLimit -> aby nie wyrzucało duplikatu
                logger.warn("Insufficient balance");
            } else {
                BalancePlusDebitLimit = BalancePlusDebitLimit + amount;
                transactions[numOfTransactions] = amount;
                transactionsSummary[numOfTransactions] = "zł" + Double.toString(amount) + " was withdrawn.";
                numOfTransactions++;
            }
        }
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
