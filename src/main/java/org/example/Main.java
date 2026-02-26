package org.example;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Write a number");
        double number1 = scanner.nextDouble();
        System.out.println("Write a second number");
        double number2 = scanner.nextDouble();

        Calculator calculator = new Calculator();

        System.out.println("Choose an operation (+ - * /)");
        char operator = scanner.next().charAt(0);
        double result;

        if (operator == '+') {
            result = calculator.add(number1, number2);
        } else if (operator == '-') {
            result = calculator.subtract(number1, number2);
        } else if (operator == '*') {
            result = calculator.multiply(number1, number2);
        } else if (operator == '/') {
            result = calculator.divide(number1, number2);
        } else {
            System.out.println("Invalid operator");
            return;
        }
        System.out.println(number1 + " " + operator + " " + number2 + " = " + result);
    }
}
