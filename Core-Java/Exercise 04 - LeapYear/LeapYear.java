import java.util.Scanner;

public class LeapYear {
    private static boolean isLeapYear(int year) {
        return year % 400 == 0 || (year % 4 == 0 && year % 100 != 0);
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter a year: ");
            int year = scanner.nextInt();
            System.out.println(isLeapYear(year) ? "Leap year" : "Not a leap year");
        }
    }
}
