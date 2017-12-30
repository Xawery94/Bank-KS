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
public class FiveInterestStateTest {

    @Mock
    FiveInterestState fiveInterestState;

    Interest interest;

    @Before
    public void setUp() {
        interest = new Interest(800, 90);
    }

    @Test
    public void shouldBeCorrectState(){
        assertEquals("class Bank.State.FiveInterestState", interest.getInterestState().getClass().toString());
    }

    @Test
    public void shouldCalculateInterest() {
        interest.calculateInterest();
    }

    @Test
    public void shouldReturnCorrectValueWhenCalculateInterest() {
        interest.calculateInterest();
        when(fiveInterestState.calculate()).thenReturn(BigDecimal.valueOf(9.86));

        assertEquals(BigDecimal.valueOf(9.86),fiveInterestState.calculate());
    }
}