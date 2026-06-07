import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorCallableDemo {
    private static Future<Integer> addLater(ExecutorService executor, int first, int second) {
        return executor.submit(() -> first + second);
    }

    public static void main(String[] args) throws Exception {
        ExecutorService executor = Executors.newFixedThreadPool(2);

        try {
            Future<Integer> firstResult = addLater(executor, 10, 20);
            Future<Integer> secondResult = addLater(executor, 30, 40);
            Future<Integer> thirdResult = addLater(executor, 50, 60);

            System.out.println("Result 1: " + firstResult.get());
            System.out.println("Result 2: " + secondResult.get());
            System.out.println("Result 3: " + thirdResult.get());
        } finally {
            executor.shutdown();
        }
    }
}
