package com.example;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class FelineImplTest {

    private FelineImpl feline;
    private int inputKittens;
    private int expectedKittens;

    @Parameters(name = "getKittens({0}) = {1}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {0, 0},
                {1, 1},
                {3, 3},
                {5, 5}
        });
    }

    public FelineImplTest(int input, int expected) {
        this.inputKittens = input;
        this.expectedKittens = expected;
    }

    @Before
    public void setUp() {
        feline = new FelineImpl();
    }

    @Test
    public void testGetFamily() {
        assertEquals("Кошачьи", feline.getFamily());
    }

    @Test
    public void testGetKittens() {
        assertEquals(1, feline.getKittens());
    }

    @Test
    public void testGetKittensWithParameter() {
        assertEquals(expectedKittens, feline.getKittens(inputKittens));
    }

    @Test
    public void testGetFoodForPredator() throws Exception {
        List<String> food = feline.getFood("Хищник");
        assertEquals(Arrays.asList("Мясо", "Птица", "Рыба"), food);
    }

    @Test
    public void testGetFoodForNonPredator() throws Exception {
        List<String> food = feline.getFood("Травоядное");
        assertTrue(food.isEmpty());
    }

    @Test
    public void testEatMeat() throws Exception {
        List<String> meat = feline.eatMeat();
        assertEquals(Arrays.asList("Мясо", "Птица", "Рыба"), meat);
    }
}