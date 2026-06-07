public class VirtualThreadsDemo {
    private static long runVirtualThreadDemo() throws InterruptedException {
        long start = System.currentTimeMillis();
        Thread[] threads = new Thread[100_000];

        for (int i = 0; i < threads.length; i++) {
            int taskId = i;
            threads[i] = Thread.startVirtualThread(() ->
                    System.out.println("Task " + taskId + " running on " + Thread.currentThread())
            );
        }

        for (Thread thread : threads) {
            thread.join();
        }

        return System.currentTimeMillis() - start;
    }

    private static long runPlatformThreadDemo() throws InterruptedException {
        long start = System.currentTimeMillis();
        Thread[] threads = new Thread[1000];

        for (int i = 0; i < threads.length; i++) {
            int taskId = i;
            threads[i] = new Thread(() -> System.out.println("Normal task " + taskId));
            threads[i].start();
        }

        for (Thread thread : threads) {
            thread.join();
        }

        return System.currentTimeMillis() - start;
    }

    public static void main(String[] args) throws Exception {
        long virtualTime = runVirtualThreadDemo();
        System.out.println("Virtual threads time: " + virtualTime + " ms");

        long normalTime = runPlatformThreadDemo();
        System.out.println("Normal threads time for 1000 threads: " + normalTime + " ms");
    }
}
