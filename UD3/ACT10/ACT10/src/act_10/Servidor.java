//problem solving
//when i was codifying the client class, i noticed that i was getting a imput Mismatch exception, without me typing anything. When i was looking at the code, i saw i was not declarating de Tenista class es serializable.
package act_10;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * Server class that represents the UDP server for receiving and sending modified Tenista objects.
 * It receives a Tenista object from a client, modifies its attributes, and sends it back.
 */
public class Servidor {
    /**
     * Main method that executes the logic of the UDP server.
     *
     * @param args command-line arguments
     */
    public static void main(String[] args) {
        try (DatagramSocket serverSocket = new DatagramSocket(12348)) {
            System.out.println("Waiting for datagram.......");

            // Receive the datagram from the client
            byte[] receiveBuffer = new byte[1024];
            DatagramPacket receivePacket = new DatagramPacket(receiveBuffer, receiveBuffer.length);
            serverSocket.receive(receivePacket);

            // Deserialize the received object
            ByteArrayInputStream byteInputStream = new ByteArrayInputStream(receivePacket.getData());
            ObjectInputStream objectInputStream = new ObjectInputStream(byteInputStream);
            Tenista receivedTenista = (Tenista) objectInputStream.readObject();

            System.out.println("Received the object: " + receivedTenista.getApellido() + " " + receivedTenista.getAltura());
            System.out.println("Source IP: " + receivePacket.getAddress());
            System.out.println("Source Port: " + receivePacket.getPort());

            // Modify the Tenista object
            receivedTenista.setApellido("Karlovic");
            receivedTenista.setAltura(208);

            // Serialize the modified object
            ByteArrayOutputStream byteOutputStream = new ByteArrayOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteOutputStream);
            objectOutputStream.writeObject(receivedTenista);
            objectOutputStream.flush();
            byte[] sendBuffer = byteOutputStream.toByteArray();

            // Send the modified object back to the client
            DatagramPacket sendPacket = new DatagramPacket(sendBuffer, sendBuffer.length, receivePacket.getAddress(),
                    receivePacket.getPort());
            serverSocket.send(sendPacket);
            System.out.println("Sending the object: " + receivedTenista.getApellido() + " " + receivedTenista.getAltura());
            System.out.println("Server terminated");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
