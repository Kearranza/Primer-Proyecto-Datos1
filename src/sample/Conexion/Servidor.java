package sample.Conexion;

import org.codehaus.jackson.map.ObjectMapper;
import sample.Controllers.ControllerTablero;
import sample.Juego.Cartas.Carta;
import sample.Juego.Cartas.Esbirro;
import sample.Juego.InventarioCartas;

import java.io.IOException;
import java.net.ServerSocket;
import java.io.DataInputStream;
import java.net.Socket;
import java.util.Observable;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Servidor extends Observable implements Runnable{

    private boolean ocupado;
    public int puerto;
    private boolean conectado;
    public ServerSocket servidor = null;

    public Servidor(int puerto){
        try{
            this.servidor = new ServerSocket(puerto);
            this.puerto= puerto;
            this.conectado = true;
        }catch(IOException ex){
            this.conectado = false;
        }
    }

    public boolean isConectado() {
        return conectado;
    }

    public boolean isOcupado() {
        return ocupado;
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
                    System.out.println("holaa");
                }
                else if(this.ocupado){
                    Carta carta =  new ObjectMapper().readValue(mensaje, Carta.class);
                    InventarioCartas inventario = InventarioCartas.getInstance();
                    if (carta.getTipo().equals("E")){
                        ((Esbirro) inventario.buscarImagen(carta.getImagen())).accion();
                    }
                    else if(carta.getTipo().equals("H")){
                        System.out.println("H");
                    }
                    else{
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
