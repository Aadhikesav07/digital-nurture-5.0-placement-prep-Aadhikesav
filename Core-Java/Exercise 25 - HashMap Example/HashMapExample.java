import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class HashMapExample {
    public static void main(String[] args) {
        Map<Integer, String> students = new HashMap<>();

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("How many students to add? ");
            int count = scanner.nextInt();
            scanner.nextLine();

            for (int i = 0; i < count; i++) {
                System.out.print("Enter student ID: ");
                int id = scanner.nextInt();
                scanner.nextLine();

                System.out.print("Enter student name: ");
                students.put(id, scanner.nextLine());
            }

            System.out.print("Enter ID to search: ");
            int id = scanner.nextInt();
            String name = students.get(id);

            if (name == null) {
                System.out.println("Student not found");
            } else {
                System.out.println("Name: " + name);
            }
        }
    }
}
