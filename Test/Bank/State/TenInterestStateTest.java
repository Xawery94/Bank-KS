package Bank.State;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class TenInterestStateTest {

    @Mock
    TenInterestState tenInterestState;

    Interest interest;

    @Before
    public void setUp() {
        interest = new Interest(1000, 60);
    }

    @Test
    public void checkInterestState() {
        assertEquals("class Bank.State.TenInterestState", interest.getInterestState().getClass().toString());
    }

    @Test
    public void shouldCalculateInterest() {
        interest.calculateInterest();
    }

    @Test
    public void shouldReturnCorrectValueWhenCalculateInterest() {
        interest.calculateInterest();
        when(tenInterestState.calculate()).thenReturn(BigDecimal.valueOf(1.67));

        assertEquals(BigDecimal.valueOf(1.67),tenInterestState.calculate());
    }
}