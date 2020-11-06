package sample.Juego.Cartas;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonProperty;

import java.io.IOException;

public class Carta {
    private Carta next = null;
    private Carta nextMano = null;
    private Carta prevMano = null;
    private int coste;
    private String imagen;
    private String tipo;
    private String nombre;
    private boolean favor;


    public Carta(int coste, String imagen, String tipo, boolean favor) {
        this.coste = coste;
        this.imagen = imagen;
        this.tipo = tipo;
        String[] components = imagen.split("/");
        String[] component = components[1].split("\\.");
        this.nombre = component[0];
        this.favor = favor;
    }
    @JsonCreator
    public Carta(@JsonProperty("next") Carta next,@JsonProperty("nextMano") Carta nextMano,@JsonProperty("prevMano") Carta prevMano ,@JsonProperty("coste") int coste, @JsonProperty("imagen") String imagen, @JsonProperty("tipo") String tipo) {
        this.next = next;
        this.nextMano = nextMano;
        this.prevMano = prevMano;
        this.coste = coste;
        this.imagen = imagen;
        this.tipo = tipo;
        String[] components = imagen.split("/");
        String[] component = components[1].split("\\.");
        this.nombre = component[0];

    }

    public String getNombre() {
        return nombre;
    }

    public boolean isFavor() {
        return favor;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
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

    public void accion() throws IOException {

    }

}
