package sample.Juego.Cartas.Hechizos;

import sample.Controllers.ControllerTablero;
import sample.Juego.Cartas.Carta;

/**
 * @author Bryan Martínez y Kevin Carranza
 * The type Cero absoluto.
 * Esta es la clase CeroAbsoluto que se encarga de almacenar los datos de una carta de este tipo(Clase hija de Carta).
 */
public class CeroAbsoluto extends Carta {
    /**
     * Instantiates a new Cero absoluto.
     * @param coste  the coste
     * @param imagen the imagen
     */
    public CeroAbsoluto(int coste, String imagen) {
        super(coste, imagen, "H", false);
    }
    @Override
    public void accion(){
        ControllerTablero.setCongelado(true);
    }
}
