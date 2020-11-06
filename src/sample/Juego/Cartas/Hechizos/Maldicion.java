package sample.Juego.Cartas.Hechizos;

import sample.Conexion.Cliente;
import sample.Juego.Cartas.Carta;
import sample.Juego.Jugador;

import java.io.IOException;

public class Maldicion extends Carta {
    public Maldicion(int coste, String imagen) {
        super(coste, imagen, "H", false);
    }

    public void accion() throws IOException {
        Jugador jugador = Jugador.getInstance();
        jugador.cambioVida(-(jugador.getMano().getSize())*10);
        Cliente c = new Cliente (Cliente.puerto, "daño"+"|"+ String.valueOf((jugador.getMano().getSize())*10), null, Cliente.ip);
        Thread tc = new Thread(c);
        tc.start();
    }
}
