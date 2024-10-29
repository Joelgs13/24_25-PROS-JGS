package act_14;

// TODO: Auto-generated Javadoc
/**
 * The Class Hilo.
 */
class Hilo extends Thread { 
	
	/** The a. */
	Recurso a; 
	
	/** The b. */
	Recurso b; 
	
	/**
	 * Instantiates a new hilo.
	 *
	 * @param a the a
	 * @param b the b
	 * @param nombre the nombre
	 */
	public Hilo(Recurso a, Recurso b,String nombre) { 
		super(nombre); 
		this.a = a; 
		this.b = b; 
	} 
	
	/**
	 * Run.
	 */
	public void run(){ 
		System.out.println("Hilo " + this.getName() + " comienza"); 
		synchronized(a) { 
			try { 
				Thread.sleep(100); 
			} catch (InterruptedException e) { 
				e.printStackTrace(); 
			} 
			synchronized(b) { 
			
			} 
			System.out.println("Hilo " + this.getName() + " ha terminado"); 
		} 
	} 
}

class Recurso{
	
}
