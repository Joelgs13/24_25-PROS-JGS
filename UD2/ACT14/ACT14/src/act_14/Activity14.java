package act_14;

// TODO: Auto-generated Javadoc
/**
 * The Class Activity14.
 */
public class Activity14 extends Thread { 
	
	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String args[]) {
		Recurso a = new Recurso(); 
		Recurso b = new Recurso(); 
		Hilo h1 = new Hilo(a, b, "uno");
		//change the order of the atributes!!
		Hilo h2 = new Hilo(a, b, "dos"); 
		h1.start(); 
		h2.start(); 
	}
}
