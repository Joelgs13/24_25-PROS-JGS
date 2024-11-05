/**
 * Main class to execute Activity 15.
 * <p>
 * The {@code Activity15} class creates and starts multiple threads.
 * Each thread is an instance of the {@link Hilo} class, which runs code in parallel.
 * </p>
 *
 * <p>
 * This example demonstrates how to start and run multiple threads in parallel in Java.
 * </p>
 *
 * @since 1.0
 */
package act_15;

public class Activity15 {
    /**
     * The main method that starts the program.
     * <p>
     * This method creates three instances of the {@link Hilo} class and starts them in parallel.
     * Each thread is identified by a unique number (1, 2, 3), which is passed
     * as an argument to the {@link Hilo} class constructor.
     * </p>
     *
     * @param args Command line arguments (not used in this example).
     */
    public static void main(String[] args) {
        Hilo h1 = new Hilo(1);
        Hilo h2 = new Hilo(2);
        Hilo h3 = new Hilo(3);
        
        h1.start();
        h2.start();
        h3.start();
    }
}
