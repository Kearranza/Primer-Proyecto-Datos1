package sample.Juego;

public class Jugador {
    public static Jugador instance = null;
    private int pv = 100;
    private int mana = 20;
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

    public void robar(){

    }
    public void invocar(){

    }

}
