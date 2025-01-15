package act_2;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import java.io.IOException;

public class Actividad2 {

    public static void main(String[] args) {
        String server = "172.20.14.139";
        int port = 21;
        String user = "dinux";
        String pass = "dinux";

        FTPClient ftpClient = new FTPClient();

        try {
            System.out.println("Nos conectamos a " + server);
            ftpClient.connect(server, port);

            boolean login = ftpClient.login(user, pass);
            if (login) {
                System.out.println("Login correcto");

                // Display current directory
                String currentDir = ftpClient.printWorkingDirectory();
                System.out.println("Directorio actual: " + currentDir);

                // Folder structure creation
                String baseFolder = "aplicacionwebgonzalez";
                String[] subFolders = {"html", "imagenes", "css"};

                ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
                ftpClient.enterLocalPassiveMode();

                boolean baseFolderCreated = ftpClient.makeDirectory(baseFolder);
                boolean allFoldersCreated = baseFolderCreated;

                if (baseFolderCreated) {
                    for (String subFolder : subFolders) {
                        allFoldersCreated &= ftpClient.makeDirectory(baseFolder + "/" + subFolder);
                    }
                }

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
