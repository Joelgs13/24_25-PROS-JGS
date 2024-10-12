import java.io.*;

public class Actividad11 {
    public static void main(String[] args) {
        Runtime r = Runtime.getRuntime();
        String comando = "java Ejemplo2"; // This will run Ejemplo2 from the command line
        Process p = null;
        try {
            p = r.exec(comando);
            InputStream is = p.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String linea;
            while ((linea = br.readLine()) != null) // Read each line
                System.out.println(linea);
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        // Exit status check: Value = 0 means success, Value = -1 means failure
        int exitVal;
        try {
            exitVal = p.waitFor();
            System.out.println("Exit Value " + exitVal);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
