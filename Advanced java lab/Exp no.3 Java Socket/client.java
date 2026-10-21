import java.io.*;
import java.net.*;

public class client {

    public static void main(String[] args) {

        try {
            // Connect to server
            Socket socket = new Socket("localhost", 5000);

            System.out.println("Connected to server.");

            // Send message to server
            PrintWriter output = new PrintWriter(
                    socket.getOutputStream(), true
            );

            // Receive response from server
            BufferedReader input = new BufferedReader(
                    new InputStreamReader(socket.getInputStream())
            );

            // Message to server
            output.println("Hello Server");

            // Read server response
            String response = input.readLine();

            System.out.println("Server: " + response);

            // Close connections
            output.close();
            input.close();
            socket.close();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}