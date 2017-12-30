package Bank.BankEntity;

import Bank.BankMediator.BankHub;
import Bank.Command.BankExecutor;
import Bank.Command.Deposit;
import Bank.Command.Transfer;
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
    private BankService bankService;

    private BankAccount basicAccount;
    private BankAccount basicAccountTO;
    private BankAccount debitAccount;
    private List<BankAccount> bankAccountList = new ArrayList<>();

    @Before
    public void setUp(){
        BankHub bankHub = new BankHub();
        basicAccount = new BasicBankAccount("Ala", 1000, bankHub);
        basicAccountTO = new BasicBankAccount("Ala1", 1000, bankHub);
        debitAccount = new DebitAccount(new BasicBankAccount("Ala2",1000, bankHub));

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
        BankHub bankHub = new BankHub();
        bankService.openNewAccount("Ala1", 1000, bankHub);
        bankService.openNewAccount("Ala2", 2000, bankHub);
        bankService.openNewAccount("Ala3", 3000, bankHub);

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

    @Test(expected = MinAmount.class)
    public void shouldThrowExceptionWhenWithdrawFromAccount(){
        Withdraw withdrawCommand = new Withdraw(basicAccount, -100);
        BankExecutor makeWithdraw = new BankExecutor(withdrawCommand);
        makeWithdraw.makeOperation();
    }

    @Test
    public void shouldDepositToAccountBalance(){
        Deposit depositCommand = new Deposit(basicAccount, 1000);
        BankExecutor makePayment = new BankExecutor(depositCommand);
        makePayment.makeOperation();

        assertThat(basicAccount.getBalance(), equalTo(2000.0));
    }

    @Test(expected = MinAmount.class)
    public void shouldThrowExceptionWhenDepositToAccountBalance(){
        Deposit depositCommand = new Deposit(basicAccount, -1000);
        BankExecutor makePayment = new BankExecutor(depositCommand);
        makePayment.makeOperation();
    }

    @Test
    public void shouldTransferToAccountBalance(){
        Transfer transferCommand = new Transfer(basicAccount,basicAccountTO,350);
        BankExecutor makePayment = new BankExecutor(transferCommand);
        makePayment.makeOperation();
        assertThat(basicAccount.getBalance(), equalTo(650.0));
        assertEquals(650.0, basicAccount.getBalance(),1);
        assertEquals(1350.00, basicAccountTO.getBalance(),1);
    }

    @Test(expected = MinAmount.class)
    public void shouldThrowExceptionWhenNegativeAmount(){
        Deposit depositCommand = new Deposit(basicAccount, -1000);
        BankExecutor makePayment = new BankExecutor(depositCommand);
        makePayment.makeOperation();
    }
}