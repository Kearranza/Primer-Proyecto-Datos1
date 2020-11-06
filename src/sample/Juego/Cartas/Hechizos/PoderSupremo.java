package sample.Juego.Cartas.Hechizos;

import sample.Controllers.ControllerTablero;
import sample.Juego.Cartas.Carta;

/**
 * @author Bryan Martínez y Kevin Carranza
 * The type Poder supremo.
 *
 */
public class PoderSupremo extends Carta {
    /**
     * Instantiates a new Poder supremo.
     *
     * @param coste  the coste
     * @param imagen the imagen
     */
    public PoderSupremo(int coste, String imagen) {
        super(coste, imagen, "H", true);
    }

    public void accion(){
        ControllerTablero.setGratis(3);
    }
}
