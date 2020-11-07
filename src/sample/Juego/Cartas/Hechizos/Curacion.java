package sample.Juego.Cartas.Hechizos;

import sample.Conexion.Cliente;
import sample.Juego.Cartas.Carta;
import sample.Juego.Jugador;

import java.io.IOException;

/**
 * @author Bryan Martínez y Kevin Carranza
 * The type Curacion.
 *
 */
public class Curacion extends Carta {
    /**
     * Instantiates a new Curacion.
     *
     * @param coste  the coste
     * @param imagen the imagen
     */
    public Curacion(int coste, String imagen) {
        super(coste, imagen, "H", true);
    }

    public void accion() throws IOException {
        Jugador.getInstance().cambioVida(20);
        Cliente c = new Cliente(Cliente.puerto, "vida"+"|"+ "20", null, Cliente.ip);
        Thread tc = new Thread(c);
        tc.start();

    }
}
