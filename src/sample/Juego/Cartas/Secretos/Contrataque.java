package sample.Juego.Cartas.Secretos;

import sample.Juego.Cartas.Carta;

/**
 * @author Bryan Martínez y Kevin Carranza
 * The type Contrataque.
 *Esta es la clase Contrataque que se encarga de almacenar los datos de una carta de este tipo(Clase hija de Carta).
 */
public class Contrataque extends Carta {
    /**
     * Instantiates a new Contrataque.
     *
     * @param coste  the coste
     * @param imagen the imagen
     */
    public Contrataque(int coste, String imagen) {
        super(coste, imagen, "S", false);
    }
    @Override
    public void accion(){

    }

}
