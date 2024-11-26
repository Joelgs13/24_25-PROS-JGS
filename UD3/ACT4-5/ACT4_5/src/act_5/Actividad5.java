//problem solving
// to make the output match the expected one, i made that the texts like Método toStrong with the tabulation before, are maded on the VisualizarConexion. In that way i can concatenate the text with the result of toString, getStatusCode and getContentType.
package act_5;

import java.io.IOException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.URI;
import java.net.URISyntaxException;


/**
 * This class demonstrates how to use Java's HttpClient and HttpRequest classes
 * to connect to a website and retrieve its response.
 */
public class Actividad5 {

    /**
     * The main method initializes an HTTP client, sends a request to a specific
     * URI, and displays the response details using a helper method.
     *
     * @param args Command-line arguments (not used in this program).
     */
    public static void main(String[] args) {
        System.out.println("Conexión con www.vitoria-gasteiz.com");
        System.out.println("==========================");

        try {
            // Create an HttpClient instance
            HttpClient client = HttpClient.newHttpClient();

            // Build an HttpRequest instance with the specified URI
            HttpRequest request = HttpRequest.newBuilder(new URI("http://www.vitoria-gasteiz.com")).build();

            // Send the request and get the response
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            visualizarConexion(response);
        } catch (IOException |  URISyntaxException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Displays details of the HTTP response, including the string representation,
     * the status code, and the "Content-Type" header value (if present).
     *
     * @param response The HTTP response to be displayed.
     */
    private static void visualizarConexion(HttpResponse<String> response) {
        System.out.println("\tMétodo toString() : " + response);
        System.out.println("\tMétodo getStatusCode() : " + response.statusCode());
        System.out.println("\tMétodo getContentType() : " + response.headers().firstValue("Content-Type").orElse("N/A"));
    }
}
