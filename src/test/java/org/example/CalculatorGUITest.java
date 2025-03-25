package org.example;

import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.testfx.framework.junit5.ApplicationTest;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorGUITest extends ApplicationTest {

    private TextArea display;
    private final int CLICK_DELAY = 500;

    @Override
    public void start(Stage stage) {

        CalculatorGUI calculatorGUI = new CalculatorGUI();
        calculatorGUI.start(stage);

        this.display = lookup(".text-area").query();
    }

    @BeforeEach
    public void resetCalculator() {
        clickOnWithDelay("C");
    }


    private void clickOnWithDelay(String label) {
        clickOn(label);
        sleep(CLICK_DELAY);
    }

    @Test
    public void testDigitInput() {
        clickOnWithDelay("7");
        assertEquals("7", display.getText().trim());
    }

    @Test
    public void testOperatorInput() {
        clickOnWithDelay("7");
        clickOnWithDelay("+");
        String expected = "7.0 +";
        assertEquals(expected, display.getText().trim());
    }

    @Test
    public void testEqualsPress() {
        clickOnWithDelay("7");
        clickOnWithDelay("+");
        clickOnWithDelay("3");
        clickOnWithDelay("=");
        String expected = "7.0 +\n3\n= 10.0";
        assertEquals(expected, display.getText().trim());
    }

    @Test
    public void testSqrtPress() {
        clickOnWithDelay("9");
        clickOnWithDelay("√");
        String expected = "√9.0\n= 3.0";
        assertEquals(expected, display.getText().trim());
    }

    @Test
    public void testClearPress() {
        clickOnWithDelay("7");
        clickOnWithDelay("+");
        clickOnWithDelay("3");
        clickOnWithDelay("C");
        assertEquals("", display.getText().trim());
    }

    @Test
    public void testDivideByZero() {
        clickOnWithDelay("7");
        clickOnWithDelay("/");
        clickOnWithDelay("0");
        clickOnWithDelay("=");
        String expected = "7.0 /\n0\nОшибка: деление на ноль";
        assertEquals(expected, display.getText().trim());
    }
}
