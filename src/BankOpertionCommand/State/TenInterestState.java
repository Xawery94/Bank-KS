package BankOpertionCommand.State;

public class TenInterestState implements InterestState {

    @Override
    public void calc() {
        System.out.println("Oprocentowanie o wysokości 10%");
    }
}
