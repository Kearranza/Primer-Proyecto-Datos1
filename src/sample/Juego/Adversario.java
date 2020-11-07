package sample.Juego;

/**
 * @author Bryan Martínez y Kevin Carranza
 * The type Adversario.
 * Esta es la clase Adversario que se encarga de llevar los datos del Adversario
 */
public class Adversario {
    /**
     * The constant instance.
     */
    public static Adversario instance = null;
    private int pv = 100;
    private int mana = 20;

    /**
     * Get instance adversario.
     * @return the adversario
     */
    public static Adversario getInstance(){
        if (instance == null){
            instance = new Adversario();
        }
        return instance;
    }

    /**
     * Sets pv.
     * @param pv the pv
     */
    public void setPv(int pv) { this.pv = pv;}

    /**
     * Sets mana.
     * @param mana the mana
     */
    public void setMana(int mana) { this.mana = mana; }

    /**
     * Gets pv.
     * @return the pv
     */
    public int getPv() { return this.pv; }

    /**
     * Gets mana.
     * @return the mana
     */
    public int getMana() { return this.mana; }

    /**
     * Cambio vida.
     * Se encarga de reducir o aumentar los pv del adversario segun se necesite
     * @param valor the valor
     */
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

    /**
     * Cambio mana.
     * Se encarga de reducir o aumentar el mana del adversario segun se necesite
     * @param valor the valor
     */
    public void cambioMana(int valor){
        if ((this.mana + valor)>100){
            Adversario.getInstance().setMana(100);
        }
        else{
            this.mana += valor;
        }
    }

}
