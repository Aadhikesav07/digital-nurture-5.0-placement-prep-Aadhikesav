import java.util.Scanner;

public class Exercise21 {
    private static void checkAge(int age) throws InvalidAgeException {
        if (age < 18) {
            throw new InvalidAgeException("Age must be at least 18");
        }
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter age: ");
            int age = scanner.nextInt();

            try {
                checkAge(age);
                System.out.println("Age accepted: " + age);
            } catch (InvalidAgeException exception) {
                System.out.println(exception.getMessage());
            }
        }
    }
}
