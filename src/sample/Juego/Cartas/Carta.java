package sample.Juego.Cartas;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonProperty;

import java.io.IOException;

/**
 * @author Bryan Martínez y Kevin Carranza
 * The type Carta.
 *
 */
public class Carta {
    private Carta next = null;
    private Carta nextMano = null;
    private Carta prevMano = null;
    private int coste;
    private String imagen;
    private String tipo;
    private String nombre;
    private boolean favor;


    /**
     * Instantiates a new Carta.
     *
     * @param coste  the coste
     * @param imagen the imagen
     * @param tipo   the tipo
     * @param favor  the favor
     */
    public Carta(int coste, String imagen, String tipo, boolean favor) {
        this.coste = coste;
        this.imagen = imagen;
        this.tipo = tipo;
        String[] components = imagen.split("/");
        String[] component = components[1].split("\\.");
        this.nombre = component[0];
        this.favor = favor;
    }

    /**
     * Instantiates a new Carta.
     *
     * @param next     the next
     * @param nextMano the next mano
     * @param prevMano the prev mano
     * @param coste    the coste
     * @param imagen   the imagen
     * @param tipo     the tipo
     */
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

    /**
     * Gets nombre.
     *
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Is favor boolean.
     *
     * @return the boolean
     */
    public boolean isFavor() {
        return favor;
    }

    /**
     * Gets tipo.
     *
     * @return the tipo
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * Sets tipo.
     *
     * @param tipo the tipo
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * Sets coste.
     *
     * @param coste the coste
     */
    public void setCoste(int coste) {
        this.coste = coste;
    }


    /**
     * Gets next.
     *
     * @return the next
     */
    public Carta getNext() {
        return next;
    }

    /**
     * Sets next.
     *
     * @param next the next
     */
    public void setNext(Carta next) {
        this.next = next;
    }

    /**
     * Gets imagen.
     *
     * @return the imagen
     */
    public String getImagen() {
        return imagen;
    }

    /**
     * Sets imagen.
     *
     * @param imagen the imagen
     */
    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    /**
     * Gets coste.
     *
     * @return the coste
     */
    public int getCoste() {
        return coste;
    }

    /**
     * Gets next mano.
     *
     * @return the next mano
     */
    public Carta getNextMano() {
        return nextMano;
    }

    /**
     * Sets next mano.
     *
     * @param nextMano the next mano
     */
    public void setNextMano(Carta nextMano) {
        this.nextMano = nextMano;
    }

    /**
     * Gets prev mano.
     *
     * @return the prev mano
     */
    public Carta getPrevMano() {
        return prevMano;
    }

    /**
     * Sets prev mano.
     *
     * @param prevMano the prev mano
     */
    public void setPrevMano(Carta prevMano) {
        this.prevMano = prevMano;
    }

    /**
     * Accion.
     *
     * @throws IOException the io exception
     */
    public void accion() throws IOException {

    }

}
