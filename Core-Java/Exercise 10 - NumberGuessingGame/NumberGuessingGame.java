import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Random random = new Random();
        int secretNumber = random.nextInt(100) + 1;

        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.print("Guess the number (1-100): ");
                int guess = scanner.nextInt();

                if (guess == secretNumber) {
                    System.out.println("Correct");
                    break;
                }

                System.out.println(guess < secretNumber ? "Too low" : "Too high");
            }
        }
    }
}
