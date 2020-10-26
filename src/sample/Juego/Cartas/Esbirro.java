package sample.Juego.Cartas;

public class Esbirro extends Carta {
    private int ataque;

    public Esbirro(int coste, String imagen, int ataque) {
        super(coste, imagen);
        this.ataque = ataque;
    }

    public int getAtaque() {
        return ataque;
    }
    public void accion(){

    }
}
