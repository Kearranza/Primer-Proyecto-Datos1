package sample.Juego.Cartas.Hechizos;

import sample.Juego.Cartas.Carta;
import sample.Juego.Jugador;

public class FuenteMana extends Carta {
    public FuenteMana(int coste, String imagen) {
        super(coste, imagen, "H", true);
    }
    public void accion(){
        Jugador.getInstance().cambioMana(20);
    }
}
