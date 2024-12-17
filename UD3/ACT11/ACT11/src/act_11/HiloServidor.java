//problem solving
//my personal issue with this activity was that i didn’t know how 
//to pass the control of the client operations to the HiloServidor, 
//but i handled it as you can se in the solution part comunicating 
//with it and writing on the Servidor console the output instead of 
//ussing the HiloServidor console
package act_11;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * The HiloServidor class manages communication with a connected client in a separate thread.
 * It listens for strings from the client, processes them by converting to uppercase,
 * and sends the transformed strings back to the client.
 * The communication ends when the client sends the termination string "*".
 */
public class HiloServidor extends Thread {
    private Socket socket;

    /**
     * Constructs a HiloServidor instance for handling client communication.
     *
     * @param socket The client socket that establishes the connection.
     */
    public HiloServidor(Socket socket) {
        this.socket = socket;
    }

    /**
     * Runs the thread, managing communication with the connected client.
     * Reads input strings from the client, processes them, and sends back the uppercase version.
     * Communication ends gracefully when the termination string "*" is received.
     */
    @Override
    public void run() {
        try (
            BufferedReader inputReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter outputWriter = new PrintWriter(socket.getOutputStream(), true)
        ) {
            String clientMessage;

            while ((clientMessage = inputReader.readLine()) != null) {
                System.out.println("Comunico con: " + socket);

                if ("*".equals(clientMessage)) {
                    System.out.println("Fin de la conexión con: " + socket);
                    break;
                }

                String uppercaseMessage = clientMessage.toUpperCase();
                outputWriter.println(uppercaseMessage);
            }
        } catch (Exception e) {
            System.err.println("Error communicating with the client: " + e.getMessage());
            e.printStackTrace();
        } finally {
            closeSocket();
        }
    }

    /**
     * Closes the client socket to release resources.
     */
    private void closeSocket() {
        try {
            if (socket != null && !socket.isClosed()) {
                socket.close();
            }
        } catch (Exception e) {
            System.err.println("Error closing the socket: " + e.getMessage());
        }
    }
}
