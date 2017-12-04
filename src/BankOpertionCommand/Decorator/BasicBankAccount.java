package BankOpertionCommand.Decorator;

import java.util.Random;

public class BasicBankAccount implements BankAccount {

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
