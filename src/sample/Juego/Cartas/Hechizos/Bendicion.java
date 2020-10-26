package sample.Juego.Cartas.Hechizos;

import sample.Juego.Cartas.Carta;
import sample.Juego.Jugador;

public class Bendicion extends Carta {
    public Bendicion(int coste, String imagen) {
        super(coste, imagen);
    }

    public void accion(){
        Jugador.getInstance().cambioVida(40);
    }
}
