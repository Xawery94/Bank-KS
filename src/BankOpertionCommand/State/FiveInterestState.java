package BankOpertionCommand.State;

public class FiveInterestState implements InterestState {

    @Override
    public void calc() {
        System.out.println("Oprocentowanie o wysokości 5%");
    }
}
