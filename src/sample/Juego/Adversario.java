package sample.Juego;

public class Adversario {
    public static Adversario instance = null;
    private int pv = 100;
    private int mana = 20;

    public static Adversario getInstance(){
        if (instance == null){
            instance = new Adversario();
        }
        return instance;
    }
    public void setPv(int pv) { this.pv = pv;}

    public void setMana(int mana) { this.mana = mana; }

    public int getPv() { return this.pv; }

    public int getMana() { return this.mana; }

    public void cambioVida(int valor){
        if ((this.pv + valor)>100){
            Adversario.getInstance().setPv(100);
        }
        else if((this.pv + valor)<0){
            Adversario.getInstance().setPv(0);
        }
        else{
            this.pv += valor;
        }
    }
    public void cambioMana(int valor){
        if ((this.mana += valor)>100){
            Adversario.getInstance().setMana(100);
        }
        else{
            this.mana += valor;
        }
    }

}
