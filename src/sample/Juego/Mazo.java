package sample.Juego;

import sample.Juego.Cartas.Carta;

/**
 * @author Bryan Martínez y Kevin Carranza
 * The type Mazo.
 * Esta es la clase Mazo que funciona como una pila.
 */
public class Mazo {
    private int top = -1;
    private int maxsize = 16;
    private Carta[] stackArray;

    /**
     * Instantiates a new Mazo.
     * @param mano the mano
     */
    public Mazo(Mano mano) {
        this.stackArray = new Carta[16];
        this.inicial(mano);
    }

    /** Inicial
     * Se encarga de llenar de Cartas el Mazo.
     */
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
     * Se encarga de retornar la carta del tope.
     * @return the carta
     */
    public Carta eliminar(){
        return this.stackArray[top--];
    }
}
