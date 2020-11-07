package sample.Conexion;

import org.codehaus.jackson.map.ObjectMapper;
import sample.Controllers.ControllerTablero;
import sample.Juego.Accion;
import sample.Juego.Adversario;
import sample.Juego.Cartas.Carta;
import sample.Juego.Cartas.Esbirro;
import sample.Juego.Cartas.Hechizos.*;
import sample.Juego.Cartas.Secretos.*;
import sample.Juego.InventarioCartas;
import sample.Juego.Jugador;

import java.io.IOException;
import java.net.ServerSocket;
import java.io.DataInputStream;
import java.net.Socket;
import java.util.Observable;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Bryan Martínez y Kevin Carranza
 * The type Servidor.
 * Esta es la clase Servidor que se encarga de recibir los mensajes de la clase cliente.
 */
public class Servidor extends Observable implements Runnable{

    private boolean ocupado;
    /**
     * The Puerto.
     */
    public int puerto;
    private boolean conectado;
    private static boolean activada = false;
    /**
     * The Servidor.
     */
    public ServerSocket servidor = null;

    /**
     * Instantiates a new Servidor.
     * @param puerto the puerto
     */
    public Servidor(int puerto){
        try{
            this.servidor = new ServerSocket(puerto);
            this.puerto= puerto;
            this.conectado = true;
        }catch(IOException ex){
            this.conectado = false;
        }
    }

    public static void setActivada(boolean activada) {
        Servidor.activada = activada;
    }

    /**
     * Is conectado boolean.
     * @return the boolean
     */
    public boolean isConectado() {
        return conectado;
    }

    /**
     * Sets ocupado.
     * @param ocupado the ocupado
     */
    public void setOcupado(boolean ocupado) {
        this.ocupado = ocupado;
    }

    @Override
    public void run() {
        Socket sc;
        DataInputStream in;
        try{
            while(true){
                sc = this.servidor.accept();
                in = new DataInputStream(sc.getInputStream());
                String mensaje = in.readUTF();
                String[] components = mensaje.split("\\|");
                if ((components[0].equals("conectado")) && (this.ocupado == false)){
                    Cliente.puerto = Integer.parseInt(components[1]);
                    Cliente.ip = components[2];
                    this.ocupado = true;

                }else if(mensaje.equals("finalizar")){
                    ControllerTablero.setJugable(true);
                    ControllerTablero.aumentoTurno();
                    Jugador.getInstance().cambioMana(25);
                }
                else if (components[0].equals("agotar")){
                    ControllerTablero.setAgotamiento(2);
                }
                else if(components[0].equals("vida")){
                    int vida= Integer.parseInt(components[1]);
                    Adversario.getInstance().cambioVida(vida);
                }
                else if(components[0].equals("Jorge")){
                    int vida= Integer.parseInt(components[1]);
                    Jugador.getInstance().setPv(vida);
                }
                else if(components[0].equals("mana")){
                    int mana = Integer.parseInt(components[1]);
                    Adversario.getInstance().cambioMana(mana);
                }
                else if(components[0].equals("activacion")){
                    Accion accion = new Accion ("Se activó: "+components[1]+"\n");
                    ControllerTablero.getRegistro().add(accion);
                    ControllerTablero.setsRival(null);
                    ControllerTablero.setSecretoR(false);
                }
                else if(this.ocupado){
                    Carta carta =  new ObjectMapper().readValue(mensaje, Carta.class);
                    InventarioCartas inventario = InventarioCartas.getInstance();
                    Adversario.getInstance().cambioMana(-carta.getCoste());
                    if (!carta.getTipo().equals("S")){
                        Accion accion = new Accion ("Adversario: "+carta.getNombre()+"\n");
                        ControllerTablero.getRegistro().add(accion);
                    }
                    if (ControllerTablero.isSecretoP()){
                        if (ControllerTablero.getsPropia().getNombre().equals("Apaciguar")){
                            ((Apaciguar) inventario.buscarImagen(ControllerTablero.getsPropia().getImagen())).accion(carta);
                        }
                        else if (ControllerTablero.getsPropia().getNombre().equals("Contrataque")){
                            ((Contrataque) inventario.buscarImagen(ControllerTablero.getsPropia().getImagen())).accion(carta);
                        }
                        else if (ControllerTablero.getsPropia().getNombre().equals("BarreraD")){
                            ((BarreraDrenadora) inventario.buscarImagen(ControllerTablero.getsPropia().getImagen())).accion(carta);
                        }
                        else if (ControllerTablero.getsPropia().getNombre().equals("BarreraMana")){
                            ((BarreraMana) inventario.buscarImagen(ControllerTablero.getsPropia().getImagen())).accion(carta);
                        }
                        else if (ControllerTablero.getsPropia().getNombre().equals("Compasion")){
                            ((Compasion) inventario.buscarImagen(ControllerTablero.getsPropia().getImagen())).accion(carta);
                        }

                        else if (ControllerTablero.getsPropia().getNombre().equals("Escudo")){
                            ((Escudo) inventario.buscarImagen(ControllerTablero.getsPropia().getImagen())).accion(carta);
                        }
                        else if (ControllerTablero.getsPropia().getNombre().equals("GBarrera")){
                            ((GranBarrera) inventario.buscarImagen(ControllerTablero.getsPropia().getImagen())).accion(carta);
                        }
                        else if (ControllerTablero.getsPropia().getNombre().equals("Mimic")){
                            ((Mimic) inventario.buscarImagen(ControllerTablero.getsPropia().getImagen())).accion(carta);
                        }
                        else if (ControllerTablero.getsPropia().getNombre().equals("Vacio")){
                            ((Vacio) inventario.buscarImagen(ControllerTablero.getsPropia().getImagen())).accion(carta);
                        }
                    }

                    if ((carta.getTipo().equals("E")) && (!activada)){
                        ((Esbirro) inventario.buscarImagen(carta.getImagen())).accion();
                    }
                    if((carta.getTipo().equals("H"))&& (!activada)){
                        if (carta.getNombre().equals("Calamidad")){
                            ((Calamidad) inventario.buscarImagen(carta.getImagen())).accion();
                        }
                        else if (carta.getNombre().equals("Cero")){
                            ((CeroAbsoluto) inventario.buscarImagen(carta.getImagen())).accion();
                        }
                        else if (carta.getNombre().equals("Espada")){
                            ((EspadaMaldita) inventario.buscarImagen(carta.getImagen())).accion();
                        }
                        else if (carta.getNombre().equals("Maldicion")){
                            ((Maldicion) inventario.buscarImagen(carta.getImagen())).accion();
                        }
                        else if (carta.getNombre().equals("Relampago")){
                            ((Relampago) inventario.buscarImagen(carta.getImagen())).accion();
                        }
                        else if (carta.getNombre().equals("Trato")){
                            ((TratoJusto) inventario.buscarImagen(carta.getImagen())).accion();
                        }
                    }
                    if ((carta.getTipo().equals("S")) && (!activada)){
                        Carta cartaI = new Carta(0,"Secreto/Incognita.png", "", false);
                        ControllerTablero.setsRival(cartaI);
                        ControllerTablero.setSecretoR(true);
                        Accion accion = new Accion ("Adversario: ???"+"\n");
                        ControllerTablero.getRegistro().add(accion);

                    }
                }
                activada = false;
                sc.close();

            }
        }catch (IOException ex){
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);

        }

    }

}
