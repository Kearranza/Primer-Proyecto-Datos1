package sample.Juego.Cartas;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Carta {
    private Carta next = null;
    private Carta prev = null;
    private String imagen;
    private int coste;
    private Image image = new Image(getClass().getResourceAsStream(imagen));
    private ImageView imageView = new ImageView(image);

    public Carta(int coste, String imagen) {
        this.coste = coste;
        this.imagen = imagen;
    }

    public int getCoste() {
        return coste;
    }

}
