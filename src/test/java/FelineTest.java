import com.example.Feline;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

public class FelineTest {

    @Test
    public void testGetFamily() {
        Feline feline = new Feline();
        assertEquals("Кошачьи", feline.getFamily());
    }

    @Test
    public void testGetKittens() {
        Feline feline = new Feline();
        assertEquals(1, feline.getKittens());
    }

    @Test
    public void testGetFoodForPredator() throws Exception {
        Feline feline = new Feline();
        List<String> food = feline.getFood("Хищник");
        assertEquals(Arrays.asList("Мясо", "Птица", "Рыба"), food);
    }

    @Test
    public void testGetFoodForNonPredator() throws Exception {
        Feline feline = new Feline();
        List<String> food = feline.getFood("Травоядное");
        assertTrue(food.isEmpty());
    }

    @Test
    public void testEatMeat() throws Exception {
        Feline feline = new Feline();
        List<String> meat = feline.eatMeat();
        assertEquals(Arrays.asList("Мясо", "Птица", "Рыба"), meat);
    }


    @Test
    public void testMultipleCallsToEatMeatReturnListsWithSameContent() throws Exception {
        Feline feline = new Feline();
        List<String> firstCall = feline.eatMeat();
        List<String> secondCall = feline.eatMeat();
        assertEquals(firstCall, secondCall);
    }

    @Test
    public void testMultipleCallsToEatMeatReturnDifferentObjectInstances() throws Exception {
        Feline feline = new Feline();
        List<String> firstCall = feline.eatMeat();
        List<String> secondCall = feline.eatMeat();
        assertNotSame(firstCall, secondCall);
    }

    @Test
    public void testGetFoodReturnsListsWithSameContentOnMultipleCalls() throws Exception {
        Feline feline = new Feline();
        List<String> firstCall = feline.getFood("Хищник");
        List<String> secondCall = feline.getFood("Хищник");
        assertEquals(firstCall, secondCall);
    }

    @Test
    public void testGetFoodReturnsDifferentListInstancesOnMultipleCalls() throws Exception {
        Feline feline = new Feline();
        List<String> firstCall = feline.getFood("Хищник");
        List<String> secondCall = feline.getFood("Хищник");
        assertNotSame(firstCall, secondCall);
    }

}
