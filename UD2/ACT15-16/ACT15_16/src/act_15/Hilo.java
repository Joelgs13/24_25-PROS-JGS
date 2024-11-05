package act_15;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Hilo extends Thread{

	int number;
	DateTimeFormatter format = DateTimeFormatter.ofPattern("HH:mm:ss");
	public Hilo (int number) {
		this.number=number;
	}
	
	@Override
	public void run() {
		for (int cont = 1;cont <=5;cont++) {
			System.out.println("Hilo "+this.number + " - "+LocalTime.now().format(format));
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
