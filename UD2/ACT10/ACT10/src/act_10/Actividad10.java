

package act_10;

public class Actividad10 {
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
