import com.example.FelineInt;
import com.example.Lion;
import org.junit.Before;
import org.junit.Test;
import org.junit.runners.Parameterized;

import java.util.Collection;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class LionParameterizedTest extends ParameterizedTestBase<String, Boolean> {

    private Lion lion;
    private FelineInt felineMock;

    public LionParameterizedTest(String sex, Boolean expectedMane) {
        super(sex, expectedMane);
    }

    @Before
    public void setUp() throws Exception {
        felineMock = mock(FelineInt.class);
        lion = new Lion(felineMock, input);
    }

    @Test
    public void testDoesHaveMane() {
        assertEquals(expected, lion.doesHaveMane());
    }

    @Parameterized.Parameters(name = "Лев ({0}): {1}")
    public static Collection<Object[]> data() {
        return java.util.Arrays.asList(new Object[][] {
                {"Самец", true},
                {"Самка", false}
        });
    }
}
