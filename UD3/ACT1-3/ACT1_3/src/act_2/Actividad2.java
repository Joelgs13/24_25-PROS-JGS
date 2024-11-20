//problem solving
/*
 * the main problem in this activity, was that i didn’t knew how to validate if the args of 0 
 * content was a IP host. So for doing that, i handle the exception so it shows if the program
 *  was able to locate that host past as a parameter or not.
 * */

package act_2;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * The Actividad2 class demonstrates how to use the InetAddress class
 * to retrieve and display all IP addresses associated with a given hostname.
 * It also checks if the first IP address is reachable within a specified timeout.
 */
public class Actividad2 {

    /**
     * Main method of the program.
     * 
     * This method retrieves all IP addresses associated with a hostname provided as
     * a command-line argument. It checks if the first address is reachable and 
     * displays the associated addresses. If no valid hostname is provided, 
     * it shows an appropriate message.
     * 
     * @param args command-line arguments. The first argument should be a hostname or URL.
     */
    public static void main(String[] args) {
        InetAddress[] ips;
        try {
            ips = InetAddress.getAllByName(args[0]);
            if (ips[0].isReachable(5000)) {
                System.out.println("Las direcciones asociadas a " + ips[0].getHostName() + " son:\n");
                for (InetAddress ip : ips) {
                    System.out.println(ip);
                }
            } else {
                System.out.println("Se necesita una URL para obtener su dirección");
            }
        } catch (UnknownHostException e) {
            System.out.println("Se necesita una URL para obtener su dirección");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
