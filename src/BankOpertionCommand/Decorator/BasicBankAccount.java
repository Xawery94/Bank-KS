package BankOpertionCommand.Decorator;

import java.util.Random;

public class BasicBankAccount implements BankAccount {

    private int id;
    private int accountNumber;
    private double balance;
    private Random rnd = new Random();

    public BasicBankAccount(int id, int accountNumber, double balance) {
        this.id = id;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }


    @Override
    public String getDescription() {
        return "Basic Bank Account";
    }
}
