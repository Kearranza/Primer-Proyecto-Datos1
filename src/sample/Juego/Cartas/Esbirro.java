package sample.Juego.Cartas;

import sample.Conexion.Cliente;
import sample.Juego.Jugador;

import java.io.IOException;

/**
 * @author Bryan Martínez y Kevin Carranza
 * The type Esbirro.
 *
 */
public class Esbirro extends Carta {
    private int ataque;

    /**
     * Instantiates a new Esbirro.
     *
     * @param coste  the coste
     * @param imagen the imagen
     * @param ataque the ataque
     */
    public Esbirro(int coste, String imagen, int ataque) {
        super(coste, imagen, "E", false);
        this.ataque = ataque;
    }

    /**
     * Gets ataque.
     *
     * @return the ataque
     */
    public int getAtaque() {
        return ataque;
    }

    public void accion() throws IOException {
        Jugador jugador = Jugador.getInstance();
        jugador.cambioVida(-this.ataque);
        Cliente c = new Cliente(Cliente.puerto, "vida"+"|"+ String.valueOf(-this.ataque), null, Cliente.ip);
        Thread tc = new Thread(c);
        tc.start();
    }
}
