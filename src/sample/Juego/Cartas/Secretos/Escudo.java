package sample.Juego.Cartas.Secretos;

import sample.Conexion.Cliente;
import sample.Conexion.Servidor;
import sample.Controllers.ControllerTablero;
import sample.Juego.Accion;
import sample.Juego.Cartas.Carta;

import java.io.IOException;

/**
 * @author Bryan Martínez y Kevin Carranza
 * The type Escudo.
 *Esta es la clase Escudo que se encarga de almacenar los datos de una carta de este tipo(Clase hija de Carta).
 */
public class Escudo extends Carta {
    /**
     * Instantiates a new Escudo.
     *
     * @param coste  the coste
     * @param imagen the imagen
     */
    public Escudo(int coste, String imagen) {
        super(coste, imagen, "S", false);
    }

    public void accion(Carta carta) throws IOException {
        if ((carta.getTipo().equals("E")) || (carta.getNombre().equals("Relampago")) || (carta.getNombre().equals("Calamidad"))) {
            Servidor.setActivada(true);
            Cliente c = new Cliente(Cliente.puerto, "activacion"+"|"+ControllerTablero.getsPropia().getNombre(), null, Cliente.ip);
            Thread tc = new Thread(c);
            tc.start();
            Accion accion = new Accion ("Se activó: "+ControllerTablero.getsPropia().getNombre()+"\n");
            ControllerTablero.getRegistro().add(accion);
            ControllerTablero.setsPropia(null);
            ControllerTablero.setSecretoP(false);
        }
    }
}
