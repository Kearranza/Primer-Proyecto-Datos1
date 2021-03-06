package sample.Juego;

import sample.Conexion.Cliente;
import sample.Controllers.ControllerTablero;
import sample.Juego.Cartas.Carta;
import sample.Juego.Cartas.Hechizos.*;
import sample.Juego.Cartas.Secretos.ArmasJorge;

import java.io.IOException;

/**
 * @author Bryan Martínez y Kevin Carranza
 * The type Jugador.
 * Esta es la clase Jugador se encarga de llevar todos los datos relacionados al jugador
 */
public class Jugador {
    /**
     * The constant instance.
     */
    public static Jugador instance = null;
    private int pv;
    private int mana;
    private Mano mano;
    private Mazo mazo;

    /**
     * Get instance jugador.
     * @return the jugador
     */
    public static Jugador getInstance(){
        if (instance == null){
            instance = new Jugador();
        }
        return instance;
    }

    /**
     * Instantiates a new Jugador.
     */
    public Jugador() {
        Mano mano = new Mano();
        this.mano = mano;
        this.crearMazo();
        this.mana = 20;
        this.pv = 100;
    }

    /**
     * Crear mazo.
     */
    public void crearMazo(){
        Mazo mazo = new Mazo(this.mano);
        this.mazo = mazo;
    }

    /**
     * Gets pv.
     * @return the pv
     */
    public int getPv() {
        return this.pv;
    }

    /**
     * Sets pv.
     * @param pv the pv
     */
    public void setPv(int pv) { this.pv = pv; }

    /**
     * Gets mana.
     * @return the mana
     */
    public int getMana() {
        return this.mana;
    }

    /**
     * Sets mana.
     * @param mana the mana
     */
    public void setMana(int mana) {
        this.mana = mana;
    }

    /**
     * Gets mano.
     * @return the mano
     */
    public Mano getMano() { return this.mano; }

    /**
     * Gets mazo.
     * @return the mazo
     */
    public Mazo getMazo() {
        return this.mazo;
    }

    /**
     * Cambio vida.
     * Se encarga de reducir o aumentar los pv del jugador segun se necesite
     * @param valor the valor
     */
    public void cambioVida(int valor){
        if ((this.pv + valor)>100){
            Jugador.getInstance().setPv(100);
        }
        else if((this.pv + valor)<0){
            Jugador.getInstance().setPv(0);
        }
        else{
            this.pv += valor;
        }
    }

    /**
     * Cambio mana.
     * Se encarga de reducir o aumentar el mana del jugador segun se necesite
     * @param valor the valor
     */
    public void cambioMana(int valor){
        if ((this.mana + valor)>100){
            Jugador.getInstance().setMana(100);
        }
        else{
            this.mana =this.mana + valor;

        }
    }

    /**
     * Robar.
     * Incorpora la carta del mazo a la mano
     */
    public void robar(){
        Carta robada = this.mazo.eliminar();
        this.mano.add(robada);

    }

    /**
     * Invocar.
     * Se encarga reducir el mana del jugarod actual y de enviar la carta al otro jugador
     * @param i the
     * @throws IOException the io exception
     */
    public void invocar(int i, Carta mimic) throws IOException {
        Carta carta = null;
        if (mimic == null){
            carta = this.getMano().buscar(i);
        }
        if (mimic != null){
            carta = mimic;
            carta.setCoste(0);
        }
        int coste = carta.getCoste();
        if ((ControllerTablero.getGratis() == 0) && (!carta.getTipo().equals("S"))){
            this.cambioMana(-(carta.getCoste()));
            Accion accion = new Accion ("Jugador: "+carta.getNombre()+"\n");
            ControllerTablero.getRegistro().add(accion);
        }
        if (ControllerTablero.getGratis() > 0){
            ControllerTablero.setGratis(ControllerTablero.getGratis()-1);
            carta.setCoste(0);
        }
        if (carta.getTipo().equals("E")){
            if ((ControllerTablero.isSecretoP()) && (ControllerTablero.getsPropia().getNombre().equals("ArmasJorge")&& (carta.getNombre().equals("Jorge"))) ){
                InventarioCartas inventario = InventarioCartas.getInstance();
                ((ArmasJorge) inventario.buscarImagen(ControllerTablero.getsPropia().getImagen())).accion();
            }
            else{
                Carta cartaEnviar = new Carta(carta.getCoste(), carta.getImagen(), carta.getTipo(), carta.isFavor());
                Cliente c = new Cliente(Cliente.puerto, "", cartaEnviar, Cliente.ip);
                Thread tc = new Thread(c);
                tc.start();
                this.getMano().remove(carta);
            }

        }
        if (carta.getTipo().equals("H")){
            if (carta.isFavor()){
                InventarioCartas inventario = InventarioCartas.getInstance();
                if (carta.getNombre().equals("Bendicion")){
                    ((Bendicion) inventario.buscarImagen(carta.getImagen())).accion();
                    Carta cartaEnviar = new Carta(carta.getCoste(), carta.getImagen(), carta.getTipo(), carta.isFavor());
                    Cliente c = new Cliente(Cliente.puerto, "", cartaEnviar, Cliente.ip);
                    Thread tc = new Thread(c);
                    tc.start();
                    this.getMano().remove(carta);
                }
                else if (carta.getNombre().equals("Curacion")){
                    ((Curacion) inventario.buscarImagen(carta.getImagen())).accion();
                    Carta cartaEnviar = new Carta(carta.getCoste(), carta.getImagen(), carta.getTipo(), carta.isFavor());
                    Cliente c = new Cliente(Cliente.puerto, "", cartaEnviar, Cliente.ip);
                    Thread tc = new Thread(c);
                    tc.start();
                    this.getMano().remove(carta);
                }
                else if (carta.getNombre().equals("Poder")){
                    ((PoderSupremo) inventario.buscarImagen(carta.getImagen())).accion();
                    Carta cartaEnviar = new Carta(carta.getCoste(), carta.getImagen(), carta.getTipo(), carta.isFavor());
                    Cliente c = new Cliente(Cliente.puerto, "", cartaEnviar, Cliente.ip);
                    Thread tc = new Thread(c);
                    tc.start();
                    this.getMano().remove(carta);
                }
                else if (carta.getNombre().equals("Reglas")){
                    ((ReglasAntiguas) inventario.buscarImagen(carta.getImagen())).accion();
                    Carta cartaEnviar = new Carta(carta.getCoste(), carta.getImagen(), carta.getTipo(), carta.isFavor());
                    Cliente c = new Cliente(Cliente.puerto, "", cartaEnviar, Cliente.ip);
                    Thread tc = new Thread(c);
                    tc.start();
                    this.getMano().remove(carta);
                }
                else if (carta.getNombre().equals("Sacrificio")){
                    ((SacrificioSangre) inventario.buscarImagen(carta.getImagen())).accion();
                    Carta cartaEnviar = new Carta(carta.getCoste(), carta.getImagen(), carta.getTipo(), carta.isFavor());
                    Cliente c = new Cliente(Cliente.puerto, "", cartaEnviar, Cliente.ip);
                    Thread tc = new Thread(c);
                    tc.start();
                    this.getMano().remove(carta);
                }
                else if (carta.getNombre().equals("Vapor")){
                    ((VaporGeiser) inventario.buscarImagen(carta.getImagen())).accion();
                    Carta cartaEnviar = new Carta(carta.getCoste(), carta.getImagen(), carta.getTipo(), carta.isFavor());
                    Cliente c = new Cliente(Cliente.puerto, "", cartaEnviar, Cliente.ip);
                    Thread tc = new Thread(c);
                    tc.start();
                    this.getMano().remove(carta);
                }
                else if (carta.getNombre().equals("Robar")){
                    Carta cartaEnviar = new Carta(carta.getCoste(), carta.getImagen(), carta.getTipo(), carta.isFavor());
                    Cliente c = new Cliente(Cliente.puerto, "", cartaEnviar, Cliente.ip);
                    Thread tc = new Thread(c);
                    tc.start();
                    this.getMano().remove(carta);
                }
                else if (carta.getNombre().equals("Codicia")){
                    Carta cartaEnviar = new Carta(carta.getCoste(), carta.getImagen(), carta.getTipo(), carta.isFavor());
                    Cliente c = new Cliente(Cliente.puerto, "", cartaEnviar, Cliente.ip);
                    Thread tc = new Thread(c);
                    tc.start();
                    this.getMano().remove(carta);
                }
                else if (carta.getNombre().equals("FuenteMana")){
                    ((FuenteMana) inventario.buscarImagen(carta.getImagen())).accion();
                    Carta cartaEnviar = new Carta(carta.getCoste(), carta.getImagen(), carta.getTipo(), carta.isFavor());
                    Cliente c = new Cliente(Cliente.puerto, "", cartaEnviar, Cliente.ip);
                    Thread tc = new Thread(c);
                    tc.start();
                    this.getMano().remove(carta);
                }

            }
            else{
                Carta cartaEnviar = new Carta(carta.getCoste(), carta.getImagen(), carta.getTipo(), carta.isFavor());
                Cliente c = new Cliente(Cliente.puerto, "", cartaEnviar, Cliente.ip);
                Thread tc = new Thread(c);
                tc.start();
                this.getMano().remove(carta);
            }
        }
        else if (carta.getTipo().equals("S") && (!ControllerTablero.isSecretoP())){
            if (ControllerTablero.getGratis() > 0) {
                ControllerTablero.setGratis(ControllerTablero.getGratis() - 1);
                carta.setCoste(0);
            }
            else{
                this.cambioMana(-(carta.getCoste()));
            }
            Accion accion = new Accion ("Jugador: "+carta.getNombre()+"\n");
            ControllerTablero.getRegistro().add(accion);

            ControllerTablero.setsPropia(carta);
            ControllerTablero.setSecretoP(true);
            Carta cartaEnviar = new Carta(carta.getCoste(), carta.getImagen(), carta.getTipo(), carta.isFavor());
            Cliente c = new Cliente(Cliente.puerto, "", cartaEnviar, Cliente.ip);
            Thread tc = new Thread(c);
            tc.start();
            this.getMano().remove(carta);
        }
        carta.setCoste(coste);
    }

}
