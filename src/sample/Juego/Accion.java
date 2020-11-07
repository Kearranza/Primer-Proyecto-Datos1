package sample.Juego;

/**
 * The type Accion.
 * Nodo de la lista Historial
 */
public class Accion {
    private Accion next = null;
    private Accion prev = null;
    private String valor;

    /**
     * Instantiates a new Accion.
     *
     * @param valor the valor
     */
    public Accion(String valor) {
        this.valor = valor;
    }

    /**
     * Gets next.
     *
     * @return the next
     */
    public Accion getNext() {
        return next;
    }

    /**
     * Sets next.
     *
     * @param next the next
     */
    public void setNext(Accion next) {
        this.next = next;
    }

    /**
     * Gets valor.
     *
     * @return the valor
     */
    public String getValor() {
        return valor;
    }

    /**
     * Gets prev.
     *
     * @return the prev
     */
    public Accion getPrev() {
        return prev;
    }

    /**
     * Sets prev.
     *
     * @param prev the prev
     */
    public void setPrev(Accion prev) {
        this.prev = prev;
    }
}
