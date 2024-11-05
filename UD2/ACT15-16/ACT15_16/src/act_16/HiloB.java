/**
 * Thread class that decrements the counter.
 * <p>
 * The {@code HiloB} class extends {@link Thread} and performs 300 decrements
 * on a shared {@link Contador} instance. After completing the decrements, it
 * prints the final counter value.
 * </p>
 *
 * @since 1.0
 */
package act_16;

class HiloB extends Thread {
    private Contador contador;

    /**
     * Constructs a new {@code HiloB} thread with a name and a shared counter.
     *
     * @param n The name of the thread.
     * @param c The shared {@link Contador} instance to operate on.
     */
    public HiloB(String n, Contador c) {
        setName(n);
        contador = c;
    }

    /**
     * Executes the thread's task, decrementing the counter 300 times.
     * <p>
     * This method synchronizes on the {@code Contador} instance to ensure
     * thread-safe access while decrementing. After completion, it prints
     * the final value of the counter.
     * </p>
     */
    public void run() {
        synchronized (contador) {
            for (int j = 0; j < 300; j++) {
                contador.decrementa();
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    // Handle exception
                }
            }
            System.out.println(getName() + " contador vale " + contador.getValor());
        }
    }
}
