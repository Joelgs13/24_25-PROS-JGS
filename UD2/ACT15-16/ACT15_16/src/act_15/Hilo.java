/**
 * Thread class that prints the current time in a formatted manner.
 * <p>
 * The {@code Hilo} class extends {@link Thread} and is designed to
 * run in parallel with other instances. Each {@code Hilo} instance
 * prints its assigned number and the current time five times, with
 * a one-second pause between each print.
 * </p>
 *
 * <p>
 * The time is formatted according to the pattern {@code "HH:mm:ss"}.
 * </p>
 *
 * @since 1.0
 */
package act_15;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Hilo extends Thread {

    /** Identifier number for this thread. */
    int number;

    /** Formatter for the time output in HH:mm:ss format. */
    DateTimeFormatter format = DateTimeFormatter.ofPattern("HH:mm:ss");

    /**
     * Constructs a new {@code Hilo} thread with a specified number.
     *
     * @param number The unique number assigned to this thread.
     */
    public Hilo(int number) {
        this.number = number;
    }

    /**
     * Executes the thread's task, printing the thread number and current time.
     * <p>
     * This method prints the thread number and the current time in the {@code HH:mm:ss} format,
     * five times, with a one-second delay between each print.
     * </p>
     */
    @Override
    public void run() {
        for (int cont = 1; cont <= 5; cont++) {
            System.out.println("Thread " + this.number + " - " + LocalTime.now().format(format));
            try {
                Thread.sleep(1000); // Pauses the thread for 1 second
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
