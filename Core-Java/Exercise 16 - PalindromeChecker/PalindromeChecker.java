import java.util.Scanner;

public class PalindromeChecker {
    private static String clean(String text) {
        return text.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
    }

    private static boolean isPalindrome(String text) {
        String cleaned = clean(text);
        int left = 0;
        int right = cleaned.length() - 1;

        while (left < right) {
            if (cleaned.charAt(left) != cleaned.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter a string: ");
            String text = scanner.nextLine();
            System.out.println(isPalindrome(text) ? "Palindrome" : "Not a palindrome");
        }
    }
}
