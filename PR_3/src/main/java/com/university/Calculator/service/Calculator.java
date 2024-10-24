package com.university.Calculator.service;

import com.university.Calculator.exceptions.InvalidInputException;

public class Calculator {
    public double add(double a, double b) {
        return a + b;
    }

    public double subtract(double a, double b) {
        return a - b;
    }

    public double multiply(double a, double b) {
        return a * b;
    }

    public double divide(double a, double b) throws ArithmeticException {
        if (b == 0) {
            throw new ArithmeticException("Dividing by zero is impossible!.");
        }
        return a / b;
    }

    public double sqrt(double a) throws InvalidInputException {
        if (a < 0) {
            throw new InvalidInputException("You cannot take the square root of a negative number!");
        }
        return Math.sqrt(a);
    }
}
