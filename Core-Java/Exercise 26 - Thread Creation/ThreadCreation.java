class MessageThread extends Thread {
    private final String message;

    MessageThread(String message) {
        this.message = message;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(message);
            try {
                Thread.sleep(500);
            } catch (InterruptedException exception) {
                System.out.println("Thread interrupted");
                Thread.currentThread().interrupt();
                return;
            }
        }
    }
}

public class ThreadCreation {
    public static void main(String[] args) {
        Thread firstThread = new MessageThread("Hello from thread 1");
        Thread secondThread = new MessageThread("Hello from thread 2");

        firstThread.start();
        secondThread.start();
    }
}
