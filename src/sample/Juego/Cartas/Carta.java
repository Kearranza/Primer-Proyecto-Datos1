package sample.Juego.Cartas;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
public class Carta {
    private Carta next = null;
    private Carta nextMano = null;
    private Carta prevMano = null;
    private int coste;
    private Image image;

    public Carta(int coste, String imagen) {
        this.coste = coste;
        this.image = new Image(getClass().getResourceAsStream(imagen));
    }

    public Image getImage() {
        return image;
    }

    public Carta getNext() {
        return next;
    }

    public void setNext(Carta next) {
        this.next = next;
    }


    public int getCoste() {
        return coste;
    }

    public Carta getNextMano() {
        return nextMano;
    }

    public void setNextMano(Carta nextMano) {
        this.nextMano = nextMano;
    }

    public Carta getPrevMano() {
        return prevMano;
    }

    public void setPrevMano(Carta prevMano) {
        this.prevMano = prevMano;
    }
    public void accion(){
    }

}
