import java.util.Scanner;

public class TryCatchExample {
    private static int divide(int first, int second) {
        return first / second;
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter first integer: ");
            int first = scanner.nextInt();

            System.out.print("Enter second integer: ");
            int second = scanner.nextInt();

            try {
                System.out.println(divide(first, second));
            } catch (ArithmeticException exception) {
                System.out.println("Cannot divide by zero");
            }
        }
    }
}
