package Act_1;

/**
 * The Class Hilo, that represents the Primero and Segundo classes all in 1. Is the class that haves the method to run the Threads
 */
public class Hilo extends Thread{
	
	/**
	 * The method to run the threads maded. It uses the getName method of the interface Thread to name each of the threads respectively.
	 */
	public void run(){
		for (int i=1;i<21;i++)
		System.out.println(this.getName()+" " + i);
	}
}