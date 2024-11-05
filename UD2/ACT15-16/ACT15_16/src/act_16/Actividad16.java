/**
 * Main class for Activity 16.
 * <p>
 * The {@code Actividad16} class initializes a counter and two threads that
 * manipulate the counter in parallel.
 * </p>
 *
 * <p>
 * The two threads, {@link HiloA} and {@link HiloB}, increment and decrement
 * the counter, respectively. This demonstrates synchronized access to shared
 * resources.
 * </p>
 *
 * @since 1.0
 */
package act_16;

public class Actividad16 {
    /**
     * Main method to start the program.
     * <p>
     * This method creates a {@link Contador} instance with an initial value,
     * and starts two threads ({@link HiloA} and {@link HiloB}) that perform
     * operations on the shared counter.
     * </p>
     *
     * @param args Command-line arguments (not used in this example).
     */
    public static void main(String[] args) {
        Contador cont = new Contador(100);
        HiloA a = new HiloA("HiloA", cont);
        HiloB b = new HiloB("HiloB", cont);
        a.start();
        b.start();
    }
}
