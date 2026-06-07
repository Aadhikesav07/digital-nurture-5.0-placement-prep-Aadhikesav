import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileReaderExample {
    public static void main(String[] args) {
        Path file = Path.of("Core-Java/output.txt");

        try {
            for (String line : Files.readAllLines(file)) {
                System.out.println(line);
            }
        } catch (IOException exception) {
            System.out.println("Error reading");
        }
    }
}
