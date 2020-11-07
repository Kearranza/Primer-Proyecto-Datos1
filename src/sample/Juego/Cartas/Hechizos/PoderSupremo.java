package sample.Juego.Cartas.Hechizos;

import sample.Controllers.ControllerTablero;
import sample.Juego.Cartas.Carta;

/**
 * @author Bryan Martínez y Kevin Carranza
 * The type Poder supremo.
 *Esta es la clase PoderSupremo que se encarga de almacenar los datos de una carta de este tipo(Clase hija de Carta).
 */
public class PoderSupremo extends Carta {
    /**
     * Instantiates a new Poder supremo.
     * @param coste  the coste
     * @param imagen the imagen
     */
    public PoderSupremo(int coste, String imagen) {
        super(coste, imagen, "H", true);
    }
    @Override
    public void accion(){
        ControllerTablero.setGratis(3);
    }
}
