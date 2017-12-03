import BankOpertionCommand.BankExecutor;
import BankOpertionCommand.Command.*;
import BankOpertionCommand.Entitie.Account;
import BankOpertionCommand.Interface.BankOperation;
import BankOpertionCommand.State.Interest;
import Trash.PizzaDecorator.Mozzarella;
import Trash.PizzaDecorator.Pizza;
import Trash.PizzaDecorator.PlainPizza;
import Trash.PizzaDecorator.TomatoSauce;
import Trash.VisitorExample.Liquor;
import Trash.VisitorExample.TaxVisitor;
import Trash.VisitorExample.Tobacco;

public class Main {

    public static void main(String[] args) {

        TaxVisitor calcTax = new TaxVisitor();
        Liquor whisky = new Liquor(3.50);
        Tobacco cigars  = new Tobacco(11.99);

        System.out.println(whisky.accept(calcTax));
        System.out.println(cigars.accept(calcTax));


        //TODO Decorator
        Pizza basicPizza = new TomatoSauce(new Mozzarella(new PlainPizza()));

        System.out.println("Ingredients: " + basicPizza.getDescription());
        System.out.println("Price: " + basicPizza.getCost());


        //TODO Investment
        Interest interest = new Interest(1050, 2);
        interest.calculateInterest();

        //TODO Command
        BankOperation account = new Account();

        Withdraw withdrawCommand = new Withdraw(account);
        BankExecutor makeWithdraw = new BankExecutor(withdrawCommand);
        makeWithdraw.makeOperation();

        Deposit depositCommand = new Deposit(account);
        BankExecutor makePayment = new BankExecutor(depositCommand);
        makePayment.makeOperation();

        Transfer transferCommand = new Transfer(account);
        BankExecutor makeTransfer = new BankExecutor(transferCommand);
        makeTransfer.makeOperation();

        CloseAccount closeAccountCommand = new CloseAccount(account);
        BankExecutor closeBankAccount = new BankExecutor(closeAccountCommand);
        closeBankAccount.makeOperation();

        OpenDebit openDebitCommand = new OpenDebit(account);
        BankExecutor openDebit = new BankExecutor(openDebitCommand);
        openDebit.makeOperation();

    }
}
