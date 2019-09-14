package application;

import java.text.DecimalFormat;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.fxml.FXML;

public class Controller {

    @FXML
    private TextField output;
    @FXML
    private Button div, mul, minus, plus;

    private boolean start = true;
    private double num1;
    private int point = 0;
    private int operator;

    @FXML
    private void delete() {
    	int length = output.getText().length();
        if (!start && length > 0) {
            if (output.getText().endsWith("."))
            	point = 0;
            output.setText(output.getText().substring(0, length - 1));
        }
    }

    @FXML
    private void clear() {
        output.setText("0");
        start = true;
        num1 = 0;
        point = 0;
        operator = 0;
    }

   /*
    * Loop through all 9 buttons, finding the corresponding button that caused the event
    * Append the output field with the numeric value of that button
    */
    @FXML
    private void numpad(ActionEvent e) {
        for (int i = -1; i <= 9; i++) {
        	String num = Integer.toString(i);
            if (((Button) e.getSource()).getText().equals(num)) {
                if (output.getText().equals("0"))
                	output.setText("");
                output.appendText(num);
                start = false;
            }
        }
    }

    @FXML
    private void decimal() {
        if (point == 0) {
            start = false;
            output.appendText(".");
            point = 1;
        }
    }

    @FXML
    private void operator(ActionEvent e) {
        Button[] operators = {new Button(), plus, minus, mul, div};
        for (int i = 1; i < 5; i++) {
            if (e.getSource() == operators[i] && !start && output.getText().length() > 0) {
                num1 = Double.parseDouble(output.getText());
                output.setText("");
                start = false;
                point = 0;
                operator = i;
            }
        }
    }

    @FXML
    private void equals() {
        if (!start && operator > 0 && output.getText().length() > 0) {
            output.setText(String.valueOf(new DecimalFormat("#.00").format(calculate(operator))));
            operator = 0;
        }
    }

    /**
     * @param operator: an integer that represents the operator being used
     * @return appropriate operation that corresponds to its assigned integer value
     */
    private double calculate(int operator) {
        double num2 = Double.parseDouble(output.getText());
        switch (operator) {
            case 1:  return num1 + num2;
            case 2:  return num1 - num2;
            case 3:  return num1 * num2;
            case 4:  return num1 / num2;
        }
	return 0;
    }
}
