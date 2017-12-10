package Bank.Visitor;

import Bank.Command.Interface.BankOperation;
import Bank.Command.Withdraw;
import Bank.Decorator.BasicBankAccount;

public interface Visitor {
    double visit(BasicBankAccount basicBankAccount);

    //double visit (Withdraw withdraw);
}
