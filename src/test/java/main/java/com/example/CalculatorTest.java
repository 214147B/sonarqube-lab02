package main.java.com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @Test
    void testAdd() {
        assertEquals(15, calculator.calculate(10, 5, "add"));
    }

    @Test
    void testSubtract() {
        assertEquals(5, calculator.calculate(10, 5, "sub"));
    }

    @Test
    void testMultiply() {
        assertEquals(50, calculator.calculate(10, 5, "mul"));
    }

    @Test
    void testDivide() {
        assertEquals(2, calculator.calculate(10, 5, "div"));
    }

    @Test
    void testDivideByZero() {
        assertEquals(0, calculator.calculate(10, 0, "div"));
    }

    @Test
    void testMod() {
        assertEquals(1, calculator.calculate(10, 3, "mod"));
    }

    @Test
    void testModByZero() {
        assertEquals(0, calculator.calculate(10, 0, "mod"));
    }

    @Test
    void testInvalidOperation() {
        assertEquals(0, calculator.calculate(10, 5, "invalid"));
    }

    @Test
    void testNullOperation() {
        assertEquals(0, calculator.calculate(10, 5, null));
    }

    @Test
    void testAddNumbers() {
        assertEquals(15, calculator.addNumbers(10, 5));
    }
}
