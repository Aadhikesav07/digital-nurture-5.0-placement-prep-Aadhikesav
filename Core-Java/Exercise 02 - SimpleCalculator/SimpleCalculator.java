import java.util.Scanner;

public class SimpleCalculator {
    private static Double calculate(double firstNumber, double secondNumber, String operator) {
        return switch (operator) {
            case "+" -> firstNumber + secondNumber;
            case "-" -> firstNumber - secondNumber;
            case "*" -> firstNumber * secondNumber;
            case "/" -> secondNumber == 0 ? null : firstNumber / secondNumber;
            default -> 0.0;
        };
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter first number: ");
            double firstNumber = scanner.nextDouble();

            System.out.print("Enter second number: ");
            double secondNumber = scanner.nextDouble();

            System.out.print("Enter operation (+, -, *, /): ");
            String operator = scanner.next();

            Double result = calculate(firstNumber, secondNumber, operator);
            if (result == null) {
                System.out.println("Cannot divide by zero");
                return;
            }

            System.out.println("Result: " + result);
        }
    }
}
