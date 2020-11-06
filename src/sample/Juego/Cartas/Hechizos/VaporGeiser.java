package sample.Juego.Cartas.Hechizos;

import sample.Controllers.ControllerTablero;
import sample.Juego.Cartas.Carta;
import sample.Juego.Jugador;

public class VaporGeiser extends Carta {
    public VaporGeiser(int coste, String imagen) {
        super(coste, imagen,"H", false);
    }

    public void accion(){
        Jugador.getInstance().cambioVida(10);

    }
}
