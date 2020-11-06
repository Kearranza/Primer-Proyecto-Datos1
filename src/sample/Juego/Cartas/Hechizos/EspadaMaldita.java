package sample.Juego.Cartas.Hechizos;

import sample.Conexion.Cliente;
import sample.Juego.Cartas.Carta;
import sample.Juego.Jugador;

import java.io.IOException;

public class EspadaMaldita extends Carta {
    public EspadaMaldita(int coste, String imagen) {
        super(coste, imagen, "H", false);
    }
    public void accion() throws IOException {
        Jugador jugador = Jugador.getInstance();
        jugador.setPv(jugador.getPv()/2);
        Cliente c = new Cliente(Cliente.puerto, "daño"+"|"+ String.valueOf(jugador.getPv()/2), null, Cliente.ip);
        Thread tc = new Thread(c);
        tc.start();
    }
}
