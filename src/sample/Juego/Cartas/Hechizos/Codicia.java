package sample.Juego.Cartas.Hechizos;

import sample.Conexion.Cliente;
import sample.Juego.Cartas.Carta;
import sample.Juego.Jugador;

import java.io.IOException;

/**
 * @author Bryan Martínez y Kevin Carranza
 * The type Codicia.
 * Esta es la clase Codicia que se encarga de almacenar los datos de una carta de este tipo(Clase hija de Carta).
 */
public class Codicia extends Carta {
    /**
     * Instantiates a new Codicia.
     * @param coste  the coste
     * @param imagen the imagen
     */
    public Codicia(int coste, String imagen) {
        super(coste, imagen, "H", true);
    }
    @Override
    public void accion(){

    }
}
