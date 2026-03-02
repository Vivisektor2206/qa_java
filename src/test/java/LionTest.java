import com.example.FelineInt;
import com.example.Lion;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class LionTest {

    @Test
    public void testGetKittensDelegatesToFeline() throws Exception {
        FelineInt felineMock = mock(FelineInt.class);
        Lion lion = new Lion(felineMock, "Самец");
        when(felineMock.getKittens()).thenReturn(2);
        int kittens = lion.getKittens();
        assertEquals(2, kittens);
    }

    @Test
    public void testGetKittensCallsFeline() throws Exception {
        FelineInt felineMock = mock(FelineInt.class);
        Lion lion = new Lion(felineMock, "Самец");
        lion.getKittens();
        verify(felineMock).getKittens();
    }

    @Test
    public void testGetFoodDelegatesToFeline() throws Exception {
        FelineInt felineMock = mock(FelineInt.class);
        Lion lion = new Lion(felineMock, "Самец");
        List<String> expectedFood = List.of("Мясо антилопы");
        when(felineMock.getFood("Хищник")).thenReturn(expectedFood);
        List<String> actualFood = lion.getFood();
        assertEquals(expectedFood, actualFood);
    }

    @Test
    public void testGetFoodCallsFeline() throws Exception {
        FelineInt felineMock = mock(FelineInt.class);
        Lion lion = new Lion(felineMock, "Самец");
        lion.getFood();
        verify(felineMock).getFood("Хищник");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testLionInvalidSexThrowsException() throws Exception {
        FelineInt felineMock = mock(FelineInt.class);
        new Lion(felineMock, "Неизвестный");
    }

    @Test
    public void testLionValidMaleCreatesInstance() throws Exception {
        FelineInt felineMock = mock(FelineInt.class);
        Lion lion = new Lion(felineMock, "Самец");
        assertTrue(lion.doesHaveMane());
    }

    @Test
    public void testLionValidFemaleCreatesInstance() throws Exception {
        FelineInt felineMock = mock(FelineInt.class);
        Lion lion = new Lion(felineMock, "Самка");
        assertFalse(lion.doesHaveMane());
    }
}

