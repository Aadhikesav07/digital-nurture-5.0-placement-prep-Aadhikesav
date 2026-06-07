public class PatternSwitchDemo {
    public static void printType(Object value) {
        String description = switch (value) {
            case Integer number -> "Integer: " + number;
            case String text -> "String: " + text;
            case Double decimal -> "Double: " + decimal;
            default -> "Other type";
        };

        System.out.println(description);
    }

    public static void main(String[] args) {
        printType(5);
        printType("hello");
        printType(3.14);
        printType(true);
    }
}
