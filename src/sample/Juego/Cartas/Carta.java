package sample.Juego.Cartas;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Carta {
    private Carta next = null;
    private Carta prev = null;
    private int coste;
    private Image image;
    private ImageView imageView;

    public Carta(int coste, String imagen) {
        this.coste = coste;
        this.image = new Image(getClass().getResourceAsStream(imagen));
        this.imageView = new ImageView(image);
    }

    public Carta getNext() {
        return next;
    }

    public void setNext(Carta next) {
        this.next = next;
    }

    public Carta getPrev() {
        return prev;
    }

    public void setPrev(Carta prev) {
        this.prev = prev;
    }

    public int getCoste() {
        return coste;
    }

}
