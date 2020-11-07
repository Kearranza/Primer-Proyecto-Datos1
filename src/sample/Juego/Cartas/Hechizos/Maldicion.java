package sample.Juego.Cartas.Hechizos;

import sample.Conexion.Cliente;
import sample.Juego.Cartas.Carta;
import sample.Juego.Jugador;

import java.io.IOException;

/**
 * @author Bryan Martínez y Kevin Carranza
 * The type Maldicion.
 *Esta es la clase Maldicion que se encarga de almacenar los datos de una carta de este tipo(Clase hija de Carta).
 */
public class Maldicion extends Carta {
    /**
     * Instantiates a new Maldicion.
     *
     * @param coste  the coste
     * @param imagen the imagen
     */
    public Maldicion(int coste, String imagen) {
        super(coste, imagen, "H", false);
    }
    @Override
    public void accion() throws IOException {
        Jugador jugador = Jugador.getInstance();
        jugador.cambioVida(-(jugador.getMano().getSize())*10);
        Cliente c = new Cliente (Cliente.puerto, "vida"+"|"+ String.valueOf(-(jugador.getMano().getSize())*10), null, Cliente.ip);
        Thread tc = new Thread(c);
        tc.start();
    }
}
