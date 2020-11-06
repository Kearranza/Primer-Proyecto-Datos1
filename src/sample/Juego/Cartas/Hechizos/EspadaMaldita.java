package sample.Juego.Cartas.Hechizos;

import sample.Juego.Cartas.Carta;
import sample.Juego.Jugador;

public class EspadaMaldita extends Carta {
    public EspadaMaldita(int coste, String imagen) {
        super(coste, imagen, "H", false);
    }
    public void accion(){
        Jugador jugador = Jugador.getInstance();
        jugador.setPv(jugador.getPv()/2);
    }
}
