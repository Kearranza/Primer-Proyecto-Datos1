package sample.Juego;

import sample.Juego.Cartas.Carta;

/**
 * @author Bryan Martínez y Kevin Carranza
 * The type Mano.
 * Esta es la clase Mano que funciona como una lista circular
 */
public class Mano {
    private Carta first =null;
    private Carta last =null;
    private int size = 0;

    /**
     * Instantiates a new Mano.
     */
    public Mano() {
        this.inicial();
    }

    /**
     * Gets first.
     * @return the first
     */
    public Carta getFirst() {
        return first;
    }

    /**
     * Gets size.
     * @return the size
     */
    public int getSize() {
        return size;
    }

    /**
     * Gets last.
     * @return the last
     */
    public Carta getLast() {
        return last;
    }
    /** Inicial
     * Se encarga de llenar el mazo y la mano con cartas aleatorias.
     */
    private void inicial(){

        int valorAleatorio = (int)Math.floor(Math.random()*40);
        InventarioCartas inventario = InventarioCartas.getInstance();
        Carta carta = inventario.buscar(valorAleatorio);
        this.first = carta;
        this.last = carta;
        carta.setNextMano(carta);
        carta.setPrevMano(carta);
        this.size= 1;
        Carta current = this.last;
        Carta currentf = this.first;
        while (this.size<20){
            boolean flag = true;
            valorAleatorio = (int)Math.floor(Math.random()*39);
            carta = inventario.buscar(valorAleatorio);
            for (int j = 0; j < this.size;j++){
                 if (currentf == carta){
                     flag = false;
                     break;
                 }
                 else{
                     currentf = currentf.getNextMano();
                 }
            }
            if (flag){
                current.setNextMano(carta);
                this.last = carta;
                this.last.setPrevMano(current);
                this.last.setNextMano(this.first);
                this.first.setPrevMano(this.last);
                current = current.getNextMano();
                this.size +=1;
            }
        }
    }

    /**
     * Buscar carta.
     * Se encarga de buscar una carta en cierta posición con un int dado.
     * @param indice the indice
     * @return the carta
     */
    public Carta buscar(int indice){
        Carta current = this.first;
        for (int i = 0; i < this.size;i++){
            if (i == indice){
                break;
            }
            else{
                current = current.getNextMano();
            }
        }
        return current;
    }

    /**
     * Add.
     * Se encarga de añadir una carta dada a la mano.
     * @param carta the carta
     */
    public void add(Carta carta){
        if (this.first == null){
            this.first = carta;
            this.last = carta;
            carta.setNextMano(carta);
            carta.setPrevMano(carta);
            this.size += 1;
        }
        else{
            this.last.setNextMano(carta);
            carta.setPrevMano(this.last);
            this.last = carta;
            carta.setNextMano(this.first);
            this.first.setPrevMano(carta);
            this.size += 1;
        }


    }

    /**
     * Remove.
     * Se encarga de remover una carta dada de la mano.
     * @param carta the carta
     */
    public void remove(Carta carta){
        if(this.size == 1){
            carta.setNextMano(null);
            carta.setPrevMano(null);
            this.first = null;
            this.last = null;
            this.size -=1;
        }
        else if(this.first == carta){
            this.first = this.first.getNextMano();
            this.first.setPrevMano(this.last);
            this.last.setNextMano(this.first);
            this.size -=1;

        }
        else if(this.last == carta){
            this.last = this.last.getPrevMano();
            this.first.setPrevMano(this.last);
            this.last.setNextMano(this.first);
            this.size -=1;
        }
        else{
            Carta current = this.first;
            for (int i = 0; i < this.size;i++){
                if (current == carta){
                    current.getPrevMano().setNextMano(current.getNextMano());
                    current.getNextMano().setPrevMano(current.getPrevMano());
                    current.setNextMano(null);
                    current.setPrevMano(null);
                    this.size -=1;
                    break;
                }
                current = current.getNextMano();
        }

        }

    }
}
