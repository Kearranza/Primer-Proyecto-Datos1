package sample.Juego.Cartas;

import javafx.scene.image.Image;
import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonProperty;

public class Carta {
    private Carta next = null;
    private Carta nextMano = null;
    private Carta prevMano = null;
    private int coste;
    private String imagen;
    private String tipo;

    @JsonCreator
    public Carta(@JsonProperty("next") Carta next,@JsonProperty("nextMano") Carta nextMano,@JsonProperty("prevMano") Carta prevMano ,@JsonProperty("coste") int coste, @JsonProperty("imagen") String imagen) {
        this.next = next;
        this.nextMano = nextMano;
        this.prevMano = prevMano;
        this.coste = coste;
        this.imagen = imagen;

    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Carta(int coste, String imagen, String tipo) {
        this.coste = coste;
        this.imagen = imagen;
        this.tipo = tipo;
    }
    public void setCoste(int coste) {
        this.coste = coste;
    }


    public Carta getNext() {
        return next;
    }

    public void setNext(Carta next) {
        this.next = next;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
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
