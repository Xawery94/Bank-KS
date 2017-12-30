package Bank.Decorator;

import Bank.BankEntity.BankService;
import Bank.BankEntity.BankServiceImpl;
import Bank.BankMediator.Mediator;
import Bank.Exception.MinAmount;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BasicBankAccount implements BankAccount {

    private static final Logger logger = LoggerFactory.getLogger(BasicBankAccount.class);

    BankService bankService = new BankServiceImpl();

    private double balance;
    private int accountNum;
    private String customerName;
    private double[] transactions;
    private String[] transactionsSummary;
    private int numOfTransactions;
    private static int noOfAccounts = 0;
    private Mediator mediator;

    public BasicBankAccount(String newCustomerName, double openingBalance, Mediator mediator) {
        customerName = newCustomerName;
        balance = openingBalance;
        this.mediator = mediator;
        noOfAccounts++;
        accountNum = noOfAccounts;
        transactions = new double[100];
        transactionsSummary = new String[1000];
        transactions[0] = balance;
        transactionsSummary[0] = "A balance of: " + Double.toString(balance) + "zł was deposited.";
        numOfTransactions = 1;
    }

    public BasicBankAccount(){}

    @Override
    public double getBalance() {
        return balance;
    }

    @Override
    public void sendMessage(String message) {
        System.out.println("Bla bla: " + message);
    }

    @Override
    public String getDescription() {
        return "Basic Bank Account";
    }

    @Override
    public void withdraw(double amount) {
        if (amount <= 0) {
            logger.warn("Amount to be withdrawn should be positive");
            throw new MinAmount();
        } else {
            if (balance < amount) {
                logger.warn("Insufficient balance");
            } else {
                balance = balance - amount;
                transactions[numOfTransactions] = amount;
                transactionsSummary[numOfTransactions] = "zł" + Double.toString(amount) + " was withdrawn.";
                numOfTransactions++;
            }
        }
    }

    @Override
    public void deposit(double amount) {
        if (amount <= 0) {
            logger.warn("Amount to be deposited should be positive");
            throw new MinAmount();
        } else {
            balance = balance + amount;
            transactions[numOfTransactions] = amount;
            transactionsSummary[numOfTransactions] = "zł" + Double.toString(amount) + " was deposited.";
            numOfTransactions++;
        }
    }

    @Override
    public void closeAccount(int accountNumber) {
        bankService.removeAccount(accountNumber);
        logger.info("Zamknięto konto o nr: {}", accountNumber);
    }

    @Override
    public void transfer(double amount) {
        balance = balance + amount;
        transactions[numOfTransactions] = amount;
        transactionsSummary[numOfTransactions] = "zł" + Double.toString(amount) + " was withdrawn.";
        numOfTransactions++;
    }

    @Override
    public void openDebit(int accountNumber) {
        logger.info("Otwarto debet na koncie");
    }

    public String getAccountInfo() {
        return "Account number: " + accountNum + "\nCustomer Name: " + customerName + "\nBalance:" + balance + "\n";
    }

    public String getTransactionInfo(int n) {
        String transaction = transactionsSummary[n];
        if (transaction == null) {
            return "No transaction exists with that number.";
        } else {
            return transaction;
        }
    }

    public int getAccountNum() {
        return accountNum;
    }

    public int getNumberOfTransactions() {
        return numOfTransactions;
    }

    public double[] getTransactions() {
        return transactions;
    }

    public String[] getTransactionsSummary() {
        return transactionsSummary;
    }
}
