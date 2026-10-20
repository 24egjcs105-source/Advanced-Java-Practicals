import java.io.*;
import java.net.*;

public class server {

    public static void main(String[] args) {

        try {
            // Create ServerSocket on port 5000
            ServerSocket serverSocket = new ServerSocket(5000);

            System.out.println("Server started...");
            System.out.println("Waiting for client...");

            // Accept client connection
            Socket socket = serverSocket.accept();

            System.out.println("Client connected.");

            // Read data from client
            BufferedReader input = new BufferedReader(
                    new InputStreamReader(socket.getInputStream())
            );

            // Send data to client
            PrintWriter output = new PrintWriter(
                    socket.getOutputStream(), true
            );

            // Receive message
            String message = input.readLine();

            System.out.println("Client: " + message);

            // Send response
            output.println("Hello Client, message received successfully.");

            // Close connections
            input.close();
            output.close();
            socket.close();
            serverSocket.close();

            System.out.println("Server stopped.");

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}