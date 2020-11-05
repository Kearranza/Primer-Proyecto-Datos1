package sample.Juego.Cartas;

import sample.Juego.Jugador;

public class Esbirro extends Carta {
    private int ataque;

    public Esbirro(int coste, String imagen, int ataque) {
        super(coste, imagen, "E", true);
        this.ataque = ataque;
    }

    public int getAtaque() {
        return ataque;
    }

    public void accion(){
        Jugador jugador = Jugador.getInstance();
        jugador.cambioVida(-this.ataque);
    }
}
