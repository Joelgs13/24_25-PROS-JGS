package Act_2;

// TODO: Auto-generated Javadoc
/**
 * The Class Hilo, that represents a thread. Is the class that haves the method to run the Threads
 */
public class Hilo extends Thread{
	
	/** The variable used to get the number of thread created. */
	int Nhilo;
	
	/**
	 * Instantiates a new hilo, so it gets the number too
	 *
	 * @param numeroDeHilo the numero de hilo
	 */
	public Hilo (int numeroDeHilo) {
		this.Nhilo=numeroDeHilo;
	}
	
	/**
	 * The method to run the threads maded. It uses the getName method of the interface Thread to name each of the threads respectively.
	 */
	public void run(){
		for (int i=1;i<21;i++)
		System.out.println("Hilo "+ this.Nhilo);
	}
}