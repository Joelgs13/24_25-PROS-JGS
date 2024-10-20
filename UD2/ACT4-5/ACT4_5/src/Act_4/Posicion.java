package Act_4;

/**
 * The Class Posicion. runs the program and controls the execution of "primero and segundo"
 */
public class Posicion implements Runnable {
	
	/** The sw. */
	int sw = 0;
	
	/**
	 * Run. controls for 15 laps each of the outputs for primero and segundo
	 */
	public void run() {
		for (int i=1, j=1;i<16 || j<16;)
			if (sw == 0) {
				System.out.println( "Primero " + i );
				sw = 1;
				i++;
			} else {
				System.out.println( "Segundo " + j );
				sw = 0;
				j++;
			}
	}
}
