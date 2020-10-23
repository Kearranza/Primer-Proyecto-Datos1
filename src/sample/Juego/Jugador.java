package sample.Juego;

public class Jugador {
    private int pv = 100;
    private int mana = 20;
    private Mano mano;
    private Mazo mazo;

    public Jugador(Mano mano, Mazo mazo) {
        this.mano = mano;
        this.mazo = mazo;
    }

    public int getPv() {
        return pv;
    }

    public void setPv(int pv) {
        this.pv = pv;
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public Mano getMano() {
        return mano;
    }

    public void setMano(Mano mano) {
        this.mano = mano;
    }

    public Mazo getMazo() {
        return mazo;
    }

    public void setMazo(Mazo mazo) {
        this.mazo = mazo;
    }

    public void robar(){

    }
    public void invocar(){

    }

}
