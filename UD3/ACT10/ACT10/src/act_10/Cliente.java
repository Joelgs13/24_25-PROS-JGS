//problem solving
//when i was codifying the client class, i noticed that i was getting a imput Mismatch exception, without me typing anything. When i was looking at the code, i saw i was not declarating de Tenista class es serializable.

package act_10;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * Client class that represents the UDP client for sending and receiving Tenista objects.
 * It sends a Tenista object to the server, waits for a response, and displays the modified object.
 */
public class Cliente {
    /**
     * Main method that executes the logic of the UDP client.
     *
     * @param args command-line arguments
     */
    public static void main(String[] args) {
        Tenista delPotro = new Tenista("del Potro", 198);

        try (DatagramSocket clientSocket = new DatagramSocket(34567)) {
            // Serialize the Tenista object
            ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
            ObjectOutputStream objectStream = new ObjectOutputStream(byteStream);
            objectStream.writeObject(delPotro);
            objectStream.flush();
            byte[] sendBuffer = byteStream.toByteArray();

            // Configure the UDP packet
            InetAddress serverAddress = InetAddress.getByName("localhost");
            DatagramPacket sendPacket = new DatagramPacket(sendBuffer, sendBuffer.length, serverAddress, 12348);

            // Send the packet
            clientSocket.send(sendPacket);
            System.out.println("Sending the object: " + delPotro.getApellido() + " " + delPotro.getAltura());

            // Wait for the server's datagram
            System.out.println("Waiting for datagram.......");
            byte[] receiveBuffer = new byte[1024];
            DatagramPacket receivePacket = new DatagramPacket(receiveBuffer, receiveBuffer.length);
            clientSocket.receive(receivePacket);

            // Deserialize the received object
            ByteArrayInputStream byteInputStream = new ByteArrayInputStream(receivePacket.getData());
            ObjectInputStream objectInputStream = new ObjectInputStream(byteInputStream);
            Tenista receivedTenista = (Tenista) objectInputStream.readObject();

            // Display the modified object
            System.out.println("Received the object: " + receivedTenista.getApellido() + " " + receivedTenista.getAltura());
            System.out.println("Client terminated");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
