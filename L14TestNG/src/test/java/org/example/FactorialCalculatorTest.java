package org.example;

import org.testng.Assert;
import org.testng.annotations.Test;

public class FactorialCalculatorTest {

    @Test
    public void testFactorialOfZero() {
        long result = FactorialCalculator.factorial(0);
        Assert.assertEquals(result, 1);
    }

    @Test
    public void testFactorialOfPositiveNumber() {
        long result = FactorialCalculator.factorial(5);
        Assert.assertEquals(result, 120);
    }

    @Test
    public void testFactorialOfOne() {
        long result = FactorialCalculator.factorial(1);
        Assert.assertEquals(result, 1);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testFactorialOfNegativeNumber() {
        FactorialCalculator.factorial(-1); // Ожидается выброс исключения
    }
}
