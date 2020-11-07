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
 * The type Gran barrera.
 *Esta es la clase GranBarrera que se encarga de almacenar los datos de una carta de este tipo(Clase hija de Carta).
 */
public class GranBarrera extends Carta {
    /**
     * Instantiates a new Gran barrera.
     *
     * @param coste  the coste
     * @param imagen the imagen
     */
    public GranBarrera(int coste, String imagen) {
        super(coste, imagen, "S", false);
    }

    public void accion(Carta carta) throws IOException {
        if ((carta.getTipo().equals("E")) || (carta.getNombre().equals("Relampago")) || (carta.getNombre().equals("Calamidad"))) {
            Servidor.setActivada(true);
            Jugador.getInstance().invocar(10, carta);
            Cliente ca = new Cliente(Cliente.puerto, "activacion"+"|"+ControllerTablero.getsPropia().getNombre(), null, Cliente.ip);
            Thread tca = new Thread(ca);
            tca.start();
            Accion accion = new Accion ("Se activó: "+ControllerTablero.getsPropia().getNombre()+"\n");
            ControllerTablero.getRegistro().add(accion);
            ControllerTablero.setsPropia(null);
            ControllerTablero.setSecretoP(false);
        }
    }

}
