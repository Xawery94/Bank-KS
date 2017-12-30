package Bank.Visitor;

import Bank.BankEntity.BankService;

public interface Visitor {

    int visit(BankService BankService);

}
