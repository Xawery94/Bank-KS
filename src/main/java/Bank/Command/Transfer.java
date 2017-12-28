package Bank.Command;


import Bank.Command.Interface.BankCommand;
import Bank.Command.Interface.BankOperation;

public class Transfer implements BankCommand {

    BankOperation bankOperation;
    double amount;

    public Transfer(BankOperation bankOperation, double amount) {
        this.bankOperation = bankOperation;
        this.amount =amount;
    }

    @Override
    public void execute() {
        bankOperation.transfer(amount);
    }
}
