//problem solving 
// My problem on this activity, was to conect to the public FTP service, i made a mistake
//on the use of connect method to the server and i was having an error, so to solve it i 
//asked chatGPT what was my problem to make a good use of it, then, i used another methot 
//to know if the connection was successful (isPositiveCompletion).
package act_1;

import java.io.IOException;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;

/**
 * A program to interact with the public FTP server of RedIRIS (ftp.rediris.es).
 * The program connects to the server using anonymous credentials, attempts to create a directory,
 * and handles connection, login, directory creation, logout, and disconnection processes.
 * 
 * Features:
 * - Connects to the server ftp.rediris.es.
 * - Logs in using "anonymous" as the username and "dm2" as the password.
 * - Displays the current working directory.
 * - Attempts to create a directory named "DM2PROS".
 * - Logs out and disconnects from the server.
 * 
 * Note: The program uses the Apache Commons Net library for FTP operations.
 */
public class Actividad1 {
    /**
     * The main method that executes the FTP client operations.
     *
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        FTPClient ftpClient = new FTPClient();
        String server = "ftp.rediris.es";
        String user = "anonymous";
        String password = "dm2";

        try {
            System.out.println("Nos conectamos a " + server);
            ftpClient.connect(server);

            if (!FTPReply.isPositiveCompletion(ftpClient.getReplyCode())) {
                ftpClient.disconnect();
                System.out.println("Conexión rechazada: " + ftpClient.getReplyCode());
                return;
            }

            if (ftpClient.login(user, password)) {
                System.out.println("Login correcto");
            } else {
                System.out.println("Login incorrecto...");
                ftpClient.logout();
                return;
            }

            String currentDirectory = ftpClient.printWorkingDirectory();
            System.out.println("Directorio actual:" + currentDirectory);

            String newDirName = "DM2PROS";
            if (ftpClient.makeDirectory(newDirName)) {
                System.out.println("Directorio creado....");
            } else {
                System.out.println("NO SE HA PODIDO CREAR EL DIRECTORIO");
            }

            if (ftpClient.logout()) {
                System.out.println("Logout del servidor FTP...");
            } else {
                System.out.println("Error al hacer logout...");
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                if (ftpClient.isConnected()) {
                    ftpClient.disconnect();
                    System.out.println("Desconectado...");
                }
            } catch (IOException ex) {
                System.out.println("Error al desconectar: " + ex.getMessage());
                ex.printStackTrace();
            }
        }
    }
}
