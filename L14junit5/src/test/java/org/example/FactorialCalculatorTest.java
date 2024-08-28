package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class FactorialCalculatorTest {

    @Test
    void testFactorialOfZero() {
        // Факториал 0 равен 1
        assertEquals(1, FactorialCalculator.factorial(0));
    }

    @Test
    void testFactorialOfPositiveNumber() {
        // Факториал 5 равен 120
        assertEquals(120, FactorialCalculator.factorial(5));
    }

    @Test
    void testFactorialOfLargeNumber() {
        // Факториал 10 равен 3628800
        assertEquals(3628800, FactorialCalculator.factorial(10));
    }

    @Test
    void testFactorialThrowsExceptionForNegativeNumber() {
        // Ожидается исключение при передаче отрицательного числа
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            FactorialCalculator.factorial(-1);
        });
        assertEquals("Число должно быть неотрицательным", exception.getMessage());
    }
}
