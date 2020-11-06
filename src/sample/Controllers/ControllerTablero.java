package sample.Controllers;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import sample.Conexion.Cliente;
import sample.Juego.Adversario;
import sample.Juego.Cartas.Carta;
import sample.Juego.InventarioCartas;
import sample.Juego.Jugador;

import java.io.IOException;
import java.net.URL;
import java.security.cert.TrustAnchor;
import java.util.ResourceBundle;

public class ControllerTablero implements Initializable{
    private static boolean jugable;
    private static boolean congelado = false;
    private static boolean sangre = false;
    private static int gratis = 0;
    private static int turnos = 1;
    private static String acciones;
    @FXML
    private TextArea historial;
    @FXML
    private ImageView Carta1,Carta2, Carta3, Carta4, Carta5, Carta6, Carta7, Carta8, Carta9, Carta10, CartaPreview, MazoMentira;
    private ImageView[] OrdenCartas = new ImageView[10];
    @FXML
    private Label LabelTurnos,VidaJugador,VidaAdversario,ManaJugador,ManaAdversario;

    public static void setAcciones(String acciones) {
        ControllerTablero.acciones = acciones;
    }

    public static String getAcciones() {
        return acciones;
    }

    public static boolean isSangre() {
        return sangre;
    }

    public static void setSangre(boolean sangre) {
        ControllerTablero.sangre = sangre;
    }

    public static int getGratis() {
        return gratis;
    }

    public static void setGratis(int gratis) {
        ControllerTablero.gratis = gratis;
    }

    public static void setCongelado(boolean congelado) {
        ControllerTablero.congelado = congelado;
    }

    @FXML
    public void terminarTurno() throws IOException {
        if (jugable){
            Cliente c = new Cliente(Cliente.puerto, "finalizar", null, Cliente.ip);
            Thread tc = new Thread(c);
            tc.start();
            aumentoTurno();
            setJugable(!jugable);
            roboGUI();
            Adversario.getInstance().cambioMana(25);
            setCongelado(false);
            setGratis(0);
            setSangre(false);
        }
    }
    public void roboGUI(){
        Jugador jugador = Jugador.getInstance();
        if (jugador.getMano().getSize() < 10) {
            Timeline t = new Timeline(new KeyFrame(Duration.seconds(0), new KeyValue(MazoMentira.translateXProperty(), 0)), new KeyFrame(Duration.seconds(1), new KeyValue(MazoMentira.translateXProperty(), 190)));
            t.play();
            t.setOnFinished(event -> {
                jugador.robar();
                Carta current = jugador.getMano().getFirst();
                for (int i = 0; i < jugador.getMano().getSize(); i++) {
                    Image image = new Image(getClass().getResourceAsStream(current.getImagen()));
                    OrdenCartas[i].setImage(image);
                    current = current.getNextMano();
                }
            });
            MazoMentira.setLayoutX(1091);
        }
    }

    public static void setJugable(boolean cambio) { jugable = cambio; }

    public static void aumentoTurno() { ControllerTablero.turnos++; }

    @FXML
    public void update(){
        LabelTurnos.setText(String.valueOf(turnos));
        VidaJugador.setText(String.valueOf(Jugador.getInstance().getPv()));
        ManaJugador.setText(String.valueOf(Jugador.getInstance().getMana()));
        VidaAdversario.setText(String.valueOf(Adversario.getInstance().getPv()));
        ManaAdversario.setText(String.valueOf(Adversario.getInstance().getMana()));
        historial.setText(acciones);

    }
    public void preview1() {
        if (jugable){ CartaPreview.setImage(Carta1.getImage()); }
    }
    public void preview2() {
        if (jugable){ CartaPreview.setImage(Carta2.getImage()); }
    }
    public void preview3() {
        if (jugable){ CartaPreview.setImage(Carta3.getImage()); }
    }
    public void preview4() {
        if (jugable){ CartaPreview.setImage(Carta4.getImage()); }
    }
    public void preview5() {
        if (jugable){ CartaPreview.setImage(Carta5.getImage()); }
    }
    public void preview6() {
        if (jugable){ CartaPreview.setImage(Carta6.getImage()); }
    }
    public void preview7() {
        if (jugable){ CartaPreview.setImage(Carta7.getImage()); }
    }
    public void preview8() {
        if (jugable){ CartaPreview.setImage(Carta8.getImage()); }
    }
    public void preview9() {
        if (jugable){ CartaPreview.setImage(Carta9.getImage()); }
    }
    public void preview10() {
        if (jugable){ CartaPreview.setImage(Carta10.getImage()); }
    }
    public void exit() {
        if (jugable){ CartaPreview.setImage(null); }
    }
    @FXML
    public void invocacion1() throws IOException {
        System.out.println("1");
        Jugador jugador = Jugador.getInstance();
        Carta carta = jugador.getMano().buscar(0);
        if(carta.getNombre().equals("Vapor")){
            setCongelado(false);
        }
        System.out.println("2");
        if ((jugable) && (Carta1.getImage() != null) && (!congelado)) {
            if((carta.getCoste()<=jugador.getMana()) || (gratis > 0)){
                if(carta.getNombre().equals("Robar")){
                    roboGUI();
                }
                System.out.println("3");
                jugador.invocar(0);
                Carta current = jugador.getMano().getFirst();
                for (int i = 0; i < jugador.getMano().getSize(); i++) {
                    Image image = new Image(getClass().getResourceAsStream(current.getImagen()));
                    OrdenCartas[i].setImage(image);
                    current = current.getNextMano();
                }
                OrdenCartas[jugador.getMano().getSize()].setImage(null);
                CartaPreview.setImage(null);


            }
        }
    }
    public void invocacion2() throws IOException {
        Jugador jugador = Jugador.getInstance();
        Carta carta = jugador.getMano().buscar(1);
        if(carta.getNombre().equals("Vapor")){
            setCongelado(false);
        }
        if ((jugable) && (Carta1.getImage() != null) && (!congelado)) {
            if((carta.getCoste()<=jugador.getMana()) || (gratis > 0)){
                if(carta.getNombre().equals("Robar")){
                    roboGUI();
                }
                jugador.invocar(1);
                Carta current = jugador.getMano().getFirst();
                for (int i = 0; i < jugador.getMano().getSize(); i++) {
                    Image image = new Image(getClass().getResourceAsStream(current.getImagen()));
                    OrdenCartas[i].setImage(image);
                    current = current.getNextMano();
                }
                OrdenCartas[jugador.getMano().getSize()].setImage(null);
                CartaPreview.setImage(null);


            }
        }
    }
    public void invocacion3() throws IOException {
        Jugador jugador = Jugador.getInstance();
        Carta carta = jugador.getMano().buscar(2);
        if(carta.getNombre().equals("Vapor")){
            setCongelado(false);
        }
        if ((jugable) && (Carta1.getImage() != null) && (!congelado)) {
            if((carta.getCoste()<=jugador.getMana()) || (gratis > 0)){
                if(carta.getNombre().equals("Robar")){
                    roboGUI();
                }
                jugador.invocar(2);
                Carta current = jugador.getMano().getFirst();
                for (int i = 0; i < jugador.getMano().getSize(); i++) {
                    Image image = new Image(getClass().getResourceAsStream(current.getImagen()));
                    OrdenCartas[i].setImage(image);
                    current = current.getNextMano();
                }
                OrdenCartas[jugador.getMano().getSize()].setImage(null);
                CartaPreview.setImage(null);


            }
        }
    }
    public void invocacion4() throws IOException {
        Jugador jugador = Jugador.getInstance();
        Carta carta = jugador.getMano().buscar(3);
        if(carta.getNombre().equals("Vapor")){
            setCongelado(false);
        }
        if ((jugable) && (Carta1.getImage() != null) && (!congelado)) {
            if((carta.getCoste()<=jugador.getMana()) || (gratis > 0)){
                if(carta.getNombre().equals("Robar")){
                    roboGUI();
                }
                jugador.invocar(3);
                Carta current = jugador.getMano().getFirst();
                for (int i = 0; i < jugador.getMano().getSize(); i++) {
                    Image image = new Image(getClass().getResourceAsStream(current.getImagen()));
                    OrdenCartas[i].setImage(image);
                    current = current.getNextMano();
                }
                OrdenCartas[jugador.getMano().getSize()].setImage(null);
                CartaPreview.setImage(null);


            }
        }
    }
    public void invocacion5() throws IOException {
        Jugador jugador = Jugador.getInstance();
        Carta carta = jugador.getMano().buscar(4);
        if(carta.getNombre().equals("Vapor")){
            setCongelado(false);
        }
        if ((jugable) && (Carta1.getImage() != null) && (!congelado)) {
            if((carta.getCoste()<=jugador.getMana()) || (gratis > 0)){
                if(carta.getNombre().equals("Robar")){
                    roboGUI();
                }
                jugador.invocar(4);
                Carta current = jugador.getMano().getFirst();
                for (int i = 0; i < jugador.getMano().getSize(); i++) {
                    Image image = new Image(getClass().getResourceAsStream(current.getImagen()));
                    OrdenCartas[i].setImage(image);
                    current = current.getNextMano();
                }
                OrdenCartas[jugador.getMano().getSize()].setImage(null);
                CartaPreview.setImage(null);


            }
        }
    }
    public void invocacion6() throws IOException {
        Jugador jugador = Jugador.getInstance();
        Carta carta = jugador.getMano().buscar(5);
        if(carta.getNombre().equals("Vapor")){
            setCongelado(false);
        }
        if ((jugable) && (Carta1.getImage() != null) && (!congelado)) {
            if((carta.getCoste()<=jugador.getMana()) || (gratis > 0)){
                if(carta.getNombre().equals("Robar")){
                    roboGUI();
                }
                jugador.invocar(5);
                Carta current = jugador.getMano().getFirst();
                for (int i = 0; i < jugador.getMano().getSize(); i++) {
                    Image image = new Image(getClass().getResourceAsStream(current.getImagen()));
                    OrdenCartas[i].setImage(image);
                    current = current.getNextMano();
                }
                OrdenCartas[jugador.getMano().getSize()].setImage(null);
                CartaPreview.setImage(null);


            }
        }
    }
    public void invocacion7() throws IOException {
        Jugador jugador = Jugador.getInstance();
        Carta carta = jugador.getMano().buscar(6);
        if(carta.getNombre().equals("Vapor")){
            setCongelado(false);
        }
        if ((jugable) && (Carta1.getImage() != null) && (!congelado)) {
            if((carta.getCoste()<=jugador.getMana()) || (gratis > 0)){
                if(carta.getNombre().equals("Robar")){
                    roboGUI();
                }
                jugador.invocar(6);
                Carta current = jugador.getMano().getFirst();
                for (int i = 0; i < jugador.getMano().getSize(); i++) {
                    Image image = new Image(getClass().getResourceAsStream(current.getImagen()));
                    OrdenCartas[i].setImage(image);
                    current = current.getNextMano();
                }
                OrdenCartas[jugador.getMano().getSize()].setImage(null);
                CartaPreview.setImage(null);


            }
        }
    }
    public void invocacion8() throws IOException {
        Jugador jugador = Jugador.getInstance();
        Carta carta = jugador.getMano().buscar(7);
        if(carta.getNombre().equals("Vapor")){
            setCongelado(false);
        }
        if ((jugable) && (Carta1.getImage() != null) && (!congelado)) {
            if((carta.getCoste()<=jugador.getMana()) || (gratis > 0)){
                if(carta.getNombre().equals("Robar")){
                    roboGUI();
                }
                jugador.invocar(7);
                Carta current = jugador.getMano().getFirst();
                for (int i = 0; i < jugador.getMano().getSize(); i++) {
                    Image image = new Image(getClass().getResourceAsStream(current.getImagen()));
                    OrdenCartas[i].setImage(image);
                    current = current.getNextMano();
                }
                OrdenCartas[jugador.getMano().getSize()].setImage(null);
                CartaPreview.setImage(null);


            }
        }
    }
    public void invocacion9() throws IOException {
        Jugador jugador = Jugador.getInstance();
        Carta carta = jugador.getMano().buscar(8);
        if(carta.getNombre().equals("Vapor")){
            setCongelado(false);
        }
        if ((jugable) && (Carta1.getImage() != null) && (!congelado)) {
            if((carta.getCoste()<=jugador.getMana()) || (gratis > 0)){
                if(carta.getNombre().equals("Robar")){
                    roboGUI();
                }
                jugador.invocar(8);
                Carta current = jugador.getMano().getFirst();
                for (int i = 0; i < jugador.getMano().getSize(); i++) {
                    Image image = new Image(getClass().getResourceAsStream(current.getImagen()));
                    OrdenCartas[i].setImage(image);
                    current = current.getNextMano();
                }
                OrdenCartas[jugador.getMano().getSize()].setImage(null);
                CartaPreview.setImage(null);


            }
        }
    }
    public void invocacion10() throws IOException {
        Jugador jugador = Jugador.getInstance();
        Carta carta = jugador.getMano().buscar(9);
        if(carta.getNombre().equals("Vapor")){
            setCongelado(false);
        }
        if ((jugable) && (Carta1.getImage() != null) && (!congelado)) {
            if((carta.getCoste()<=jugador.getMana()) || (gratis > 0)){
                if(carta.getNombre().equals("Robar")){
                    roboGUI();
                }
                jugador.invocar(9);
                Carta current = jugador.getMano().getFirst();
                for (int i = 0; i < jugador.getMano().getSize(); i++) {
                    Image image = new Image(getClass().getResourceAsStream(current.getImagen()));
                    OrdenCartas[i].setImage(image);
                    current = current.getNextMano();
                }
                OrdenCartas[jugador.getMano().getSize()].setImage(null);
                CartaPreview.setImage(null);


            }
        }
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Tablero.fxml"));
        ControllerTablero controller = loader.getController();
        OrdenCartas[0] = Carta1;
        OrdenCartas[1] = Carta2;
        OrdenCartas[2] = Carta3;
        OrdenCartas[3] = Carta4;
        OrdenCartas[4] = Carta5;
        OrdenCartas[5] = Carta6;
        OrdenCartas[6] = Carta7;
        OrdenCartas[7] = Carta8;
        OrdenCartas[8] = Carta9;
        OrdenCartas[9] = Carta10;
        Jugador jugador = Jugador.getInstance();
        Carta current = jugador.getMano().getFirst();
        for (int i = 0; i < jugador.getMano().getSize(); i++) {
            Image image = new Image(getClass().getResourceAsStream(current.getImagen()));
            OrdenCartas[i].setImage(image);
            current = current.getNextMano();
        }
    }
}
