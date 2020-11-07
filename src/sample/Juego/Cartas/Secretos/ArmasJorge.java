package sample.Juego.Cartas.Secretos;

import sample.Conexion.Cliente;
import sample.Juego.Adversario;
import sample.Juego.Cartas.Carta;

import java.io.IOException;

/**
 * @author Bryan Martínez y Kevin Carranza
 * The type Armas jorge.
 *Esta es la clase ArmasJorge que se encarga de almacenar los datos de una carta de este tipo(Clase hija de Carta).
 */
public class ArmasJorge extends Carta {
    /**
     * Instantiates a new Armas jorge.
     *
     * @param coste  the coste
     * @param imagen the imagen
     */
    public ArmasJorge(int coste, String imagen) {
        super(coste, imagen,"S", false);
    }

    public void accion() throws IOException {
        Adversario.getInstance().setPv(-999);
        Cliente cv = new Cliente(Cliente.puerto, "Jorge"+"|"+ "-999", null, Cliente.ip);
        Thread tcv = new Thread(cv);
        tcv.start();
    }

}
