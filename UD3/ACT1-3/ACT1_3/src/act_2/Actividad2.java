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

// TODO: Auto-generated Javadoc
/**
 * The Class Actividad2.
 */
public class Actividad2 {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		InetAddress[] ips;
		try {
			ips = InetAddress.getAllByName(args[0]);
			if (ips[0].isReachable(5000)) {
				//it haves an address, its ok
				System.out.println("Las direcciones asociadas a "+ips[0].getHostName()+" son:\n");
				for (InetAddress ip : ips) {
					System.out.println(ip);
				}
			} else {
				System.out.println("Se necesita una URL para obtener su dirección");
			}
		} catch (UnknownHostException e) { //shows this message when not reaching the host especified in args
			System.out.println("Se necesita una URL para obtener su dirección");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
