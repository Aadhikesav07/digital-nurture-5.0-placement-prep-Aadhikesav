import java.util.Scanner;

public class FactorialCalculator {
    private static long factorialOf(int number) {
        long factorial = 1;

        for (int i = 2; i <= number; i++) {
            factorial *= i;
        }

        return factorial;
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter a non-negative integer: ");
            int number = scanner.nextInt();
            System.out.println(factorialOf(number));
        }
    }
}
