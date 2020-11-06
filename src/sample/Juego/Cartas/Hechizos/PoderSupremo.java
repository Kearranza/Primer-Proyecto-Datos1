package sample.Juego.Cartas.Hechizos;

import sample.Controllers.ControllerTablero;
import sample.Juego.Cartas.Carta;

public class PoderSupremo extends Carta {
    public PoderSupremo(int coste, String imagen) {
        super(coste, imagen, "H", true);
    }

    public void accion(){
        ControllerTablero.setGratis(3);
    }
}
