/**
 * Package act_4 contains a class to demonstrate the usage of the URI class in Java.
 */
//problem solving
//For making the program to work, I made that the, visualizar method to recive a Uri as a parameter, and I instanciate in the main method 3 URI objects. 
package act_4;

import java.net.URI;
import java.net.URISyntaxException;

/**
 * The {@code Actividad4} class demonstrates the usage of the {@link URI} class
 * to parse and display information about URIs.
 */
public class Actividad4 {

    /**
     * Displays the components of a given {@link URI}.
     *
     * @param url the URI to be analyzed and displayed.
     */
    private static void visualizar(URI url) {
        System.out.println("URI: " + url);
        System.out.println("\tHost: " + url.getHost());
        System.out.println("\tPort: " + url.getPort());
        System.out.println("\tPath: " + url.getPath());
        System.out.println("\tScheme: " + url.getScheme());
        System.out.println("\tAuthority: " + url.getAuthority());
    }

    /**
     * The main method demonstrates creating and analyzing multiple URIs.
     *
     * @param args command-line arguments (not used in this program).
     */
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
