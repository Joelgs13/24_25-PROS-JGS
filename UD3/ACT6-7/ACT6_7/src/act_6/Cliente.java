//problem solving
//the principal issue I had was that, when I tried to pass the integer to the server, it doesn’t work okay. The problem was that I was using on the server dataImputStream and DataOutputStream and in the client I was using bufferedwriter and bufferedreadre. So when in the client I was reading text, in the server I was recibing a binary value. The 2 of them need to use the same read/write protocol.
package act_6;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

/**
 * The Client class connects to a server on port 6010.
 * It sends an integer to the server, receives the squared value in response,
 * and displays the result.
 */
public class Cliente {

    /**
     * Main method to start the client.
     * The client connects to the server, sends an integer input by the user,
     * and receives the squared result from the server.
     *
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        String serverAddress = "localhost"; // Server address to connect to
        int port = 6010; // Port number for communication

        System.out.println("PROGRAMA CLIENTE INICIANDO");

        try (Socket connection = new Socket(serverAddress, port); // Establish socket connection
             DataOutputStream writer = new DataOutputStream(connection.getOutputStream()); // Output stream to the server
             DataInputStream reader = new DataInputStream(connection.getInputStream()); // Input stream from the server
             Scanner userInput = new Scanner(System.in)) { // Scanner for user input

            // Input a number from the user
            System.out.println("Introduce un número");
            int number = userInput.nextInt();

            // Send the number to the server
            writer.writeInt(number);

            // Receive and display the squared number from the server
            int response = reader.readInt();
            System.out.println("Recibiendo mensaje del servidor: \n\tEl cuadrado del número " + number + " es " + response);

        } catch (IOException ex) {
            System.err.println("Error en la comunicación con el servidor: " + ex.getMessage());
        }
    }
}
