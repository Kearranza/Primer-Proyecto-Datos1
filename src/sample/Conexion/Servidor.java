package sample.Conexion;

import org.codehaus.jackson.map.ObjectMapper;
import sample.Controllers.ControllerTablero;
import sample.Juego.Adversario;
import sample.Juego.Cartas.Carta;
import sample.Juego.Cartas.Esbirro;
import sample.Juego.Cartas.Hechizos.*;
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
 * The type Servidor.
 */
public class Servidor extends Observable implements Runnable{

    private boolean ocupado;
    /**
     * The Puerto.
     */
    public int puerto;
    private boolean conectado;
    /**
     * The Servidor.
     */
    public ServerSocket servidor = null;

    /**
     * Instantiates a new Servidor.
     *
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

    /**
     * Is conectado boolean.
     *
     * @return the boolean
     */
    public boolean isConectado() {
        return conectado;
    }

    /**
     * Is ocupado boolean.
     *
     * @return the boolean
     */
    public boolean isOcupado() {
        return ocupado;
    }

    /**
     * Sets ocupado.
     *
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
                else if(components[0].equals("vida")){
                    int vida= Integer.parseInt(components[1]);
                    Adversario.getInstance().cambioVida(vida);
                }
                else if(components[0].equals("mana")){
                    int mana = Integer.parseInt(components[1]);
                    Adversario.getInstance().cambioMana(mana);
                }
                else if(this.ocupado){

                    Carta carta =  new ObjectMapper().readValue(mensaje, Carta.class);
                    InventarioCartas inventario = InventarioCartas.getInstance();
                    if (carta.getTipo().equals("E")){
                        ((Esbirro) inventario.buscarImagen(carta.getImagen())).accion();
                        ControllerTablero.setAcciones(ControllerTablero.getAcciones()+"Adversario: "+carta.getNombre()+"\n");
                        Adversario.getInstance().cambioMana(-carta.getCoste());
                    }
                    else if(carta.getTipo().equals("H")){
                        if (carta.isFavor()){
                            ControllerTablero.setAcciones(ControllerTablero.getAcciones()+"Adversario: "+carta.getNombre()+"\n");
                            Adversario.getInstance().cambioMana(-carta.getCoste());
                        }
                        else{
                            if (carta.getNombre().equals("Calamidad")){
                                ((Calamidad) inventario.buscarImagen(carta.getImagen())).accion();
                                ControllerTablero.setAcciones(ControllerTablero.getAcciones()+"Adversario: "+carta.getNombre()+"\n");
                                Adversario.getInstance().cambioMana(-carta.getCoste());
                            }
                            else if (carta.getNombre().equals("Cero")){
                                ((CeroAbsoluto) inventario.buscarImagen(carta.getImagen())).accion();
                                ControllerTablero.setAcciones(ControllerTablero.getAcciones()+"Adversario: "+carta.getNombre()+"\n");
                                Adversario.getInstance().cambioMana(-carta.getCoste());
                            }
                            else if (carta.getNombre().equals("Espada")){
                                ((EspadaMaldita) inventario.buscarImagen(carta.getImagen())).accion();
                                ControllerTablero.setAcciones(ControllerTablero.getAcciones()+"Adversario: "+carta.getNombre()+"\n");
                                Adversario.getInstance().cambioMana(-carta.getCoste());
                            }
                            else if (carta.getNombre().equals("Maldicion")){
                                ((Maldicion) inventario.buscarImagen(carta.getImagen())).accion();
                                ControllerTablero.setAcciones(ControllerTablero.getAcciones()+"Adversario: "+carta.getNombre()+"\n");
                                Adversario.getInstance().cambioMana(-carta.getCoste());
                            }
                            else if (carta.getNombre().equals("Relampago")){
                                ((Relampago) inventario.buscarImagen(carta.getImagen())).accion();
                                ControllerTablero.setAcciones(ControllerTablero.getAcciones()+"Adversario: "+carta.getNombre()+"\n");
                                Adversario.getInstance().cambioMana(-carta.getCoste());
                            }
                            else if (carta.getNombre().equals("Trato")){
                                ((TratoJusto) inventario.buscarImagen(carta.getImagen())).accion();
                                ControllerTablero.setAcciones(ControllerTablero.getAcciones()+"Adversario: "+carta.getNombre()+"\n");
                                Adversario.getInstance().cambioMana(-carta.getCoste());
                            }
                        }
                    }
                    else if (carta.getTipo().equals("S")){
                        System.out.println("S");
                    }
                }
                sc.close();

            }
        }catch (IOException ex){
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);

        }

    }

}
