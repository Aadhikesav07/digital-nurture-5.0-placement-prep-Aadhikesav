import java.util.Scanner;

public class StringReversal {
    private static String reverse(String text) {
        StringBuilder reversed = new StringBuilder();
        for (int i = text.length() - 1; i >= 0; i--) {
            reversed.append(text.charAt(i));
        }
        return reversed.toString();
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter a string: ");
            String text = scanner.nextLine();
            System.out.println(reverse(text));
        }
    }
}
