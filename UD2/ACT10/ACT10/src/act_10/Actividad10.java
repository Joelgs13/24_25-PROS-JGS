

package act_10;
// TODO: Auto-generated Javadoc

/**
 * The Class Actividad10. That instanciates a thread main and 2 hilo objects and runs the hilos
 */
public class Actividad10 {
	
	/**
	 * The main method. first instanciates a thread and 2 hilos, then changes the 
	 * priority of the hilos, sets a new name to the thread, shows the output
	 * and starts the threads
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		Thread main = new Thread();
		Hilo thread0 = new Hilo("Hilo-prioridad 3");
		Hilo thread1 = new Hilo("Hilo-prioridad 7");
		thread0.setPriority(3);
		thread1.setPriority(7);
		main.setName("main");
		System.out.println(main.getName()+" tiene la prioridad "+main.getPriority());
		System.out.println(thread0.getName()+" tiene la prioridad "+thread0.getPriority());
		System.out.println(thread1.getName()+" tiene la prioridad "+thread1.getPriority());
		thread1.start();
		thread0.start();
		System.out.println("final programa");
	}
}
