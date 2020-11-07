package sample.Juego.Cartas.Secretos;

import sample.Conexion.Cliente;
import sample.Conexion.Servidor;
import sample.Controllers.ControllerTablero;
import sample.Juego.Accion;
import sample.Juego.Cartas.Carta;
import sample.Juego.Jugador;

import java.io.IOException;

/**
 * @author Bryan Martínez y Kevin Carranza
 * The type Barrera mana.
 *Esta es la clase BarreraMana que se encarga de almacenar los datos de una carta de este tipo(Clase hija de Carta).
 */
public class BarreraMana extends Carta {
    /**
     * Instantiates a new Barrera mana.
     *
     * @param coste  the coste
     * @param imagen the imagen
     */
    public BarreraMana(int coste, String imagen) {
        super(coste, imagen, "S", false);
    }


    public void accion(Carta carta) throws IOException {
        if((carta.getTipo().equals("E")) || (carta.getNombre().equals("Relampago")) || (carta.getNombre().equals("Calamidad"))){
            Jugador.getInstance().cambioMana(20);
            Cliente cm = new Cliente(Cliente.puerto, "mana"+"|"+ "20", null, Cliente.ip);
            Thread tcm = new Thread(cm);
            tcm.start();
            Servidor.setActivada(true);
            Accion accion = new Accion ("Se activó: "+ControllerTablero.getsPropia().getNombre()+"\n");
            ControllerTablero.getRegistro().add(accion);
            Cliente c = new Cliente(Cliente.puerto, "activacion"+"|"+ControllerTablero.getsPropia().getNombre(), null, Cliente.ip);
            Thread tc = new Thread(c);
            tc.start();
            ControllerTablero.setsPropia(null);
            ControllerTablero.setSecretoP(false);
        }

    }

}
