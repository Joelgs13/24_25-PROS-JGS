/**
 * Thread class that increments the counter.
 * <p>
 * The {@code HiloA} class extends {@link Thread} and performs 300 increments
 * on a shared {@link Contador} instance. After completing the increments, it
 * prints the final counter value.
 * </p>
 *
 * @since 1.0
 */
package act_16;

class HiloA extends Thread {
    private Contador contador;

    /**
     * Constructs a new {@code HiloA} thread with a name and a shared counter.
     *
     * @param n The name of the thread.
     * @param c The shared {@link Contador} instance to operate on.
     */
    public HiloA(String n, Contador c) {
        setName(n);
        contador = c;
    }

    /**
     * Executes the thread's task, incrementing the counter 300 times.
     * <p>
     * This method synchronizes on the {@code Contador} instance to ensure
     * thread-safe access while incrementing. After completion, it prints
     * the final value of the counter.
     * </p>
     */
    public void run() {
        synchronized (contador) {
            for (int j = 0; j < 300; j++) {
                contador.incrementa();
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
