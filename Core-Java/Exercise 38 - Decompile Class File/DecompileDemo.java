import java.util.List;

public class DecompileDemo {
    private final String name;

    public DecompileDemo(String name) {
        this.name = name;
    }

    public String greet(String message) {
        return name + " says " + message;
    }

    public static int sumEven(List<Integer> numbers) {
        int total = 0;
        for (int value : numbers) {
            if (value % 2 == 0) {
                total += value;
            }
        }
        return total;
    }

    public static void main(String[] args) {
        DecompileDemo demo = new DecompileDemo("Demo");
        System.out.println(demo.greet("Hello"));
        System.out.println(sumEven(List.of(1, 2, 3, 4, 5, 6)));
    }
}
