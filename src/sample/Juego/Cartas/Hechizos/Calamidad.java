package sample.Juego.Cartas.Hechizos;

import sample.Juego.Cartas.Carta;
import sample.Juego.Jugador;

public class Calamidad extends Carta {
    public Calamidad(int coste, String imagen) {
        super(coste, imagen, "H");
    }

    public void accion(){
        Jugador.getInstance().cambioVida(-20);
    }
}
