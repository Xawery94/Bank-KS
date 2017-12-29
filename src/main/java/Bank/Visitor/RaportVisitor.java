package Bank.Visitor;

import Bank.BankEntity.BankService;
import Bank.Decorator.BankAccount;

import java.util.List;

public class RaportVisitor implements Visitor {

    private int exist;

    public RaportVisitor() {}

    @Override
    public int visit(BankService bankService) {
        List<BankAccount> bankAccounts = bankService.getAccountsList();

        for (BankAccount bankAccount:bankAccounts) {
            if(bankAccount.getBalance() > 1000){
                exist++;
            }
        }

        return exist;
    }
}
