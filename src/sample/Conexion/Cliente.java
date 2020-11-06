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

public class Cliente implements Runnable{

    public static int puerto;
    public String mensaje;
    private boolean conectado;
    public static String ip;

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
