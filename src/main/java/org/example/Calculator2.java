package org.example;
import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;
import javax.swing.*;
import javax.swing.border.LineBorder;

//I'm following a video to make this advanced calculator

public class Calculator2 {
    int boardWidth = 360;
    int boardHeight = 540;

    Color customLightGray = new Color(212, 212, 210);
    Color customDarkGray = new Color(80, 80,80);
    Color customBlack = new Color(255,149,0);


    JFrame frame = new JFrame("Calculator =)");
    JLabel displayLabel = new JLabel();
    JPanel displayPanel = new JPanel();
    JPanel buttonsPanel = new JPanel();

    String[] buttonValues = {
            "AC", "+/-", "%", "÷",
            "7", "8", "9", "×",
            "4", "5", "6", "-",
            "1", "2", "3", "+",
            "0", ".", "√", "="
    };
    String[] rightSymbols = {"÷", "×", "-", "="};
    String[] topSymbols = "AC", "+/-", "%"};

    Calculator()
        frame.setVisible(true);
        frame.setSize(boardWidth, boardHeight);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFram.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout())

        displayLabel.setBackground(customBlack);
        displayLabel.setForeground(Color.white);
        displayLabel.setFont(new Font("Arial", Font.PLAIN, 80));
        displayLabel.setHorizontalAlignment(JLabel.RIGHT);
        displayLabel.setText("0");
        displayLabel.setOpaque(true);

        displayPanel.setLayout(new BorderLayout());
        displayPanel.add(displayLabel);
        frame.add(displayPanel, BorderLayout.NORTH);

        buttonsPanel.setLayout(new GridLayout(5,4));
        buttonsPanel.setBackgrund(customBlack);
        frame.add(buttonsPanel);

        for (int i = 0; i < buttonValues.lenght; i++) {
            JButton button = new JButton();
            String buttonValue = buttonValues[i];
            button.setFont(new Font("Arial", Font.PLAIN, 30));
            button.setText(buttonValue);
}

