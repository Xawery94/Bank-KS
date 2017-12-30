package Bank.State;

import java.util.Date;

public class Interest {

    private InterestState interestState;
    private Date startDate;
    private int duration;
    private double balance;

    Interest(double balance, int duration) {
        this.balance = balance;
        this.duration = duration;
        this.setInterest(balance);
        this.startDate = new Date();
    }

    public void setInterest(double balance) {
        this.balance = balance;

        if(balance < 1000){
            interestState = new FiveInterestState(this.getDuration(), this.getBalance());
        }else{
            this.interestState = new TenInterestState(this.getDuration(), this.getBalance());
        }
    }

    public void calculateInterest() {
        interestState.calculate();
    }

    public InterestState getInterestState() {
        return interestState;
    }

    public Date getStartDate() {
        return startDate;
    }

    public int getDuration() {
        return duration;
    }

    public double getBalance() {
        return balance;
    }

}
