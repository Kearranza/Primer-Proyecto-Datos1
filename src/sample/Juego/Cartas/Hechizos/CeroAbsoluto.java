package sample.Juego.Cartas.Hechizos;

import sample.Controllers.ControllerTablero;
import sample.Juego.Cartas.Carta;

public class CeroAbsoluto extends Carta {
    public CeroAbsoluto(int coste, String imagen) {
        super(coste, imagen, "H", false);
    }

    public void accion(){
        ControllerTablero.setCongelado(true);
    }
}
