package sample.Juego;

import jdk.nashorn.internal.ir.CatchNode;
import sample.Juego.Cartas.Carta;

public class Mano {
    private Carta first =null;
    private Carta last =null;
    private int size = 0;

    public Mano() {
        this.inicial();
    }

    public Carta getFirst() {
        return first;
    }

    public int getSize() {
        return size;
    }

    public Carta getLast() {
        return last;
    }

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
            valorAleatorio = (int)Math.floor(Math.random()*40);
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
    public void remove(Carta carta){
        if(this.size == 1){
            carta.setNextMano(null);
            carta.setPrevMano(null);
            this.first = null;
            this.last = null;
        }
        else if(this.first == carta){
            this.first = this.first.getNextMano();
            this.first.setPrevMano(this.last);
            this.last.setNextMano(this.first);

        }
        else if(this.last == carta){
            this.last = this.last.getPrevMano();
            this.first.setPrevMano(this.last);
            this.last.setNextMano(this.first);
        }
        else{
            Carta current = this.first;
            for (int i = 0; i < this.size;i++){
                if (current == carta){
                    current.getPrevMano().setNextMano(current.getNextMano());
                    current.getNextMano().setPrevMano(current.getPrevMano());
                    current.setNextMano(null);
                    current.setPrevMano(null);
                    break;
                }
                current = current.getNextMano();
            }

        }
        this.size -=1;
    }
}
