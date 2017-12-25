package Bank.Visitor;

import Bank.BankEntity.BankService;
import Bank.Decorator.BankAccount;
import Bank.Decorator.BasicBankAccount;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import java.util.ArrayList;
import java.util.List;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class VisitorTest {

    @Mock
    BankService bankService;
    private BankAccount basicAccount;
    private List<BankAccount> bankAccountList = new ArrayList<>();
    private RaportVisitor raportVisitor;

    @Before
    public void setUp() {

        basicAccount = new BasicBankAccount("Ala1", 1001);
        basicAccount = new BasicBankAccount("Ala2", 1002);
        basicAccount = new BasicBankAccount("Ala3", 1003);
        bankAccountList.add(basicAccount);

    }

    @Test
    public void shouldCreateRaport(){ //konta z saldem > 1000
        bankService.openNewAccount("Ala1", 1001);
        bankService.openNewAccount("Ala2", 1002);
        bankService.openNewAccount("Ala3", 1003);

        when(basicAccount.getBalance() > 1000).thenReturn(true);

    }

}