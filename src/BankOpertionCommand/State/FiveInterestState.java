package BankOpertionCommand.State;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FiveInterestState implements InterestState {

    private static final Logger logger = LoggerFactory.getLogger(FiveInterestState.class);

    @Override
    public void calc() {
        logger.info("Oprocentowanie o wysokości 5%");
    }
}
