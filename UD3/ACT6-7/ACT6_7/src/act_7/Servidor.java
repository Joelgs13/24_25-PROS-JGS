//problem solving
//my problem was that i wasnt enable to execute the client 3 times, so to do that, i eliminated the for loop that was executing the activity 3 times and execute manualy 3 and 4 times the cliento to ensure the output its ok.
package act_7;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * This class represents a server that waits for connections from clients.
 * The server listens on port 6013 and sends a personalized greeting
 * to each of three clients that connect sequentially.
 */
public class Servidor {

    /**
     * The main method starts the server, waits for client connections,
     * and sends a greeting message to each client.
     *
     * @param args Command-line arguments (not used in this program).
     */
    public static void main(String[] args) {
        System.out.println("Esperando a los clientes.....");

        try (ServerSocket serverSocket = new ServerSocket(6013)) {
            for (int clientNumber = 1; clientNumber <= 3; clientNumber++) {
                try (Socket clientSocket = serverSocket.accept();
                     DataOutputStream outputStream = new DataOutputStream(clientSocket.getOutputStream())) {

                    outputStream.writeUTF("Hola cliente " + clientNumber);
                }
            }
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}
