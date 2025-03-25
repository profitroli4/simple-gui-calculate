package org.example;

import javafx.scene.control.TextArea;

public class CalculatorController {
    private final Calculator calculator = new Calculator();
    private double firstNumber = 0;
    private String operator = "";
    private boolean startNewNumber = true;
    private final TextArea display;

    public CalculatorController(TextArea display) {
        this.display = display;
    }

    public void onDigitPress(String digit) {
        if (startNewNumber) {
            display.appendText(digit);
            startNewNumber = false;
        } else {
            display.appendText(digit);
        }
    }

    public void onOperatorPress(String op) {
        if (!display.getText().isEmpty()) {
            firstNumber = Double.parseDouble(display.getText());
            operator = op;
            startNewNumber = true;

            display.setText(firstNumber + " " + operator + "\n");
        }
    }

    public void onEqualsPress() {
        if (!operator.isEmpty() && !display.getText().isEmpty()) {
            String[] lines = display.getText().split("\n");

            if (lines.length < 2) return;

            double secondNumber;
            try {
                secondNumber = Double.parseDouble(lines[1].replace(operator, "").trim());
            } catch (NumberFormatException e) {
                display.appendText("\nОшибка ввода");
                return;
            }

            if (operator.equals("/") && secondNumber == 0) {
                display.appendText("\nОшибка: деление на ноль");
                startNewNumber = true;
                return;
            }

            double result = calculator.calculate(firstNumber, secondNumber, operator);
            display.appendText("\n= " + result);
            startNewNumber = true;
        }
    }

    public void onSqrtPress() {
        if (!display.getText().isEmpty()) {
            double num = Double.parseDouble(display.getText());
            double result = calculator.sqrt(num);
            display.setText("√" + num + "\n= " + result);
            startNewNumber = true;
        }
    }

    public void onClearPress() {
        display.setText("");
        firstNumber = 0;
        operator = "";
        startNewNumber = true;
    }
}
