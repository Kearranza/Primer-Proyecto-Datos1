package sample.Conexion;

import org.codehaus.jackson.map.ObjectMapper;
import sample.Controllers.ControllerTablero;
import sample.Juego.Cartas.Carta;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ConnectException;
import java.net.Socket;
import java.net.SocketException;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Bryan Martínez y Kevin Carranza
 * The type Cliente.
 * Esta es la Clase cliente la cual se encarga de comunicarse con el servidor.
 */
public class Cliente implements Runnable{

    /**
     * The constant puerto.
     */
    public static int puerto;
    /**
     * The Mensaje.
     */
    public String mensaje;
    private boolean conectado;
    /**
     * The constant ip.
     */
    public static String ip;

    /**
     * Instantiates a new Cliente.
     * @param puerto  the puerto
     * @param mensaje the mensaje
     * @param carta   the carta
     * @param ip      the ip
     * @throws IOException the io exception
     */
    public Cliente(int puerto, String mensaje, Carta carta, String ip) throws IOException {
        String[] components = mensaje.split("\\|");
        if (carta != null){
            ObjectMapper objectMapper = new ObjectMapper();
            String Cmapper = objectMapper.writeValueAsString(carta);
            this.mensaje = Cmapper;
        }else if(mensaje.equals("finalizar")){
            this.mensaje = mensaje;
        }
        else if(components[0].equals("vida")){
            this.mensaje = mensaje;

        }
        else if(components[0].equals("mana")){
            this.mensaje = mensaje;
        }
        else{
            try {
                this.puerto = puerto;
                this.mensaje= mensaje;
                this.ip = ip;
                this.conectado = true;
                DataOutputStream  out;
                Socket sc = new Socket(this.ip, this.puerto);
                out = new DataOutputStream(sc.getOutputStream());
                out.writeUTF("");
                sc.close();
            }
            catch (ConnectException e){
                this.conectado = false;

            } catch (SocketException e){
                this.conectado = false;

            } catch (IOException ex) {
                Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }

    /**
     * Is conectado boolean.
     * @return the boolean
     */
    public boolean isConectado() {
        return conectado;
    }

    @Override
    public void run() {
        DataOutputStream out;
        try{
            Socket sc = new Socket(this.ip, this.puerto);
            out = new DataOutputStream(sc.getOutputStream());
            out.writeUTF(this.mensaje);
            sc.close();
        }catch(ConnectException e){
            this.conectado = false;
        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
