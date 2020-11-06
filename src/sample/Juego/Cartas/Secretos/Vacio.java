package sample.Juego.Cartas.Secretos;

import sample.Juego.Cartas.Carta;

/**
 * The type Vacio.
 */
public class Vacio extends Carta {
    /**
     * Instantiates a new Vacio.
     *
     * @param coste  the coste
     * @param imagen the imagen
     */
    public Vacio(int coste, String imagen) {
        super(coste, imagen, "S", false);
    }
    public void accion(){

    }

    /**
     * Condicion.
     */
    public void condicion(){

    }
}
