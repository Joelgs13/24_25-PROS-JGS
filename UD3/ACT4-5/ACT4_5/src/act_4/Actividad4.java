//Problem solving
//I make the Visualizar(URI uri) but i give a String like the parameter. Create a new URI in the constructor of Visualizar in the main method
package act_4;

import java.net.URI;
import java.net.URISyntaxException;

public class Actividad4 {

	private static void visualizar(URI url) {
		System.out.println("URI: "+url);
		System.out.println("\tHost: "+url.getHost());
		System.out.println("\tPort: "+url.getPort());
		System.out.println("\tPath: "+url.getPath());
		System.out.println("\tScheme: "+url.getScheme());
		System.out.println("\tAuthority: "+url.getAuthority());
	}
	
	public static void main(String[] args) {
		try {
			URI oracle = new URI("http://docs.oracle.com");
			URI oracleJavase7 = new URI("http://docs.oracle.com/javase/7");
			URI oracleURL = new URI("http://docs.oracle.com/javase/7/docs/api/java/net/URL.html");
			visualizar(oracle);
			visualizar(oracleJavase7);
			visualizar(oracleURL);
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}

	}

	

}