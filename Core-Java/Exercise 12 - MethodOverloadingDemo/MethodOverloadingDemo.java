public class MethodOverloadingDemo {
    public static int add(int first, int second) {
        return first + second;
    }

    public static double add(double first, double second) {
        return first + second;
    }

    public static int add(int first, int second, int third) {
        return first + second + third;
    }

    public static void main(String[] args) {
        System.out.println(add(2, 3));
        System.out.println(add(2.5, 3.5));
        System.out.println(add(1, 2, 3));
    }
}
