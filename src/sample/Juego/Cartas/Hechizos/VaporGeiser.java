package sample.Juego.Cartas.Hechizos;

import sample.Controllers.ControllerTablero;
import sample.Juego.Cartas.Carta;
import sample.Juego.Jugador;

/**
 * @author Bryan Martínez y Kevin Carranza
 * The type Vapor geiser.
 * Esta es la clase VaporGeiser que se encarga de almacenar los datos de una carta de este tipo(Clase hija de Carta).
 */
public class VaporGeiser extends Carta {
    /**
     * Instantiates a new Vapor geiser.
     * @param coste  the coste
     * @param imagen the imagen
     */
    public VaporGeiser(int coste, String imagen) {
        super(coste, imagen,"H", true);
    }
    @Override
    public void accion(){
        Jugador.getInstance().cambioVida(10);

    }
}
