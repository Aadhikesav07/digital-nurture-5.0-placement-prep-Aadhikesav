import java.util.Arrays;
import java.util.List;

public class LambdaSort {
    public static void main(String[] args) {
        List<String> fruits = Arrays.asList("banana", "apple", "pear");
        fruits.sort((first, second) -> first.compareTo(second));

        for (String fruit : fruits) {
            System.out.println(fruit);
        }
    }
}
