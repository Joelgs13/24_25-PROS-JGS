//problem solving
/*
 * I had a problem with the internet connection. When I was trying to run the program,
 * I lost the internet several times and the java program was throwing me a UnknownHostException
 * until I notified that I wasn’t having internet. Apart from that, when I tried to iterate
 * in a for each, I was able to make it on this way, so it was faster and less complex:

	for (InetAddress u:InetAddress.getAllByName(ip.getHostName())) {
					System.out.println(u);
	}

 * much easier than creating a new variable that works as an array of InetAddress(es) outside of the for each
 */
package act_3;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * The Actividad3 class demonstrates how to use the InetAddress class
 * to retrieve and display network information such as IP addresses
 * and hostnames.
 * 
 * The program works in two modes:
 * - If no arguments are provided, it shows information about the local machine.
 * - If an argument (hostname or IP address) is provided, it shows information about that address.
 * 
 * It also displays all IP addresses associated with a hostname.
 */
public class Actividad3 {

    /**
     * Main method of the program.
     * 
     * If no arguments are provided, it retrieves and displays the local machine's
     * network details. If an argument is provided, it retrieves and displays
     * the network details of the specified hostname or IP address.
     * 
     * @param args command-line arguments. If empty, the program displays local
     *             network information. If an argument is provided, it displays
     *             information for the given hostname or IP address.
     */
    public static void main(String[] args) {
        try {
            if (args.length == 0) {
                InetAddress local = InetAddress.getLocalHost();
                System.out.println("Dirección IP: " + local.getHostAddress());
                System.out.println("Nombre: " + local.getHostName());
                System.out.println(local);
                System.out.println(local.getHostAddress() + ".");
                for (InetAddress ip : InetAddress.getAllByName(local.getHostName())) {
                    System.out.println(ip);
                }
            } else {
                InetAddress ip = InetAddress.getByName(args[0]);
                System.out.println("Dirección IP: " + ip.getHostAddress());
                System.out.println("Nombre: " + ip.getHostName());
                System.out.println(ip);
                System.out.println(ip.getHostAddress() + ".");
                for (InetAddress u : InetAddress.getAllByName(ip.getHostName())) {
                    System.out.println(u);
                }
            }
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}

