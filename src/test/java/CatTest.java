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
    public void testGetSound() {
        assertEquals("Мяу", cat.getSound());
    }

    @Test
    public void testGetFood_DelegatesToPredator() throws Exception {
        List<String> expectedFood = Arrays.asList("Мясо", "Птица");
        when(felineMock.eatMeat()).thenReturn(expectedFood);
        List<String> actualFood = cat.getFood();
        assertEquals(expectedFood, actualFood);
        verify(felineMock).eatMeat();
    }

    @Test(expected = Exception.class)
    public void testGetFood_WhenPredatorThrowsException() throws Exception {
        when(felineMock.eatMeat()).thenThrow(new Exception("Ошибка питания"));
        cat.getFood();
    }
    @Test
    public void testGetFood_EmptyListFromPredator() throws Exception {
        when(felineMock.eatMeat()).thenReturn(List.of());
        List<String> actualFood = cat.getFood();
        assertTrue(actualFood.isEmpty());
        verify(felineMock, times(1)).eatMeat();
    }

    @Test
    public void testGetFood_MultipleCalls() throws Exception {
        List<String> expectedFood = List.of("Мясо");
        when(felineMock.eatMeat()).thenReturn(expectedFood);
        List<String> firstCall = cat.getFood();
        List<String> secondCall = cat.getFood();
        assertEquals(expectedFood, firstCall);
        assertEquals(expectedFood, secondCall);
    }
}