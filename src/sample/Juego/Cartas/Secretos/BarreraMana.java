package sample.Juego.Cartas.Secretos;

import sample.Juego.Cartas.Carta;

/**
 * @author Bryan Martínez y Kevin Carranza
 * The type Barrera mana.
 *Esta es la clase BarreraMana que se encarga de almacenar los datos de una carta de este tipo(Clase hija de Carta).
 */
public class BarreraMana extends Carta {
    /**
     * Instantiates a new Barrera mana.
     *
     * @param coste  the coste
     * @param imagen the imagen
     */
    public BarreraMana(int coste, String imagen) {
        super(coste, imagen, "S", false);
    }

    @Override
    public void accion(){

    }

}
