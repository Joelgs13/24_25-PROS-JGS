package Act_2;

// TODO: Auto-generated Javadoc
/**
 * The Class Actividad2.
 */
public class Actividad2 {
	
	/** The n. */
	static int n = 3;
	
	/**
	 * The main method. Runs the aplication, generating n threads passed as an argument and instanciates them with a number equal to the loop laps.
	 *
	 * @param arg the arguments
	 */
	public static void main(String arg[]) {
		try {
			for (int i = 1;i<=n;i++) {
				Act_2.Hilo h=new Act_2.Hilo(i);
				h.start();			
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			System.out.println("Final Programa");
		}
	}
	
}
