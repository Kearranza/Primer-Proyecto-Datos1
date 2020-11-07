package sample.Juego.Cartas;

import sample.Conexion.Cliente;
import sample.Juego.Jugador;

import java.io.IOException;

/**
 * @author Bryan Martínez y Kevin Carranza
 * The type Esbirro.
 * Esta es la clase Esbirro que se encarga de almacenar los datos de una carta de este tipo(Clase hija de Carta).
 */
public class Esbirro extends Carta {
    private int ataque;

    /**
     * Instantiates a new Esbirro.
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
     * @return the ataque
     */
    public int getAtaque() {
        return ataque;
    }
    /**
     * Accion.
     * Se encarga de reducir la vida del jugador en base al ataque de la carta.
     * @throws IOException the io exception
     */
    public void accion() throws IOException {
        Jugador jugador = Jugador.getInstance();
        jugador.cambioVida(-this.ataque);
        Cliente c = new Cliente(Cliente.puerto, "vida"+"|"+ String.valueOf(-this.ataque), null, Cliente.ip);
        Thread tc = new Thread(c);
        tc.start();
    }
}
