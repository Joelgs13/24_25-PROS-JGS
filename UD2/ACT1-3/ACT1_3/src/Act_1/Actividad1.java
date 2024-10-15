package Act_1;

/**
 * The Class Actividad1.
 */
public class Actividad1 {
	
	/**
	 * The main method, creates 2 Hilo objects and runs this ones, showing a final comment of the program ending
	 *
	 * @param arg the arguments
	 */
	public static void main(String arg[]) {
		Hilo h1=new Hilo();
		Hilo h2=new Hilo();
		h1.start();
		h2.start();
		System.out.print("Fin programa");
	}
}