package Bank.BankEntity;

import Bank.Command.BankExecutor;
import Bank.Command.Deposit;
import Bank.Command.Withdraw;
import Bank.Decorator.BankAccount;
import Bank.Decorator.BasicBankAccount;
import Bank.Decorator.DebitAccount;
import Bank.Exception.MinAmount;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class BankServiceImplTest {

    @Mock
    BankService bankService;

    private BankAccount basicAccount;
    private BankAccount debitAccount;
    private List<BankAccount> bankAccountList = new ArrayList<>();

    @Before
    public void setUp(){
        basicAccount = new BasicBankAccount("Ala", 1000);
        debitAccount = new DebitAccount(new BasicBankAccount("Ala2",1000));

        bankAccountList.add(basicAccount);
        bankAccountList.add(basicAccount);
        bankAccountList.add(basicAccount);
    }

    @Test
    public void shouldOpenNewAccount(){
        assertEquals(basicAccount.getDescription(), "Basic Bank Account");
    }

    @Test
    public void shouldCreateDebitAccount(){
        assertEquals(debitAccount.getDescription(), "Basic Bank Account Plus Debit Account");
    }

    @Test
    public void checkAccountListNumber(){
        bankService.openNewAccount("Ala1", 1000);
        bankService.openNewAccount("Ala2", 2000);
        bankService.openNewAccount("Ala3", 3000);

        when(bankService.getNumAccounts()).thenReturn(3);

        assertEquals(3, bankService.getNumAccounts());
    }

    @Test
    public void checkAccountList(){
        when(bankService.getAccountsList()).thenReturn(bankAccountList);

        assertEquals(3, bankService.getAccountsList().size());
    }

    @Test
    public void shouldWithdrawFromAccount(){
        Withdraw withdrawCommand = new Withdraw(basicAccount, 500);
        BankExecutor makeWithdraw = new BankExecutor(withdrawCommand);
        makeWithdraw.makeOperation();

        assertThat(basicAccount.getBalance(), equalTo(500.00));
    }

    @Test
    public void shouldDepositToAccountBalance(){
        Deposit depositCommand = new Deposit(basicAccount, 1000);
        BankExecutor makePayment = new BankExecutor(depositCommand);
        makePayment.makeOperation();

        assertThat(basicAccount.getBalance(), equalTo(2000.0));
    }

    @Test(expected = MinAmount.class)
    public void shouldThrowExceptionWhenNegativeAmount(){
        Deposit depositCommand = new Deposit(basicAccount, -1000);
        BankExecutor makePayment = new BankExecutor(depositCommand);
        makePayment.makeOperation();
    }
}