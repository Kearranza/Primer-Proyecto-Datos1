package sample.Conexion;

import java.io.IOException;
import java.net.ServerSocket;
import java.io.DataInputStream;
import java.net.Socket;
import java.util.Observable;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Bryan Martínez
 */
public class Servidor implements Runnable{

    /**
     *
     */
    public int puerto;
    private boolean conectado;
    /**
     *
     */
    public ServerSocket servidor = null;

    /**
     *
     * @return
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

    public boolean isConectado() {
        return conectado;
    }

    /**
     *Inicia el servidor y esta atento a recibir mensajes para notificar y crear un nuevo chat o agregar el mensaje a uno existente
     */
    @Override
    public void run() {
        Socket sc;
        DataInputStream in;
        try{
            while(true){
                sc = this.servidor.accept();
                in = new DataInputStream(sc.getInputStream());
                String mensaje = in.readUTF();
                if (mensaje.equals("conectado")){
                    System.out.println("FNAJJ");
                }
                sc.close();

            }
        }catch (IOException ex){
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);

        }

    }

}
