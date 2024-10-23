package act_10;

// TODO: Auto-generated Javadoc
/**
 * The Class Hilo.
 */
public class Hilo extends Thread{
	
	/** The message. */
	private String message;
	
	/**
	 * Instantiates a new hilo.
	 *
	 * @param mensaje the mensaje
	 */
	public Hilo(String mensaje) {
		this.message=mensaje;
	}
	
	/**
	 * Run.
	 */
	public void run() {
		System.out.println("Ejecutando "+this.message);
	}
}
