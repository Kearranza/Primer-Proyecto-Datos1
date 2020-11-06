package sample.Juego.Cartas.Hechizos;

import sample.Conexion.Cliente;
import sample.Juego.Cartas.Carta;
import sample.Juego.Jugador;

import java.io.IOException;

public class Codicia extends Carta {
    public Codicia(int coste, String imagen) {
        super(coste, imagen, "H", false);
    }

    public void accion() throws IOException {
        Jugador jugador = Jugador.getInstance();
        Carta carta = jugador.getMazo().eliminar();
        Carta cartaEnviar = new Carta(carta.getCoste(), carta.getImagen(), "R", carta.isFavor());
        Cliente c = new Cliente(Cliente.puerto, "", cartaEnviar, Cliente.ip);
        Thread tc = new Thread(c);
        tc.start();
        jugador.getMano().remove(carta);
    }
}
