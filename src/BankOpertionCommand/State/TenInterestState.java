package BankOpertionCommand.State;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TenInterestState implements InterestState {

    private static final Logger logger = LoggerFactory.getLogger(TenInterestState.class);

    @Override
    public void calc() {
        logger.info("Oprocentowanie o wysokości 10%");
    }
}
