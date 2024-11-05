/**
 * Counter class to perform increment and decrement operations.
 * <p>
 * The {@code Contador} class represents a simple counter with synchronized methods
 * to safely increment and decrement its value when accessed by multiple threads.
 * </p>
 *
 * @since 1.0
 */
package act_16;

class Contador {
    private int c = 0;

    /**
     * Constructor that initializes the counter to a specified value.
     *
     * @param c The initial value of the counter.
     */
    Contador(int c) {
        this.c = c;
    }

    /**
     * Synchronized method to increment the counter by 1.
     */
    public synchronized void incrementa() {
        c = c + 1;
    }

    /**
     * Synchronized method to decrement the counter by 1.
     */
    public synchronized void decrementa() {
        c = c - 1;
    }

    /**
     * Returns the current value of the counter.
     *
     * @return The current counter value.
     */
    public int getValor() {
        return c;
    }
}
