package sample.Juego;

import sample.Juego.Cartas.Carta;

public class Jugador {
    public static Jugador instance = null;
    private int pv;
    private int mana;
    private Mano mano;
    private Mazo mazo;

    public static Jugador getInstance(){
        if (instance == null){
            instance = new Jugador();
        }
        return instance;
    }

    public Jugador() {
        Mano mano = new Mano();
        this.mano = mano;
        this.crearMazo();
        this.mana = 20;
        this.pv = 100;
    }
    public void crearMazo(){
        Mazo mazo = new Mazo(this.mano);
        this.mazo = mazo;
    }
    public int getPv() {
        return this.pv;
    }

    public void setPv(int pv) { this.pv = pv; }

    public int getMana() {
        return this.mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public Mano getMano() { return this.mano; }

    public Mazo getMazo() {
        return this.mazo;
    }

    public void cambioVida(int valor){
        if ((this.pv += valor)>100){
            Jugador.getInstance().setPv(100);
        }
        else if((this.pv += valor)<0){
            Jugador.getInstance().setPv(0);
        }
        else{
            this.pv += valor;
        }
    }
    public void cambioMana(int valor){
        if ((this.mana += valor)>100){
            Jugador.getInstance().setMana(100);
        }
        else{
            this.mana =this.mana + valor;

        }
    }

    public void robar(){
        Carta robada = this.mazo.eliminar();
        this.mano.add(robada);

    }
    public void invocar(){

    }

}
