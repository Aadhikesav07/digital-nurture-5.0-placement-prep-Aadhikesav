import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ChatServer {
    private static final int PORT = 5000;

    public static void main(String[] args) throws Exception {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Server waiting for client...");

            try (Socket socket = serverSocket.accept();
                 BufferedReader fromClient = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                 BufferedWriter toClient = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
                 BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in))) {
                System.out.println("Client connected");

                while (true) {
                    String message = fromClient.readLine();
                    if (message == null || "bye".equals(message)) {
                        break;
                    }

                    System.out.println("Client: " + message);
                    System.out.print("Server: ");
                    String reply = keyboard.readLine();
                    toClient.write(reply);
                    toClient.newLine();
                    toClient.flush();
                }
            }
        }
    }
}
