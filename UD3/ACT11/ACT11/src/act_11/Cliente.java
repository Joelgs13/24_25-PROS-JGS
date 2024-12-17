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
 * The Cliente class is responsible for establishing a TCP connection with the server
 * to exchange strings of characters. It sends each string to the server, 
 * receives the uppercase response, and displays it to the user. 
 * The communication ends when the client sends the "*" character.
 */
public class Cliente {
    /**
     * Main method to start the client program.
     *
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        final String SERVER_ADDRESS = "localhost";
        final int SERVER_PORT = 6000;

        System.out.println("CLIENT PROGRAM STARTING");

        try (
            Socket sck = new Socket(SERVER_ADDRESS, SERVER_PORT);
            BufferedReader consola = new BufferedReader(new InputStreamReader(System.in));
            BufferedReader in = new BufferedReader(new InputStreamReader(sck.getInputStream()));
            PrintWriter out = new PrintWriter(sck.getOutputStream(), true)
        ) {
            String stringToUppercase;

            while (true) {
                System.out.print("Introduce una cadena:\n");
                stringToUppercase = consola.readLine();
                out.println(stringToUppercase);
                
                if (stringToUppercase.equals("*")) {
                	System.out.println("=>Respuesta:*");
                    System.out.println("Fin del envío....");
                    break;
                } else {
                	String response = in.readLine();
                    System.out.println("=>Respuesta:" + response);
                }
            }
        } catch (Exception e) {
            System.err.println("Error connecting to server: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
