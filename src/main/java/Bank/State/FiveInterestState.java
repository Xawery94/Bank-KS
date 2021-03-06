package Bank.State;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class FiveInterestState implements InterestState {
    private Interest interest;
    private int duration;
    private double amount;
    private BigDecimal zysk;

    private static final Logger logger = LoggerFactory.getLogger(FiveInterestState.class);

    FiveInterestState(int duration, double amount){
        this.duration = duration;
        this.amount = amount;
    }

    @Override
    public BigDecimal calculate() {
        logger.info("Oprocentowanie o wysokości 5%");

        double interestPercent = 0.05;
        int day = duration;
        zysk = BigDecimal.valueOf((amount  * interestPercent * day / 365));
        zysk = zysk.setScale(2, RoundingMode.CEILING);
        return zysk;
    }

    @Override
    public double breakInterest() {
        return interest.getBalance();
    }

    @Override
    public BigDecimal closeInterest() {
        return calculate().add(BigDecimal.valueOf(interest.getBalance()));
    }
}
