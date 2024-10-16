package Act_3;

/**
 * The Class Actividad3. the one that makes all the excersise in the main method
 */
public class Actividad3 {
	
	/**
	 * The main method. Supposed to make 3 outputs showing how you get the values of a thread and changes it before another output.
	 *
	 * @param arg the arguments
	 */
	public static void main(String arg[]) {
		Thread thr=new Thread();
		System.out.println("El nombre del hilo es "+thr.getName() + " y tiene la prioridad " + thr.getPriority());
		thr.setName("SUPER-HILO-DM2");
		thr.setPriority(6);
		System.out.println("Ahora El nombre del hilo es "+thr.getName() + " y tiene la prioridad " + thr.getPriority());
		System.out.print("Final programa");
	}
}
