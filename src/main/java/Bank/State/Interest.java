package Bank.State;

import java.util.Date;

public class Interest {

    private InterestState interestState;
    private Date startDate;
    private int duration;
    private double balance;

    public Interest(double balance, int duration) {
        this.setBalance(balance);
        this.startDate = new Date();
        this.duration = duration;
    }

    public void setBalance(double balance) {
        this.balance = balance;

        if(balance < 1000){
            interestState = new FiveInterestState();
        }else{
            interestState = new TenInterestState();
        }
    }

    public void calculateInterest() {
        interestState.calc();
    }
}
