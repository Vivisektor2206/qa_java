import com.example.FelineInt;
import com.example.Lion;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class LionTest {

    @Test
    public void testGetKittens_DelegatesToFeline() throws Exception {
        FelineInt felineMock = mock(FelineInt.class);
        Lion lion = new Lion(felineMock, "Самец");

        when(felineMock.getKittens()).thenReturn(2);
        int kittens = lion.getKittens();
        assertEquals(2, kittens);
        verify(felineMock).getKittens();
    }

    @Test
    public void testGetFood_DelegatesToFeline() throws Exception {
        FelineInt felineMock = mock(FelineInt.class);
        Lion lion = new Lion(felineMock, "Самец");

        List<String> expectedFood = List.of("Мясо антилопы");
        when(felineMock.getFood("Хищник")).thenReturn(expectedFood);
        List<String> actualFood = lion.getFood();
        assertEquals(expectedFood, actualFood);
        verify(felineMock).getFood("Хищник");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testLion_InvalidSexThrowsException() throws Exception {
        FelineInt felineMock = mock(FelineInt.class);
        new Lion(felineMock, "Неизвестный");
    }
}
