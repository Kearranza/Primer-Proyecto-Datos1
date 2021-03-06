package sample.Juego.Cartas.Hechizos;

import sample.Conexion.Cliente;
import sample.Controllers.ControllerTablero;
import sample.Juego.Cartas.Carta;
import sample.Juego.Jugador;

import java.io.IOException;

/**
 * @author Bryan Martínez y Kevin Carranza
 * The type Sacrificio sangre.
 *Esta es la clase SancrifioSangre que se encarga de almacenar los datos de una carta de este tipo(Clase hija de Carta).
 */
public class SacrificioSangre extends Carta {
    /**
     * Instantiates a new Sacrificio sangre.
     * @param coste  the coste
     * @param imagen the imagen
     */
    public SacrificioSangre(int coste, String imagen) {
        super(coste, imagen,"H", true);
    }
    @Override
    public void accion() throws IOException {
        Jugador jugador = Jugador.getInstance();
        jugador.cambioVida(-10);
        jugador.cambioMana(30);
        Cliente cv = new Cliente(Cliente.puerto, "vida"+"|"+ "-10", null, Cliente.ip);
        Thread tcv = new Thread(cv);
        tcv.start();
        Cliente cm = new Cliente(Cliente.puerto, "mana"+"|"+ "30", null, Cliente.ip);
        Thread tcm = new Thread(cm);
        tcm.start();

    }
}
