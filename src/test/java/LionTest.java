package com.example;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(Parameterized.class)
public class LionTest {

    private Lion lion;
    private FelineInt felineMock;
    private final String sex;
    private final boolean expectedMane;

    @Parameters(name = "Лев ({0}): {1}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                {"Самец", true},
                {"Самка", false}
        });
    }

    public LionTest(String sex, boolean expectedMane) {
        this.sex = sex;
        this.expectedMane = expectedMane;
    }

    @Before
    public void setUp() throws Exception {
        felineMock = mock(FelineInt.class);
        lion = new Lion(felineMock, sex);
    }

    @Test
    public void testDoesHaveMane() {
        assertEquals(expectedMane, lion.doesHaveMane());
    }

    @Test
    public void testGetKittens_DelegatesToFeline() throws Exception {

        when(felineMock.getKittens()).thenReturn(2);
        int kittens = lion.getKittens();
        assertEquals(2, kittens);
        verify(felineMock).getKittens();
    }

    @Test
    public void testGetFood_DelegatesToFeline() throws Exception {
        List<String> expectedFood = List.of("Мясо антилопы");
        when(felineMock.getFood("Хищник")).thenReturn(expectedFood);
        List<String> actualFood = lion.getFood();
        assertEquals(expectedFood, actualFood);
        verify(felineMock).getFood("Хищник");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testLion_InvalidSexThrowsException() throws Exception {
        new Lion(felineMock, "Неизвестный");
    }
}