import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileWriterExample {
    private static final String FILE_NAME = "Core-Java/output.txt";

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter a string: ");
            String text = scanner.nextLine();

            try (FileWriter writer = new FileWriter(FILE_NAME)) {
                writer.write(text);
                writer.write(System.lineSeparator());
                System.out.println("Written");
            } catch (IOException exception) {
                System.out.println("Error");
            }
        }
    }
}
