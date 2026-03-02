import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;
import javax.swing.*;
import javax.swing.border.LineBorder;

public class Calculator2 {

    public static void main(String[] args) {
        new Calculator2();
    }

    int boardWidth = 360;
    int boardHeight = 540;

    Color customLightGray = new Color(212, 212, 210);
    Color customDarkGray = new Color(80, 80, 80);
    Color customPink = new Color(245, 39, 156);

    String[] buttonValues = {
            "AC", "+/-", "%", "÷",
            "7", "8", "9", "×",
            "4", "5", "6", "-",
            "1", "2", "3", "+",
            "0", ".", "√", "="
    };

    String[] rightSymbols = {"÷", "×", "-", "+", "="};
    String[] topSymbols = {"AC", "+/-", "%"};

    JFrame frame = new JFrame("Calculator");
    JLabel displayLabel = new JLabel();
    JPanel displayPanel = new JPanel();
    JPanel buttonsPanel = new JPanel();

    String A = "0";
    String operator = null;
    String B = null;

    Calculator2() {

        frame.setSize(boardWidth, boardHeight);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        displayLabel.setBackground(Color.BLACK);
        displayLabel.setForeground(Color.WHITE);
        displayLabel.setFont(new Font("Arial", Font.PLAIN, 60));
        displayLabel.setHorizontalAlignment(JLabel.RIGHT);
        displayLabel.setText("0");
        displayLabel.setOpaque(true);

        displayPanel.setLayout(new BorderLayout());
        displayPanel.add(displayLabel);
        frame.add(displayPanel, BorderLayout.NORTH);

        buttonsPanel.setLayout(new GridLayout(5, 4));
        frame.add(buttonsPanel);

        for (String buttonValue : buttonValues) {

            JButton button = new JButton(buttonValue);
            button.setFont(new Font("Arial", Font.PLAIN, 30));
            button.setFocusable(false);

            if (Arrays.asList(topSymbols).contains(buttonValue)) {
                button.setBackground(customLightGray);
            } else if (Arrays.asList(rightSymbols).contains(buttonValue)) {
                button.setBackground(customPink);
                button.setForeground(Color.WHITE);
            } else {
                button.setBackground(customDarkGray);
                button.setForeground(Color.WHITE);
            }

            buttonsPanel.add(button);

            button.addActionListener(e -> handleButton(buttonValue));
        }

        frame.setVisible(true);
    }

    void handleButton(String value) {

        if (value.equals("AC")) {
            clearAll();
            displayLabel.setText("0");
        } 
        else if ("0123456789.".contains(value)) {
            if (displayLabel.getText().equals("0")) {
                displayLabel.setText(value);
            } else {
                displayLabel.setText(displayLabel.getText() + value);
            }
        } 
        else if (value.equals("=")) {
            if (operator != null) {
                B = displayLabel.getText();
                double numA = Double.parseDouble(A);
                double numB = Double.parseDouble(B);
                double result = 0;

                switch (operator) {
                    case "+": result = numA + numB; break;
                    case "-": result = numA - numB; break;
                    case "×": result = numA * numB; break;
                    case "÷": result = numA / numB; break;
                }

                displayLabel.setText(removeZeroDecimal(result));
                clearAll();
            }
        } 
        else {
            A = displayLabel.getText();
            operator = value;
            displayLabel.setText("0");
        }
    }

    void clearAll() {
        A = "0";
        operator = null;
        B = null;
    }

    String removeZeroDecimal(double num) {
        if (num % 1 == 0) {
            return Integer.toString((int) num);
        }
        return Double.toString(num);
    }
}