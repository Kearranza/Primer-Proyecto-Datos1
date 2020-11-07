package sample.Juego.Cartas.Secretos;

import sample.Juego.Cartas.Carta;

import java.io.IOException;

/**
 * @author Bryan Martínez y Kevin Carranza
 * The type Apaciguar.
 * Esta es la clase Apaciguar que se encarga de almacenar los datos de una carta de este tipo(Clase hija de Carta).
 */
public class Apaciguar extends Carta {
    /**
     * Instantiates a new Apaciguar.
     *
     * @param coste  the coste
     * @param imagen the imagen
     */
    public Apaciguar(int coste, String imagen) {
        super(coste, imagen, "S", false);
    }

    @Override
    public void accion(){

    }
}
