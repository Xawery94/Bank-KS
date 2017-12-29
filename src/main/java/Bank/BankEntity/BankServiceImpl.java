package Bank.BankEntity;

import Bank.BankMediator.Mediator;
import Bank.Decorator.BankAccount;
import Bank.Decorator.BasicBankAccount;
import Bank.Visitor.Visitable;
import Bank.Visitor.Visitor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BankServiceImpl implements BankService, Visitable {

    private static final Logger logger = LoggerFactory.getLogger(BankServiceImpl.class);

    private Bank bank = new Bank();
    private BasicBankAccount[] accounts;
    private List<BankAccount> accountsList = new ArrayList<>();
    private int numOfAccounts;

    @Override
    public int accept(Visitor visitor) {
        return visitor.visit(this);
    }

    @Override
    public void transfer(int accountNum,int accountNumTO, double amount) {
        accounts = bank.getAccounts();
        for (int i = 0; i < numOfAccounts; i++) {
            if (accountNum == accounts[i].getAccountNum()) {
                accounts[i].transfer((-amount)); // odejmuje z pierwszego konta
                logger.info("Amount transfer successfully");
                return;
            }
//            if (accountNumTO == accounts[i].getAccountNum()) {
//                accounts[i].transfer(amount); // dodaje z pierwszego konta -> nie dziala w testach
//                logger.info("Amount transfer successfully");
//                return;
//            }
        }
        logger.warn("Account number not found.");
        System.out.println("Przelano na konto" + this.numOfAccounts);
    }

    @Override
    public List<BankAccount> getAccountsList() {
        return accountsList;
    }

    @Override
    public int getNumAccounts() {
        return numOfAccounts;
    }

    @Override
    public void openNewAccount(String customerName, double openingBalance, Mediator mediator) {
        BasicBankAccount newBankAccount = new BasicBankAccount(customerName, openingBalance, mediator);
        accountsList.add(newBankAccount);
        numOfAccounts++;
    }

    @Override
    public void withdrawFrom(int accountNum, double amount) {
        accounts = bank.getAccounts();

        for (int i = 0; i < numOfAccounts; i++) {
            if (accountNum == accounts[i].getAccountNum()) {
                accounts[i].withdraw(amount);
                logger.info("Amount withdrawn successfully");
                return;
            }
        }
        logger.warn("Account number not found.");
    }

    @Override
    public void depositTo(int accountNum, double amount) {
        accounts = bank.getAccounts();

        for (int i = 0; i < numOfAccounts; i++) {
            if (accountNum == accounts[i].getAccountNum()) {
                accounts[i].deposit(amount);
                logger.info("Amount deposited successfully");
                return;
            }
        }
        logger.warn("Account number not found.");
    }

    @Override
    public void printAccountInfo(int accountNum) {
        accounts = bank.getAccounts();

        for (int i = 0; i < numOfAccounts; i++) {
            if (accountNum == accounts[i].getAccountNum()) {
                logger.info(accounts[i].getAccountInfo());
                return;
            }
        }
        logger.warn("Account number not found.");
    }

    @Override
    public void printTransactionInfo(int accountNum) {
        accounts = bank.getAccounts();

        for (int i = 0; i < numOfAccounts; i++) {
            if (accountNum == accounts[i].getAccountNum()) {
                logger.info(accounts[i].getAccountInfo());
                logger.info("Last transaction: " + accounts[i].getTransactionInfo(accounts[i].getNumberOfTransactions() - 1));
                return;
            }
        }
        logger.warn("Account number not found.");
    }

    @Override
    public void printAccountInfo(int accountNum, int n) {
        accounts = bank.getAccounts();

        for (int i = 0; i < numOfAccounts; i++) {
            if (accountNum == accounts[i].getAccountNum()) {
                logger.info(accounts[i].getAccountInfo());
                logger.info(accounts[i].getTransactionInfo(n));
                return;
            }
        }
        logger.warn("Account number not found.");
    }

    @Override
    public void removeAccount(int number) {
        accounts = bank.getAccounts();

        List<BasicBankAccount> list = Arrays.asList(accounts);
        for (BasicBankAccount account : accounts) {
            if (account.getAccountNum() == number)
                list.remove(account);
        }

        list.toArray(accounts);
    }
}
