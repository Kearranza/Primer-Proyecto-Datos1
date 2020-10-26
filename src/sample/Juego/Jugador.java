package sample.Juego;

public class Jugador {
    private int pv = 100;
    private int mana = 20;
    private Mano mano;
    private Mazo mazo;

    public Jugador() {
        Mano mano = new Mano();
        this.mano = mano;
        this.crearMazo();
    }
    public void crearMazo(){
        Mazo mazo = new Mazo(this.mano);
        this.mazo = mazo;
    }
    public int getPv() {
        return pv;
    }

    public void setPv(int pv) { this.pv = pv; }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public Mano getMano() {
        return mano;
    }


    public Mazo getMazo() {
        return mazo;
    }


    public void robar(){

    }
    public void invocar(){

    }

}
