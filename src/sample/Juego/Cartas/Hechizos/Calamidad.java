package sample.Juego.Cartas.Hechizos;

import sample.Conexion.Cliente;
import sample.Juego.Cartas.Carta;
import sample.Juego.Jugador;

import java.io.IOException;

/**
 * @author Bryan Martínez y Kevin Carranza
 * The type Calamidad.
 * *Esta es la clase Calamidad que se encarga de almacenar los datos de una carta de este tipo(Clase hija de Carta).
 */
public class Calamidad extends Carta {
    /**
     * Instantiates a new Calamidad.
     * @param coste  the coste
     * @param imagen the imagen
     */
    public Calamidad(int coste, String imagen) {
        super(coste, imagen, "H", false);
    }
    @Override
    public void accion() throws IOException {
        Jugador.getInstance().cambioVida(-20);
        Cliente c = new Cliente(Cliente.puerto, "vida"+"|"+"-20", null, Cliente.ip);
        Thread tc = new Thread(c);
        tc.start();
    }
}
