package sample.Juego.Cartas.Secretos;

import sample.Juego.Cartas.Carta;

/**
 * @author Bryan Martínez y Kevin Carranza
 * The type Escudo.
 *Esta es la clase Escudo que se encarga de almacenar los datos de una carta de este tipo(Clase hija de Carta).
 */
public class Escudo extends Carta {
    /**
     * Instantiates a new Escudo.
     *
     * @param coste  the coste
     * @param imagen the imagen
     */
    public Escudo(int coste, String imagen) {
        super(coste, imagen, "S", false);
    }
    @Override
    public void accion(){

    }

}
