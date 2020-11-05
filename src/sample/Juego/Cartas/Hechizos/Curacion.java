package sample.Juego.Cartas.Hechizos;

import sample.Juego.Cartas.Carta;
import sample.Juego.Jugador;

public class Curacion extends Carta {
    public Curacion(int coste, String imagen) {
        super(coste, imagen, "H", false);
    }

    public void accion(){
        Jugador.getInstance().cambioVida(20);

    }
}
