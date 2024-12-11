//problem solving
//when i was codifying the client class, i noticed that i was getting a imput Mismatch exception, without me typing anything. When i was looking at the code, i saw i was not declarating de Tenista class es serializable.


package act_10;

import java.io.Serializable;

/**
 * The Tenista class represents a tennis player with attributes for surname and height.
 * Implements the Serializable interface to allow serialization of objects of this class.
 */
public class Tenista implements Serializable {
    private static final long serialVersionUID = 1L;
    private String apellido;
    private int altura;

    /**
     * Constructor for the Tenista class.
     *
     * @param apellido the surname of the tennis player
     * @param altura the height of the tennis player in centimeters
     */
    public Tenista(String apellido, int altura) {
        this.apellido = apellido;
        this.altura = altura;
    }

    /**
     * Gets the surname of the tennis player.
     *
     * @return the surname of the tennis player
     */
    public String getApellido() {
        return apellido;
    }

    /**
     * Sets the surname of the tennis player.
     *
     * @param apellido the new surname of the tennis player
     */
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    /**
     * Gets the height of the tennis player.
     *
     * @return the height of the tennis player in centimeters
     */
    public int getAltura() {
        return altura;
    }

    /**
     * Sets the height of the tennis player.
     *
     * @param altura the new height of the tennis player in centimeters
     */
    public void setAltura(int altura) {
        this.altura = altura;
    }

    /**
     * Returns a string representation of the Tenista object.
     *
     * @return a string representing the surname and height of the tennis player
     */
    @Override
    public String toString() {
        return apellido + " " + altura;
    }
}
