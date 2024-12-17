//problem solving
//my personal issue with this activity was that i didn’t know how 
//to pass the control of the client operations to the HiloServidor, 
//but i handled it as you can se in the solution part comunicating 
//with it and writing on the Servidor console the output instead of 
//ussing the HiloServidor console

package act_11;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * The Servidor class is responsible for listening for incoming client connections on a specified port.
 * For each client connection, a new thread of the {@link HiloServidor} class is launched
 * to handle client operations independently.
 */
public class Servidor {
    /**
     * The main method starts the server, listens for connections on port 6000,
     * and creates a new thread to handle each connected client.
     *
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        final int PORT = 6000;
        System.out.println("Server started. Listening on port " + PORT);

        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Cliente Conectado.....");

                HiloServidor clientHandler = new HiloServidor(clientSocket);
                clientHandler.start();
            }
        } catch (IOException ex) {
            System.err.println("Error starting the server: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
}
