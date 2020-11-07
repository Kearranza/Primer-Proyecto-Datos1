package sample.Juego.Cartas.Secretos;

import sample.Juego.Cartas.Carta;

/**
 * @author Bryan Martínez y Kevin Carranza
 * The type Vacio.
 * Esta es la clase Vacio que se encarga de almacenar los datos de una carta de este tipo(Clase hija de Carta).
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
    @Override
    public void accion(){

    }

}
