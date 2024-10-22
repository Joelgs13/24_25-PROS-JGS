package act_10;

public class Hilo extends Thread{
	private String message;
	public Hilo(String mensaje) {
		this.message=mensaje;
	}
	public void run() {
		System.out.println("Ejecutando "+this.message);
	}
}
