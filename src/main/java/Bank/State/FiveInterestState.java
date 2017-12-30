package Bank.State;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import Bank.Decorator.BasicBankAccount;

public class FiveInterestState implements InterestState {
    private Interest interest;
    private BasicBankAccount basicBankAccount;

    private static final Logger logger = LoggerFactory.getLogger(FiveInterestState.class);

    @Override
    public double calculate() {
        logger.info("Oprocentowanie o wysokości 5%");

        double interestPercent = 0.05;
        double day = interest.getDuration()*30/365;
        double zysk = (basicBankAccount.getBalance()  * interestPercent / day);
        return zysk;
    }

    @Override
    public Interest getInterest() {
        return interest;
    }

    @Override
    public double breakInterest() {
        return interest.getBalance();
    }

    @Override
    public double closeInterest() {
        return interest.getBalance()+ (calculate());
    }
}
