package sample.Juego.Cartas.Hechizos;

import sample.Controllers.ControllerTablero;
import sample.Juego.Cartas.Carta;

/**
 * @author Bryan Martínez y Kevin Carranza
 * The type Reglas antiguas.
 *Esta es la clase ReglasAntiguas que se encarga de almacenar los datos de una carta de este tipo(Clase hija de Carta).
 */
public class ReglasAntiguas extends Carta {
    /**
     * Instantiates a new Reglas antiguas.
     * @param coste  the coste
     * @param imagen the imagen
     */
    public ReglasAntiguas(int coste, String imagen) {
        super(coste, imagen, "H", false);
    }
    @Override
    public void accion(){
        ControllerTablero.setGratis(1);
    }
}
