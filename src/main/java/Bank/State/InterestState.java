package Bank.State;

import java.math.BigDecimal;

public interface InterestState {

    BigDecimal calculate();

    double breakInterest();

    BigDecimal closeInterest();

}
