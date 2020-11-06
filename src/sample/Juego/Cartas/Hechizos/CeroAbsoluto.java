package sample.Juego.Cartas.Hechizos;

import sample.Controllers.ControllerTablero;
import sample.Juego.Cartas.Carta;

/**
 * The type Cero absoluto.
 */
public class CeroAbsoluto extends Carta {
    /**
     * Instantiates a new Cero absoluto.
     *
     * @param coste  the coste
     * @param imagen the imagen
     */
    public CeroAbsoluto(int coste, String imagen) {
        super(coste, imagen, "H", false);
    }

    public void accion(){
        ControllerTablero.setCongelado(true);
    }
}
