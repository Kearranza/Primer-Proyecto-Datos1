package sample.Juego.Cartas.Hechizos;

import sample.Controllers.ControllerTablero;
import sample.Juego.Cartas.Carta;

public class ReglasAntiguas extends Carta {
    public ReglasAntiguas(int coste, String imagen) {
        super(coste, imagen, "H", false);
    }
    public void accion(){
        ControllerTablero.setGratis(1);
    }
}
