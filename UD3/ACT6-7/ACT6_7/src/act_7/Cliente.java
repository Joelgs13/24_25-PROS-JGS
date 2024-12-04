//problem solving
//my problem was that i wasnt enable to execute the client 3 times, so to do that, i eliminated the for loop that was executing the activity 3 times and execute manualy 3 and 4 times the cliento to ensure the output its ok.
package act_7;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * The Client class connects to the server on localhost and port 6013,
 * receives a greeting message, and displays it.
 */
public class Cliente {

    public static void main(String[] args) {
        System.out.println("PROGRAMA CLIENTE INICIANDO");

        try (Socket clientSocket = new Socket("localhost", 6013);
             DataInputStream inputStream = new DataInputStream(clientSocket.getInputStream())) {

            // Receive and display the message from the server
            System.out.println("Recibiendo mensaje del servidor:");
            System.out.println(inputStream.readUTF());

        } catch (IOException exception) {
            System.out.println("Connection refused: connect");
        }
    }
}
