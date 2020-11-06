package sample.Juego.Cartas.Hechizos;

import sample.Conexion.Cliente;
import sample.Juego.Cartas.Carta;
import sample.Juego.Jugador;

import java.io.IOException;

/**
 * The type Calamidad.
 */
public class Calamidad extends Carta {
    /**
     * Instantiates a new Calamidad.
     *
     * @param coste  the coste
     * @param imagen the imagen
     */
    public Calamidad(int coste, String imagen) {
        super(coste, imagen, "H", false);
    }

    public void accion() throws IOException {
        Jugador.getInstance().cambioVida(-20);
        Cliente c = new Cliente(Cliente.puerto, "vida"+"|"+"-20", null, Cliente.ip);
        Thread tc = new Thread(c);
        tc.start();
    }
}
