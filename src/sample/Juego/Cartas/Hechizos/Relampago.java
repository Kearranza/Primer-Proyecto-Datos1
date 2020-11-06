package sample.Juego.Cartas.Hechizos;

import sample.Conexion.Cliente;
import sample.Juego.Cartas.Carta;
import sample.Juego.Jugador;

import java.io.IOException;

public class Relampago extends Carta {
    public Relampago(int coste, String imagen) {
        super(coste, imagen, "H", false);
    }

    public void accion() throws IOException {
        Jugador.getInstance().cambioVida(-10);
        Cliente c = new Cliente(Cliente.puerto, "daño"+"|"+"10", null, Cliente.ip);
        Thread tc = new Thread(c);
        tc.start();

    }
}
