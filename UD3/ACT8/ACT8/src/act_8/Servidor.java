//problem solving 
//the principal problem I had was that when I was trying to recive the package from the server, I was sending an integer that I didn’t need to send, because the value to process was a byte. So to do that, I created on the server a sendBuffer to, like on the client, so in that way the value it recives and sends its always a byte primitive type, and in that way I can controll its between -128 and 127.
package act_8;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * The Servidor class implements a UDP server that receives a number from a client,
 * calculates its cube, and sends the result back to the client.
 */
public class Servidor {

    public static void main(String[] args) {
        System.out.println("Esperando datagrama...");

        // Initialize the server socket on port 12346
        try (DatagramSocket serverSocket = new DatagramSocket(12346)) {

            // Step 1: Receive a number from the client
            byte[] receiveBuffer = new byte[1]; // Buffer for receiving a single byte
            DatagramPacket receivePacket = new DatagramPacket(receiveBuffer, receiveBuffer.length);
            serverSocket.receive(receivePacket);

            byte number = receiveBuffer[0]; // Extract the number from the received buffer
            System.out.println("Vamos a calcular el cubo de: " + number);
            System.out.println("IP de origen: " + receivePacket.getAddress());
            System.out.println("Puerto de origen: " + receivePacket.getPort());

            // Step 2: Calculate the cube of the number
            int cube = number * number * number;

            // Step 3: Send the result back to the client
            byte[] sendBuffer = Integer.toString(cube).getBytes(); // Convert the result to bytes
            InetAddress clientAddress = receivePacket.getAddress();
            int clientPort = receivePacket.getPort();
            DatagramPacket sendPacket = new DatagramPacket(sendBuffer, sendBuffer.length, clientAddress, clientPort);
            serverSocket.send(sendPacket);

            System.out.println("Enviamos el resultado..." + cube);

        } catch (Exception exception) {
            exception.printStackTrace();
        }

        System.out.println("Adiósss");
    }
}
