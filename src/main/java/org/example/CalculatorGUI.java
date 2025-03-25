package org.example;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CalculatorGUI extends Application {

    private TextArea display;
    private CalculatorController controller;

    @Override
    public void start(Stage primaryStage) {

        display = new TextArea();
        display.setEditable(false);
        display.setWrapText(true);
        display.setPrefRowCount(3);
        display.setStyle("-fx-font-size: 24px;");

        controller = new CalculatorController(display);

        GridPane buttonsGrid = new GridPane();

        buttonsGrid.setHgap(5);
        buttonsGrid.setVgap(5);

        String[] buttonLabels = {
                "^", "√",
                "7", "8", "9", "/",
                "4", "5", "6", "*",
                "1", "2", "3", "-",
                "C", "0", "=", "+"
        };

        int row = 0, col = 2;

        for (String label : buttonLabels) {
            Button btn = new Button(label);
            btn.setMinSize(120, 120);
            btn.setStyle("-fx-font-size: 24px;");
            btn.setOnAction(e -> handleButtonClick(label));

            buttonsGrid.add(btn, col, row);
            col++;

            if (col > 3) {
                col = 0;
                row++;
            }
        }

        VBox root = new VBox(20, display, buttonsGrid);
        root.setAlignment(Pos.CENTER);
        Scene scene = new Scene(root, 500, 800);

        primaryStage.setTitle("Калькулятор");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void handleButtonClick(String label) {
        switch (label) {
            case "C" -> controller.onClearPress();
            case "=" -> controller.onEqualsPress();
            case "+", "-", "*", "/", "^" -> controller.onOperatorPress(label);
            case "√" -> controller.onSqrtPress();
            default -> controller.onDigitPress(label);
        }
    }

    public static void main(String[] args) {
        Application.launch();
    }

}
