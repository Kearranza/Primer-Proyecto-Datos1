package sample.Juego.Cartas.Hechizos;

import sample.Conexion.Cliente;
import sample.Juego.Cartas.Carta;
import sample.Juego.Jugador;

import java.io.IOException;

public class FuenteMana extends Carta {
    public FuenteMana(int coste, String imagen) {
        super(coste, imagen, "H", true);
    }
    public void accion() throws IOException {
        Jugador.getInstance().cambioMana(20);
        Cliente c = new Cliente(Cliente.puerto, "mana"+"|"+ "20", null, Cliente.ip);
        Thread tc = new Thread(c);
        tc.start();
    }
}
