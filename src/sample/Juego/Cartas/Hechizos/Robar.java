package sample.Juego.Cartas.Hechizos;

import sample.Juego.Cartas.Carta;

/**
 * @author Bryan Martínez y Kevin Carranza
 * The type Robar.
 *Esta es la clase Robar que se encarga de almacenar los datos de una carta de este tipo(Clase hija de Carta).
 */
public class Robar extends Carta {
    /**
     * Instantiates a new Robar.
     * @param coste  the coste
     * @param imagen the imagen
     */
    public Robar(int coste, String imagen) {
        super(coste, imagen, "H", true);
    }
    @Override
    public void accion(){

    }
}
