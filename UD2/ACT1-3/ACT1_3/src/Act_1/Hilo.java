package Act_1;

public class Hilo extends Thread{
	public void run(){
		for (int i=1;i<20;i++)
		System.out.println(this.getName()+" " + i);
	}
}