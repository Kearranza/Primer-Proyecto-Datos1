package sample.Juego.Cartas.Secretos;

import sample.Juego.Cartas.Carta;

/**
 * @author Bryan Martínez y Kevin Carranza
 * The type Barrera drenadora.
 *Esta es la clase BarrreraDrenadora que se encarga de almacenar los datos de una carta de este tipo(Clase hija de Carta).
 */
public class BarreraDrenadora extends Carta {
    /**
     * Instantiates a new Barrera drenadora.
     *
     * @param coste  the coste
     * @param imagen the imagen
     */
    public BarreraDrenadora(int coste, String imagen) {
        super(coste, imagen, "S", false);
    }

    @Override
    public void accion(){

    }

}
