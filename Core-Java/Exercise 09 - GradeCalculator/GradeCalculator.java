import java.util.Scanner;

public class GradeCalculator {
    private static String gradeFor(int marks) {
        if (marks >= 90) {
            return "A";
        }
        if (marks >= 80) {
            return "B";
        }
        if (marks >= 70) {
            return "C";
        }
        if (marks >= 60) {
            return "D";
        }
        return "F";
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter marks out of 100: ");
            int marks = scanner.nextInt();
            System.out.println(gradeFor(marks));
        }
    }
}
