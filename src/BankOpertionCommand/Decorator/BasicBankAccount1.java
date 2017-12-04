package BankOpertionCommand.Decorator;

import java.util.Random;

public class BasicBankAccount1 implements BankAccount {

    private int id;
    private int accountNumber;
    private double balance;
    private Random rnd = new Random();

    public BasicBankAccount1(int id, int accountNumber, double balance) {
        this.id = id;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    @Override
    public String getDescription() {
        return "This is basic account";
    }
}
