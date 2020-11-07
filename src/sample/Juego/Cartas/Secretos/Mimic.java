package sample.Juego.Cartas.Secretos;

import sample.Juego.Cartas.Carta;

/**
 * @author Bryan Martínez y Kevin Carranza
 * The type Mimic.
 *Esta es la clase Mimic que se encarga de almacenar los datos de una carta de este tipo(Clase hija de Carta).
 */
public class Mimic extends Carta {
    /**
     * Instantiates a new Mimic.
     *
     * @param coste  the coste
     * @param imagen the imagen
     */
    public Mimic(int coste, String imagen) {
        super(coste, imagen, "S", false);
    }
    @Override
    public void accion(){

    }

}
