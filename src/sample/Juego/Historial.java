package sample.Juego;

import sample.Juego.Cartas.Carta;

/**
 * The type Historial.
 * Lista donde se alamcena las acciones del juego
 */
public class Historial {
    private Accion first;
    private Accion last ;
    private int size = 1;

    /**
     * Instantiates a new Historial.
     */
    public Historial(){
        Accion accion =  new Accion("Historial"+"\n");
        this.first = accion;
        this.last = accion;
    }

    /**
     * Add.
     *Añade un nodo al final de la lista
     * @param accion the accion
     */
    public void add(Accion accion){
        this.last.setNext(accion);
        accion.setPrev(this.last);
        this.last = accion;
        this.size +=1;
    }

    /**
     * Mostrar string.
     *Mustra todos los nodos como un solo string
     * @return the string
     */
    public String mostrar(){
        String acciones = "";
        Accion current =this.first;
        for (int i = 0;i<this.size;i++){
            acciones += current.getValor();
            current = current.getNext();
        }
        return acciones;
    }


}
