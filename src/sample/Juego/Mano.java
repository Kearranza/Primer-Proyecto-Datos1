package sample.Juego;

import jdk.nashorn.internal.ir.CatchNode;
import sample.Juego.Cartas.Carta;

public class Mano {
    private Carta first =null;
    private Carta last =null;
    private int size = 0;

    public Mano() {
    }

    public void inicial(){

        int valorAleatorio = (int)Math.floor(Math.random()*40);
        InventarioCartas inventario = InventarioCartas.getInstance();
        Carta carta = inventario.buscar(valorAleatorio);
        this.first = carta;
        this.last = carta;
        carta.setNextMano(carta);
        carta.setPrevMano(carta);


        Carta current = this.last;
        for (int i=0;i<4; i++){
            valorAleatorio = (int)Math.floor(Math.random()*40);
            current.setNextMano(inventario.buscar(valorAleatorio));
            this.last = current.getNextMano();
            this.last.setPrevMano(current);
            this.last.setNextMano(this.first);
            this.first.setPrevMano(this.last);
            System.out.println(current);
            current = current.getNextMano();
        }
        this.size = 4;
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

        }
        else{

        }
    }
}
