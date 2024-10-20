package Act_5;

/**
 * The Class Actividad5.runs the programs primero and segundo and shows a final output
 */
public class Actividad5 {
	
	/**
	 * The main method. creates and primero and a Segundo threads and starts them
	 *
	 * @param arg the arguments
	 */
	public static void main(String arg[]) {
		Primero p = new Primero();
		Segundo s = new Segundo();
		p.start();
		s.start();
		System.out.println("Fin programa");
	}
}
