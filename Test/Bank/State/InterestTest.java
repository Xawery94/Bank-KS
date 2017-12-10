package Bank.State;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class InterestTest {

    private Interest interest;

    @Before
    public void setUp() {
        interest = new Interest(1000, 3);
    }

    @Test
    public void checkInterestState() {
        assertEquals("class Bank.State.TenInterestState", interest.getInterestState().getClass().toString());
    }

    @Test
    public void shouldCalculateInterest(){
        interest.calculateInterest();

    }
}