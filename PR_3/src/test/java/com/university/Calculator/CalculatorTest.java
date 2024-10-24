package com.university.Calculator;

import com.university.Calculator.exceptions.InvalidInputException;
import com.university.Calculator.service.Calculator;
import org.junit.Test;
import static org.junit.Assert.*;

public class CalculatorTest {

    private final Calculator calculator = new Calculator();

    @Test
    public void testAddition() {
        double result = calculator.add(5, 3);
        assertEquals(8.0, result, 0.001);
    }

    @Test
    public void testSubtraction() {
        double result = calculator.subtract(10, 4);
        assertEquals(6.0, result, 0.001);
    }

    @Test
    public void testMultiplication() {
        double result = calculator.multiply(2, 3);
        assertEquals(6.0, result, 0.001);
    }

    @Test
    public void testDivision() {
        double result = calculator.divide(10, 2);
        assertEquals(5.0, result, 0.001);
    }

    @Test(expected = ArithmeticException.class)
    public void testDivisionByZero() {
        calculator.divide(10, 0);
    }

    @Test
    public void testSquareRoot() throws InvalidInputException {
        double result = calculator.sqrt(16);
        assertEquals(4.0, result, 0.001);
    }

    @Test(expected = InvalidInputException.class)
    public void testSquareRootOfNegativeNumber() throws InvalidInputException {
        calculator.sqrt(-4);
    }
}
