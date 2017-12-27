package Bank.BankMediator;

import Bank.BankEntity.BankService;

import java.util.ArrayList;
import java.util.List;

public class BankHub implements Mediator{
    private List<BankService> bankWorkers = new ArrayList<>();

    public void addJobWorker(BankService bank){
        bankWorkers.add(bank);
    }

    @Override
    public void makeTransfer(String message, int accountNumber){
        for (BankService bank : bankWorkers){
            if(bank.getNumAccounts() == accountNumber){
                bank.transfer();
            }
        }
    }
}
