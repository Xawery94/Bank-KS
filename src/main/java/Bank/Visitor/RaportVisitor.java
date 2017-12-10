package Bank.Visitor;

import Bank.Command.Interface.BankOperation;
import Bank.Command.Withdraw;
import Bank.Decorator.BankAccount;
import Bank.Decorator.BasicBankAccount;

import java.util.ArrayList;
import java.util.List;

public class RaportVisitor implements Visitor {

    List<BasicBankAccount> accountList = new ArrayList<BasicBankAccount>();
    List<Withdraw> withdrawList = new ArrayList<Withdraw>();
    int exist;

    @Override
    public double visit(BasicBankAccount basicBankAccount) {
        System.out.println("Lista kont z saldem > 1000");
        for(BasicBankAccount basicBankAccount1: accountList ) {
            if (basicBankAccount.getBalance() > 1000) {
                exist++;
            }
        }
        return exist;
    }

//    @Override
//    public double visit(Withdraw withdraw ){
//        System.out.println("Lista wypłat powyżej > 500");
//        for(Withdraw withdraw1: withdrawList ) {
//            if (withdraw1 > 1000) {
//                exist++;
//            }
//        }
//        return exist;
//    }
}
