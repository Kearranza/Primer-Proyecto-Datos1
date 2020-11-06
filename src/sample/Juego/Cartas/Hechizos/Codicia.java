package sample.Juego.Cartas.Hechizos;

import sample.Conexion.Cliente;
import sample.Juego.Cartas.Carta;
import sample.Juego.Jugador;

import java.io.IOException;

/**
 * @author Bryan Martínez y Kevin Carranza
 * The type Codicia.
 *
 */
public class Codicia extends Carta {
    /**
     * Instantiates a new Codicia.
     *
     * @param coste  the coste
     * @param imagen the imagen
     */
    public Codicia(int coste, String imagen) {
        super(coste, imagen, "H", true);
    }

    public void accion() throws IOException {

    }
}
