package act_1;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Actividad1 {
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
