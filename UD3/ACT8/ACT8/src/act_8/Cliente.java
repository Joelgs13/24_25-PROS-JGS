//problem solving
//the principal problem I had was that when I was trying to recive the package from the server, I was sending an integer that I didn’t need to send, because the value to process was a byte. So to do that, I created on the server a sendBuffer to, like on the client, so in that way the value it recives and sends its always a byte primitive type, and in that way I can controll its between -128 and 127.
package act_8;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * The Cliente class implements a UDP client that sends a number to a server,
 * waits for the server to calculate its cube, and displays the result.
 */
public class Cliente {

    public static void main(String[] args) {
        byte number = 10; // The number to be sent to the server

        try (DatagramSocket clientSocket = new DatagramSocket(34568)) {

            // Step 1: Send the number to the server
            byte[] sendBuffer = new byte[]{number};
            InetAddress serverAddress = InetAddress.getByName("localhost");
            DatagramPacket sendPacket = new DatagramPacket(sendBuffer, sendBuffer.length, serverAddress, 12346);
            clientSocket.send(sendPacket);

            System.out.println("Esperando respuesta...");

            // Step 2: Receive the result from the server
            byte[] receiveBuffer = new byte[10]; // Buffer to receive the server's response
            DatagramPacket receivePacket = new DatagramPacket(receiveBuffer, receiveBuffer.length);
            clientSocket.receive(receivePacket);

            // Extract and display the result
            String result = new String(receivePacket.getData(), 0, receivePacket.getLength());
            System.out.println("Esperando respuesta....: el cubo de " + number + " es " + result);

        } catch (Exception exception) {
            exception.printStackTrace();
        }

        System.out.println("Adiós…");
    }
}
