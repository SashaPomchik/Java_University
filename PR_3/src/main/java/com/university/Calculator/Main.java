package com.university.Calculator;

import com.university.Calculator.exceptions.InvalidInputException;
import com.university.Calculator.service.Calculator;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        Scanner scanner = new Scanner(System.in);
        double num1, num2;
        String operation;

        try {
            System.out.print("Enter first number: ");
            num1 = scanner.nextDouble();

            System.out.print("Enter second number: ");
            num2 = scanner.nextDouble();

            System.out.print("Enter the operation (+, -, *, /, sqrt): ");
            operation = scanner.next();

            double result;
            switch (operation) {
                case "+":
                    result = calculator.add(num1, num2);
                    System.out.println("Addition result: " + result);
                    break;
                case "-":
                    result = calculator.subtract(num1, num2);
                    System.out.println("Subtraction result: " + result);
                    break;
                case "*":
                    result = calculator.multiply(num1, num2);
                    System.out.println("Multiplication result: " + result);
                    break;
                case "/":
                    result = calculator.divide(num1, num2);
                    System.out.println("Division result: " + result);
                    break;
                case "sqrt":
                    result = calculator.sqrt(num1);
                    System.out.println("Square root of first number: " + result);
                    break;
                default:
                    System.out.println("Unknown operation.");
            }
        } catch (ArithmeticException | InvalidInputException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (InputMismatchException e) {
            System.out.println("Error: Invalid input. Please enter a number.");
        } finally {
            System.out.println("Request processing completed.");
        }

        scanner.close();
    }
}
