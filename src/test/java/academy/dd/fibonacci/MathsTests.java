package academy.dd.fibonacci;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class MathsTests {

    @Test(expected = Exception.class)
    public void passNegativeValue() throws Exception {
        Maths.fibonacci(-4);
    }

    @Test
    public void sequenceShouldBeZeroBased() throws Exception {
        assertThat("Sequence should start with 0", Maths.fibonacci(0), is(0L));
    }

    @Test
    public void standardSequenceShouldBeAccurate() throws Exception {
        List<Long> fibSeq = new ArrayList<>();
        for(int i = 0; i < 10; i++) {
            fibSeq.add(Maths.fibonacci(i));
        }
        assertThat("Position 1 should be 0", fibSeq.get(0), is(0L));
        assertThat("Position 2 should be 1", fibSeq.get(1), is(1L));
        assertThat("Position 3 should be 1", fibSeq.get(2), is(1L));
        assertThat("Position 4 should be 2", fibSeq.get(3), is(2L));
        assertThat("Position 5 should be 3", fibSeq.get(4), is(3L));
        assertThat("Position 6 should be 5", fibSeq.get(5), is(5L));
        assertThat("Position 7 should be 8", fibSeq.get(6), is(8L));
        assertThat("Position 8 should be 13", fibSeq.get(7), is(13L));
        assertThat("Position 9 should be 21", fibSeq.get(8), is(21L));
        assertThat("Position 10 should be 34", fibSeq.get(9), is(34L));
    }
}