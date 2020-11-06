package sample.Juego.Cartas.Hechizos;

import sample.Conexion.Cliente;
import sample.Juego.Cartas.Carta;
import sample.Juego.Jugador;

import java.io.IOException;

/**
 * @author Bryan Martínez y Kevin Carranza
 * The type Relampago.
 *
 */
public class Relampago extends Carta {
    /**
     * Instantiates a new Relampago.
     *
     * @param coste  the coste
     * @param imagen the imagen
     */
    public Relampago(int coste, String imagen) {
        super(coste, imagen, "H", false);
    }

    public void accion() throws IOException {
        Jugador.getInstance().cambioVida(-10);
        Cliente c = new Cliente(Cliente.puerto, "vida"+"|"+"-10", null, Cliente.ip);
        Thread tc = new Thread(c);
        tc.start();

    }
}
