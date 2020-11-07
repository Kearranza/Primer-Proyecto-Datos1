package sample.Juego.Cartas.Secretos;

import sample.Juego.Cartas.Carta;

/**
 * @author Bryan Martínez y Kevin Carranza
 * The type Gran barrera.
 *Esta es la clase GranBarrera que se encarga de almacenar los datos de una carta de este tipo(Clase hija de Carta).
 */
public class GranBarrera extends Carta {
    /**
     * Instantiates a new Gran barrera.
     *
     * @param coste  the coste
     * @param imagen the imagen
     */
    public GranBarrera(int coste, String imagen) {
        super(coste, imagen, "S", false);
    }
    @Override
    public void accion(){

    }

}
