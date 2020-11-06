package sample.Juego.Cartas.Hechizos;

import sample.Conexion.Cliente;
import sample.Juego.Cartas.Carta;
import sample.Juego.Jugador;

import java.io.IOException;

/**
 * @author Bryan Martínez y Kevin Carranza
 * The type Bendicion.
 *
 */
public class Bendicion extends Carta {
    /**
     * Instantiates a new Bendicion.
     *
     * @param coste  the coste
     * @param imagen the imagen
     */
    public Bendicion(int coste, String imagen) {
        super(coste, imagen, "H", true);
    }

    public void accion() throws IOException {
        Jugador.getInstance().cambioVida(40);
        Cliente c = new Cliente(Cliente.puerto, "vida"+"|"+ "40", null, Cliente.ip);
        Thread tc = new Thread(c);
        tc.start();
    }
}
