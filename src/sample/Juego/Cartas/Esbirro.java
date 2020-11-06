package sample.Juego.Cartas;

import sample.Conexion.Cliente;
import sample.Juego.Jugador;

import java.io.IOException;

public class Esbirro extends Carta {
    private int ataque;

    public Esbirro(int coste, String imagen, int ataque) {
        super(coste, imagen, "E", false);
        this.ataque = ataque;
    }

    public int getAtaque() {
        return ataque;
    }

    public void accion() throws IOException {
        Jugador jugador = Jugador.getInstance();
        jugador.cambioVida(-this.ataque);
        Cliente c = new Cliente(Cliente.puerto, "daño"+"|"+ String.valueOf(this.ataque), null, Cliente.ip);
        Thread tc = new Thread(c);
        tc.start();
    }
}
