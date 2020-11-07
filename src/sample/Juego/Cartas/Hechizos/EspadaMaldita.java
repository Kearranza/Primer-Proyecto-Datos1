package sample.Juego.Cartas.Hechizos;

import sample.Conexion.Cliente;
import sample.Juego.Cartas.Carta;
import sample.Juego.Jugador;

import java.io.IOException;

/**
 * @author Bryan Martínez y Kevin Carranza
 * The type Espada maldita.
 * Esta es la clase EspadaMaldita que se encarga de almacenar los datos de una carta de este tipo(Clase hija de Carta).
 */
public class EspadaMaldita extends Carta {
    /**
     * Instantiates a new Espada maldita.
     * @param coste  the coste
     * @param imagen the imagen
     */
    public EspadaMaldita(int coste, String imagen) {
        super(coste, imagen, "H", false);
    }
    @Override
    public void accion() throws IOException {
        Jugador jugador = Jugador.getInstance();
        Cliente c = new Cliente(Cliente.puerto, "vida"+"|"+ String.valueOf(-(jugador.getPv()/2)), null, Cliente.ip);
        Thread tc = new Thread(c);
        tc.start();
        jugador.setPv(jugador.getPv()/2);

    }
}
