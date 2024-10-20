package Act_5;
/**
 * The Class Segundo. runs the thread primero
 */
public class Segundo extends Thread { 
	
	/**
	 * Run. runs for 100 times and the 15th time it sleeps a while
	 */
	public void run() {
		for (int i=1, cont =0;i<100;i++,cont++)
		{
			System.out.println( "Segundo " + i );
			if (cont==15) {
				try {
					System.out.println("Sleeping for a while");
					sleep(200);
					cont =0;
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}