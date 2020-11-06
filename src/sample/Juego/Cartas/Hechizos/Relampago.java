package sample.Juego.Cartas.Hechizos;

import sample.Juego.Cartas.Carta;
import sample.Juego.Jugador;

public class Relampago extends Carta {
    public Relampago(int coste, String imagen) {
        super(coste, imagen, "H", false);
    }

    public void accion(){
        Jugador.getInstance().cambioVida(-10);

    }
}
