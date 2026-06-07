import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class ChatClient {
    private static final String HOST = "localhost";
    private static final int PORT = 5000;

    public static void main(String[] args) throws Exception {
        try (Socket socket = new Socket(HOST, PORT);
             BufferedReader fromServer = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             BufferedWriter toServer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
             BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in))) {
            while (true) {
                System.out.print("Client: ");
                String message = keyboard.readLine();
                toServer.write(message);
                toServer.newLine();
                toServer.flush();

                if ("bye".equals(message)) {
                    break;
                }

                String reply = fromServer.readLine();
                System.out.println("Server: " + reply);
            }
        }
    }
}
