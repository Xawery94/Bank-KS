package Bank.Visitor;

import Bank.BankEntity.BankService;
import Bank.BankEntity.BankServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;


import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class RaportVisitorTest {

    private RaportVisitor raport = new RaportVisitor();
    private BankService bankService = new BankServiceImpl();

    @Before
    public void setUp(){
        raport = new RaportVisitor();

        bankService.openNewAccount("aaa", 10000);
        bankService.openNewAccount("aaa", 100);
        bankService.openNewAccount("aaa", 10000);
        bankService.openNewAccount("aaa", 10000);
        bankService.openNewAccount("aaa", 10000);
    }

    @Test
    public void shouldCreateRaport(){
        assertEquals(4, bankService.accept(raport));
    }
}