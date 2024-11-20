//problem solving
/*
 *  for making that, in the case there are more than 1 address asociated to spotify,
 *  to get all, my problem was that i didn’t know how to print all of them, so intead 
 *  of using the InetAddress class getByName method, i used the getAllByName in a 
 *  InetAddress array, and iterated over it with a for each loop.
 */
package act_1;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * The Actividad1 class retrieves and displays all IP addresses associated
 * with the hostname "www.spotify.com".
 */
public class Actividad1 {

    /**
     * Main method of the program.
     * 
     * This method retrieves all IP addresses associated with "www.spotify.com"
     * and displays them. If the hostname cannot be resolved, an error is printed.
     * 
     * @param args command-line arguments (not used in this program).
     */
    public static void main(String[] args) {
        System.out.println("Direcciones asociadas a Spotify:\n");
        try {
            InetAddress[] ips = InetAddress.getAllByName("www.spotify.com");
            for (InetAddress ip : ips) {
                System.out.println(ip);
            }
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
