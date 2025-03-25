package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    private final Calculator calculator = new Calculator();

    @Test
    void testAddition() {
        assertEquals(5, calculator.calculate(2, 3, "+"));
        assertEquals(-1, calculator.calculate(-2, 1, "+"));
        assertEquals(0, calculator.calculate(0, 0, "+"));
    }

    @Test
    void testSubtraction() {
        assertEquals(1, calculator.calculate(3, 2, "-"));
        assertEquals(-3, calculator.calculate(-2, 1, "-"));
        assertEquals(0, calculator.calculate(5, 5, "-"));
    }

    @Test
    void testMultiplication() {
        assertEquals(6, calculator.calculate(2, 3, "*"));
        assertEquals(-6, calculator.calculate(-2, 3, "*"));
        assertEquals(0, calculator.calculate(5, 0, "*"));
    }

    @Test
    void testDivision() {
        assertEquals(2, calculator.calculate(6, 3, "/"));
        assertEquals(-2, calculator.calculate(-6, 3, "/"));
        assertThrows(ArithmeticException.class, () -> calculator.calculate(5, 0, "/"));
    }

    @Test
    void testPower() {
        assertEquals(8, calculator.calculate(2, 3, "^"));
        assertEquals(1, calculator.calculate(5, 0, "^"));
        assertEquals(0.25, calculator.calculate(2, -2, "^"));
    }

    @Test
    void testSqrt() {
        assertEquals(3, Calculator.sqrt(9));
        assertEquals(2, Calculator.sqrt(4));
        assertThrows(ArithmeticException.class, () -> Calculator.sqrt(-1));
    }

    @Test
    void testInvalidOperator() {
        assertThrows(IllegalArgumentException.class, () -> calculator.calculate(5, 2, "%"));
    }
}
