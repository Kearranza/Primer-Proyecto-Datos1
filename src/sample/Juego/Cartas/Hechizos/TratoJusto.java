package sample.Juego.Cartas.Hechizos;

import sample.Conexion.Cliente;
import sample.Juego.Adversario;
import sample.Juego.Cartas.Carta;
import sample.Juego.Jugador;

import java.io.IOException;

public class TratoJusto extends Carta {
    public TratoJusto(int coste, String imagen) {
        super(coste, imagen,"H", false);
    }

    public void accion() throws IOException {
        Jugador jugador = Jugador.getInstance();
        Adversario adversario = Adversario.getInstance();
        Cliente c = new Cliente(Cliente.puerto, "daño"+"|"+ String.valueOf(jugador.getPv()- adversario.getPv()), null, Cliente.ip);
        Thread tc = new Thread(c);
        tc.start();
        jugador.setPv(adversario.getPv());
    }
}
