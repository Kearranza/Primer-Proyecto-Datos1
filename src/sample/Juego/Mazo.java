package sample.Juego;

import sample.Juego.Cartas.Carta;

/**
 * @author Bryan Martínez y Kevin Carranza
 * The type Mazo.
 *
 */
public class Mazo {
    private int top = -1;
    private int maxsize = 16;
    private Carta[] stackArray;

    /**
     * Instantiates a new Mazo.
     *
     * @param mano the mano
     */
    public Mazo(Mano mano) {
        this.stackArray = new Carta[16];
        this.inicial(mano);
    }

    private void inicial(Mano mano) {
        Carta current = mano.getFirst();
        int i = 0;
        while (i < this.maxsize) {
            this.stackArray[++top] = current;
            mano.remove(current);
            current = mano.getFirst();
            i+=1;
            }
        }

    /**
     * Eliminar carta.
     *
     * @return the carta
     */
    public Carta eliminar(){
        return this.stackArray[top--];
    }
}
