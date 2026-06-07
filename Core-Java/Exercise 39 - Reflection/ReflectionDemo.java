import java.lang.reflect.Method;

public class ReflectionDemo {
    public static void sayHello(String name) {
        System.out.println("Hello " + name + " via reflection");
    }

    public static void main(String[] args) throws Exception {
        Class<?> demoClass = Class.forName("ReflectionDemo");

        for (Method method : demoClass.getDeclaredMethods()) {
            System.out.println("Method: " + method.getName());
            for (Class<?> parameter : method.getParameterTypes()) {
                System.out.println("Parameter: " + parameter.getSimpleName());
            }
        }

        Method method = demoClass.getMethod("sayHello", String.class);
        method.invoke(null, "Student");
    }
}
