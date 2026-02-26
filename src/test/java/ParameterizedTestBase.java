import org.junit.Before;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import java.util.Collection;

@RunWith(Parameterized.class)
public abstract class ParameterizedTestBase<T, R> {

    protected T input;
    protected R expected;

    public ParameterizedTestBase(T input, R expected) {
        this.input = input;
        this.expected = expected;
    }

    @Parameters
    public static Collection<Object[]> data() {
        return null;
    }
}
