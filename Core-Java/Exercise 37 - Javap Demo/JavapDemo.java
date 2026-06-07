public class JavapDemo {
    public int square(int number) {
        return number * number;
    }

    public static void main(String[] args) {
        JavapDemo demo = new JavapDemo();
        System.out.println("Square: " + demo.square(5));
    }
}
