package sample.Juego.Cartas.Hechizos;

import sample.Juego.Adversario;
import sample.Juego.Cartas.Carta;
import sample.Juego.Jugador;

public class TratoJusto extends Carta {
    public TratoJusto(int coste, String imagen) {
        super(coste, imagen,"H", false);
    }

    public void accion(){
        Jugador jugador = Jugador.getInstance();
        Adversario adversario = Adversario.getInstance();
        jugador.setPv(adversario.getPv());
    }
}
