//probkem solving 
/*i had a big problem when tried to do the excersise on my personal computer because 
 * it didn’t work… I didn’t know why i guessed that was because i wasn’t in the class
 *  network because i was using my personal phone as an access point to my laptop. I 
 *  maded the excersise on the class computer and it works now*/
package act_2;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import java.io.IOException;

/**
 * This class demonstrates the use of the Apache Commons Net library to connect to an FTP server,
 * create a folder structure, and manage the FTP connection.
 */
public class Actividad2 {

    /**
     * Main method to execute the FTP operations.
     *
     * @param args Command-line arguments (not used in this example).
     */
    public static void main(String[] args) {
        // FTP server details
        String server = "172.20.14.139";
        int port = 21;
        String user = "dinux";
        String pass = "dinux";

        // FTP client instance
        FTPClient ftpClient = new FTPClient();

        try {
            System.out.println("Nos conectamos a " + server);
            ftpClient.connect(server, port);

            // Attempt to login to the FTP server
            boolean login = ftpClient.login(user, pass);
            if (login) {
                System.out.println("Login correcto");

                // Display the current working directory
                String currentDir = ftpClient.printWorkingDirectory();
                System.out.println("Directorio actual: " + currentDir);

                // Folder structure creation
                String baseFolder = "aplicacionwebgonzalezsalgado";
                String[] subFolders = {"html", "imagenes", "css"};

                // Set file type and mode
                ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
                ftpClient.enterLocalPassiveMode();

                // Create the base folder
                boolean baseFolderCreated = ftpClient.makeDirectory(baseFolder);
                boolean allFoldersCreated = baseFolderCreated;

                // Create subfolders within the base folder
                if (baseFolderCreated) {
                    for (String subFolder : subFolders) {
                        allFoldersCreated &= ftpClient.makeDirectory(baseFolder + "/" + subFolder);
                    }
                }

                // Check if all folders were created successfully
                if (allFoldersCreated) {
                    System.out.println("Directorios creados...");
                } else {
                    System.out.println("NO SE HAN PODIDO CREAR LOS DIRECTORIOS");
                }

                // Logout from the server
                boolean logout = ftpClient.logout();
                if (logout) {
                    System.out.println("Logout del servidor FTP...");
                } else {
                    System.out.println("Error al hacer logout");
                }

            } else {
                System.out.println("Login incorrecto...");
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                // Disconnect from the server if connected
                if (ftpClient.isConnected()) {
                    ftpClient.disconnect();
                    System.out.println("Desconectado...");
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}
