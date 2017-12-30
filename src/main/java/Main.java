import Bank.BankMediator.BankHub;
import Bank.Decorator.BasicBankAccount;
import Bank.Command.Interface.BankOperation;
import Bank.Command.Transfer;
import Bank.Command.Deposit;
import Bank.Command.Withdraw;
import Bank.Command.BankExecutor;
import Bank.Command.CloseAccount;
import Bank.Command.OpenDebit;
import Bank.Decorator.BasicBankAccount;
import Bank.BankMediator.Mediator;


import org.apache.log4j.BasicConfigurator;

public class Main {

    public static void main(String[] args) {
        BasicConfigurator.configure();
/*
        //TODO Transaction Visitor
        TaxVisitor calcTax = new TaxVisitor();
        Liquor whisky = new Liquor(3.50);
        TabacoServ cigars  = new Tobacco(11.99);

        System.out.println(whisky.accept(calcTax));
        System.out.println(cigars.accept(calcTax));
*/
 /*     RaportVisitor raport = new RaportVisitor();
        BankService bankService = new BankServiceImpl();
        bankService.openNewAccount("aaa", 10000);
        bankService.openNewAccount("aaa", 100);
        bankService.openNewAccount("aaa", 10000);
        bankService.openNewAccount("aaa", 10000);
        bankService.openNewAccount("aaa", 10000);
        System.out.println(bankService.getAccountsList().size());
        System.out.println(bankService.accept(raport));
*/
/*
        //TODO Debit Account
        BankAccount basicAccount = new BasicBankAccount(1,1234,1000.00);
        BankAccount debitAccount = new DebitAccount(new BasicBankAccount(2,4321,2000.00));

        System.out.println("This is: " + basicAccount.getDescription());
        System.out.println("This is: " + debitAccount.getDescription());


        //TODO Command
        Deposit depositCommand = new Deposit(basicAccount);
        BankExecutor makePayment = new BankExecutor(depositCommand);
        makePayment.makeOperation();

        OpenDebit openDebitCommand = new OpenDebit(debitAccount);
        BankExecutor openDebit = new BankExecutor(openDebitCommand);
        openDebit.makeOperation();
*//*
        //TODO Investment
        Interest interest = new Interest(1050, 2);
        interest.calculateInterest();


        //TODO Command

        BankHub bankHub = new BankHub();
        BankOperation account = new BasicBankAccount("aa",1000,bankHub);
        BankOperation accountTO = new BasicBankAccount("aa",1000,bankHub);
        BasicBankAccount basicBankAccount = new BasicBankAccount("aa",1000,bankHub);

//        Withdraw withdrawCommand = new Withdraw(account,500);
//        BankExecutor makeWithdraw = new BankExecutor(withdrawCommand);
//        makeWithdraw.makeOperation();
//
//        Deposit depositCommand2 = new Deposit(account,1000);
//        BankExecutor makePayment2 = new BankExecutor(depositCommand2);
//        makePayment2.makeOperation();

        Transfer transferCommand = new Transfer(account,accountTO,250);
        BankExecutor makeTransfer = new BankExecutor(transferCommand);
        makeTransfer.makeOperation();

//        CloseAccount closeAccountCommand = new CloseAccount(account, 0);
//        BankExecutor closeBankAccount = new BankExecutor(closeAccountCommand);
//        closeBankAccount.makeOperation();
//
//        OpenDebit openDebitCommand2 = new OpenDebit(account);
//        BankExecutor openDebit2 = new BankExecutor(openDebitCommand2);
//        openDebit2.makeOperation();
*/
    }
}
