import java.util.Scanner;

public class ArraySumAverage {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter number of elements: ");
            int count = scanner.nextInt();
            int[] numbers = new int[count];
            int sum = 0;

            for (int i = 0; i < numbers.length; i++) {
                numbers[i] = scanner.nextInt();
                sum += numbers[i];
            }

            double average = numbers.length == 0 ? 0 : (double) sum / numbers.length;
            System.out.println(sum);
            System.out.println(average);
        }
    }
}
