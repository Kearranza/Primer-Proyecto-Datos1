package sample.Juego.Cartas.Hechizos;

import sample.Conexion.Cliente;
import sample.Juego.Adversario;
import sample.Juego.Cartas.Carta;
import sample.Juego.Jugador;

import java.io.IOException;

/**
 * @author Bryan Martínez y Kevin Carranza
 * The type Trato justo.
 *Esta es la clase TratoJusto que se encarga de almacenar los datos de una carta de este tipo(Clase hija de Carta).
 */
public class TratoJusto extends Carta {
    /**
     * Instantiates a new Trato justo.
     * @param coste  the coste
     * @param imagen the imagen
     */
    public TratoJusto(int coste, String imagen) {
        super(coste, imagen,"H", false);
    }
    @Override
    public void accion() throws IOException {
        Jugador jugador = Jugador.getInstance();
        Adversario adversario = Adversario.getInstance();
        Cliente c = new Cliente(Cliente.puerto, "vida"+"|"+ String.valueOf(adversario.getPv()- jugador.getPv()), null, Cliente.ip);
        Thread tc = new Thread(c);
        tc.start();
        jugador.setPv(adversario.getPv());
    }
}
