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
 * The Class Actividad1.
 */
public class Actividad1 {
	
	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		System.out.println("Direcciones asociadas a Spotify:\n");
		try {
			InetAddress[] ips = InetAddress.getAllByName("www.spotify.com");
			for (InetAddress ip : ips) {
				System.out.println(ip);
			}
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
