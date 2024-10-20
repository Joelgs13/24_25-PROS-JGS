package Act_4;

public class Posicion implements Runnable {
	int sw = 0;
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
