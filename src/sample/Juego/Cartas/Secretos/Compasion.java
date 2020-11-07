package sample.Juego.Cartas.Secretos;

import sample.Juego.Cartas.Carta;

/**
 * @author Bryan Martínez y Kevin Carranza
 * The type Compasion.
 *Esta es la clase Compasion que se encarga de almacenar los datos de una carta de este tipo(Clase hija de Carta).
 */
public class Compasion extends Carta {
    /**
     * Instantiates a new Compasion.
     *
     * @param coste  the coste
     * @param imagen the imagen
     */
    public Compasion(int coste, String imagen) {
        super(coste, imagen, "S", false);
    }
    @Override
    public void accion(){

    }

}
