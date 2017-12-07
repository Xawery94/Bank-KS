package BankOpertionCommand.Decorator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;

public class BasicBankAccount implements BankAccount {

    private static final Logger logger = LoggerFactory.getLogger(BasicBankAccount.class);

    private int id;
    private int accountNumber;
    private double balance;
    private Random rnd = new Random();

    double ammount = 100.00;

    public BasicBankAccount(int id, int accountNumber, double balance) {
        this.id = id;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    @Override
    public String getDescription() {
        return "Basic Bank Account";
    }

    @Override
    public void transfer() {
        logger.info("Przelano: {}zł", ammount);
    }

    @Override
    public void withdraw() {
        logger.info("Wypłacono: {}zł", ammount);
    }

    @Override
    public void payment() {
        logger.info("Wpłacono: {}zł", ammount);
    }

    @Override
    public void closeAccount() {
        logger.info("Zamknięto konto");
    }

    @Override
    public void openDebit() {
        logger.info("Otwarto debet na koncie");
    }
}
