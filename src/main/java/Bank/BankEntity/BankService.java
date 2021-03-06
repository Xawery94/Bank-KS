package Bank.BankEntity;

import Bank.BankMediator.Mediator;
import Bank.Decorator.BankAccount;
import Bank.Visitor.Visitor;

import java.util.List;

public interface BankService {

    void openNewAccount(String customerName, double openingBalance, Mediator mediator);

    void withdrawFrom(int accountNum, double amount);

    void depositTo(int accountNum, double amount);

    void printAccountInfo(int accountNum);

    void printTransactionInfo(int accountNum);

    void printAccountInfo(int accountNum, int n);

    void removeAccount(int number);

    int getNumAccounts();

    List<BankAccount> getAccountsList();

    int accept(Visitor visitor);

    void transfer(int accountNum,int accountNumTO, double amount);
}
