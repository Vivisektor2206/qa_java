import com.example.Feline;
import org.junit.Before;
import org.junit.Test;
import org.junit.runners.Parameterized.Parameters;
import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

public class FelineParameterizedTest extends ParameterizedTestBase<Integer, Integer> {

    private Feline feline;

    public FelineParameterizedTest(Integer input, Integer expected) {
        super(input, expected);
    }

    @Before
    public void setUp() {
        feline = new Feline();
    }

    @Test
    public void testGetKittensWithParameter() {
        assertEquals(expected.intValue(), feline.getKittens(input));
    }

    @Parameters(name = "getKittens({0}) = {1}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {0, 0},
                {1, 1},
                {3, 3},
                {5, 5},
                {100, 100}
        });
    }
}

