package Act_1;

public class Actividad1 {
	public static void main(String arg[]) {
		Hilo h1=new Hilo();
		Hilo h2=new Hilo();
		h1.start();
		h2.start();
		System.out.print("Fin programa");
	}
}