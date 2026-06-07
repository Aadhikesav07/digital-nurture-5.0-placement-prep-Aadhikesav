public class OperatorPrecedence {
    public static void main(String[] args) {
        int normalOrder = 10 + 5 * 2;
        int parenthesizedOrder = (10 + 5) * 2;

        System.out.println(normalOrder);
        System.out.println(parenthesizedOrder);
    }
}
