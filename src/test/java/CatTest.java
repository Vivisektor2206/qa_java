import com.example.Cat;
import com.example.FelineInt;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class CatTest {

    private Cat cat;
    private FelineInt felineMock;

    @Before
    public void setUp() {
        felineMock = mock(FelineInt.class);
        cat = new Cat(felineMock);
    }

    @Test
    public void testGetSound_ReturnsMeow() {
        assertEquals("Мяу", cat.getSound());
    }

    @Test
    public void testGetFood_DelegatesToPredatorAndReturnsExpectedFood() throws Exception {
        List<String> expectedFood = Arrays.asList("Мясо", "Птица");
        when(felineMock.eatMeat()).thenReturn(expectedFood);
        List<String> actualFood = cat.getFood();
        assertEquals(expectedFood, actualFood);
    }

    @Test
    public void testGetFood_CallsEatMeatOnPredator() throws Exception {
        when(felineMock.eatMeat()).thenReturn(List.of("Мясо"));
        cat.getFood();
        verify(felineMock).eatMeat();
    }

    @Test(expected = Exception.class)
    public void testGetFood_WhenPredatorThrowsException_ThrowsException() throws Exception {
        when(felineMock.eatMeat()).thenThrow(new Exception("Ошибка питания"));
        cat.getFood();
    }

    @Test
    public void testGetFood_ReturnsEmptyListWhenPredatorReturnsEmpty() throws Exception {
        when(felineMock.eatMeat()).thenReturn(List.of());
        List<String> actualFood = cat.getFood();
        assertTrue(actualFood.isEmpty());
    }

    @Test
    public void testGetFood_CallsEatMeatOncePerInvocation() throws Exception {
        when(felineMock.eatMeat()).thenReturn(List.of("Мясо"));
        cat.getFood();
        verify(felineMock, times(1)).eatMeat();
    }

    @Test
    public void testGetFood_MultipleCallsReturnsSameData() throws Exception {
        List<String> expectedFood = List.of("Мясо");
        when(felineMock.eatMeat()).thenReturn(expectedFood);
        List<String> firstCall = cat.getFood();
        assertEquals(expectedFood, firstCall);
    }

    @Test
    public void testGetFood_SecondCallReturnsSameData() throws Exception {
        List<String> expectedFood = List.of("Мясо");
        when(felineMock.eatMeat()).thenReturn(expectedFood);
        cat.getFood(); // первый вызов
        List<String> secondCall = cat.getFood();
        assertEquals(expectedFood, secondCall);
    }
}
