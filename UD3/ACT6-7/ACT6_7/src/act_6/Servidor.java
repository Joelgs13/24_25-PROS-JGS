//problem solving
//the principal issue I had was that, when I tried to pass the integer to the server, it doesn’t work okay. The problem was that I was using on the server dataImputStream and DataOutputStream and in the client I was using bufferedwriter and bufferedreadre. So when in the client I was reading text, in the server I was recibing a binary value. The 2 of them need to use the same read/write protocol.
package act_6;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * The Server class listens for a client connection on port 6010.
 * It receives an integer from the client, calculates its square,
 * and sends the squared value back to the client.
 */
public class Servidor {

    /**
     * Main method to start the server.
     * It listens on port 6010, accepts a client connection, processes data,
     * and sends back the result.
     *
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(6010)) {
            System.out.println("Waiting for a client...");
            try (Socket clientConnection = serverSocket.accept();
                 DataInputStream inputStream = new DataInputStream(clientConnection.getInputStream());
                 DataOutputStream outputStream = new DataOutputStream(clientConnection.getOutputStream())) {

                // Receive the number from the client
                int number = inputStream.readInt();
                
                // Calculate the square of the number
                int squaredResult = number * number;

                // Send the result back to the client
                outputStream.writeInt(squaredResult);
            }
        } catch (IOException ex) {
            System.err.println("Error on the server: " + ex.getMessage());
        }
    }
}
