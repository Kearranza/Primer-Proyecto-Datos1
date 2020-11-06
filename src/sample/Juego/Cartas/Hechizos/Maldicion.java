package sample.Juego.Cartas.Hechizos;

import sample.Juego.Cartas.Carta;
import sample.Juego.Jugador;

public class Maldicion extends Carta {
    public Maldicion(int coste, String imagen) {
        super(coste, imagen, "H", false);
    }

    public void accion(){
        Jugador jugador = Jugador.getInstance();
        jugador.cambioVida(-(jugador.getMano().getSize())*10);
    }
}
