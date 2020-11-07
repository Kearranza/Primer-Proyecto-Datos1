package sample.Juego.Cartas.Hechizos;

import sample.Controllers.ControllerTablero;
import sample.Juego.Cartas.Carta;

/**
 * @author Bryan Martínez y Kevin Carranza
 * The type Reglas antiguas.
 *
 */
public class ReglasAntiguas extends Carta {
    /**
     * Instantiates a new Reglas antiguas.
     *
     * @param coste  the coste
     * @param imagen the imagen
     */
    public ReglasAntiguas(int coste, String imagen) {
        super(coste, imagen, "H", false);
    }
    public void accion(){
        ControllerTablero.setGratis(1);
    }
}
