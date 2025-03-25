package org.example;

public class Calculator {

    private static double add(double a, double b) {
        return a + b;
    }

    private static double substract(double a, double b) {
        return a - b;
    }

    private static double multiply(double a, double b) {
        return a * b;
    }

    private static double divible(double a, double b) {
        if (b == 0)
            throw new ArithmeticException("На ноль делить нельзя");
        else
            return a / b;
    }

    private static double power(double a, double b) {
        return Math.pow(a, b);
    }

    public static double sqrt(double a) {
        if (a < 0)
            throw new ArithmeticException("Нельзя возвести отрицательно число");
        else
            return Math.sqrt(a);
    }

    public double calculate(double num1, double num2, String operator) {
        return switch (operator) {
            case "+" -> add(num1, num2);
            case "-" -> substract(num1, num2);
            case "*" -> multiply(num1, num2);
            case "/" -> divible(num1, num2);
            case "^" -> power(num1, num2);
            default -> throw new IllegalArgumentException("Неверный оператор: " + operator);
        };
    }

}
