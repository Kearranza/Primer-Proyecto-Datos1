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
import sample.Juego.Historial;
import sample.Juego.InventarioCartas;
import sample.Juego.Jugador;

import java.io.IOException;
import java.net.URL;
import java.security.cert.TrustAnchor;
import java.util.ResourceBundle;


/**
 * @author Bryan Martínez y Kevin Carranza
 * The type Controller tablero.
 * Esta es la clase ControllerTablero que se encarga de controlar lo que sucede en Tablero.fxml
 */
public class ControllerTablero implements Initializable {
    private static boolean jugable;
    private static boolean congelado = false;
    private static boolean secretoP = false;
    private static boolean secretoR = false;
    private static boolean agotamiento =false;
    private static Carta sRival;
    private static Carta sPropia;
    private static int gratis = 0;
    private static int turnos = 1;
    private static Historial registro = new Historial();
    @FXML
    private TextArea historial;
    @FXML
    private ImageView Carta1, Carta2, Carta3, Carta4, Carta5, Carta6, Carta7, Carta8, Carta9, Carta10, CartaPreview, MazoMentira;
    private ImageView[] OrdenCartas = new ImageView[10];
    @FXML
    private ImageView SecretoRival;
    @FXML
    private ImageView SecretoPropia;
    @FXML
    private ImageView PantallaFinal;

    public static Historial getRegistro() {
        return registro;
    }

    public static boolean isSecretoR() {
        return secretoR;
    }

    public static void setSecretoR(boolean secretoR) {
        ControllerTablero.secretoR = secretoR;
    }

    public static Carta getsRival() {
        return sRival;
    }

    public static void setsRival(Carta sRival) {
        ControllerTablero.sRival = sRival;
    }

    public static Carta getsPropia() {
        return sPropia;
    }

    public static void setsPropia(Carta sPropia) {
        ControllerTablero.sPropia = sPropia;
    }

    public static boolean isSecretoP() {
        return secretoP;
    }

    public static void setSecretoP(boolean secretoP) {
        ControllerTablero.secretoP = secretoP;
    }
    @FXML
    private Label LabelTurnos, VidaJugador, VidaAdversario, ManaJugador, ManaAdversario;


    /**
     * Gets gratis.
     * @return the gratis
     */
    public static int getGratis() {
        return gratis;
    }

    /**
     * Sets gratis.
     * @param gratis the gratis
     */
    public static void setGratis(int gratis) {
        ControllerTablero.gratis = gratis;
    }

    /**
     * Sets congelado.
     * @param congelado the congelado
     */
    public static void setCongelado(boolean congelado) {
        ControllerTablero.congelado = congelado;
    }

    /**
     * Finalizar juego.
     */
    public void finalizarJuego(){
    }

    /**
     * Terminar turno.
     * Al detectar el click del boton juego se encargar de resetear valores su valor predefinido, cambiar el turno y robar carta.
     * @throws IOException the io exception
     */
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
        }
    }

    /**
     * Robo gui.
     * Se encarga de la animación y acción de robar una carta.
     */
    public void roboGUI(){
        Jugador jugador = Jugador.getInstance();
        if (jugador.getMano().getSize() < 10) {
            if (jugador.getInstance().getMazo().getTop() == -1){

            }
            else{
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
    }

    /**
     * Sets jugable.
     * @param cambio the cambio
     */
    public static void setJugable(boolean cambio) { jugable = cambio; }

    /**
     * Aumento turno.
     */
    public static void aumentoTurno() { ControllerTablero.turnos++; }

    /**
     * Update.
     * Se encarga de actualizar continuamente lo que se enceuntra en labels y el textArea historial.
     */
    @FXML
    public void update(){
        LabelTurnos.setText(String.valueOf(turnos));
        VidaJugador.setText(String.valueOf(Jugador.getInstance().getPv()));
        ManaJugador.setText(String.valueOf(Jugador.getInstance().getMana()));
        VidaAdversario.setText(String.valueOf(Adversario.getInstance().getPv()));
        ManaAdversario.setText(String.valueOf(Adversario.getInstance().getMana()));
        historial.setText(registro.mostrar());
        if (secretoP){
            Image imageP = new Image(getClass().getResourceAsStream(sPropia.getImagen()));
            SecretoPropia.setImage(imageP);
        }
        if (secretoR){
            Image imageR = new Image(getClass().getResourceAsStream(sRival.getImagen()));
            SecretoRival.setImage(imageR);
        }
        if (sRival == null){
            SecretoRival.setImage(null);
        }
        if (sPropia == null){
            SecretoPropia.setImage(null);
        }
        if (Jugador.getInstance().getPv() >= 0){

        }
        if (Adversario.getInstance().getPv() >= 0){

        }
        if (Adversario.getInstance().getPv() == -999){

        }
        if (Jugador.getInstance().getPv() == -999){

        }
        if (agotamiento){

        }



    }

    /**
     * Preview 1.
     * Muestra una vista previa de la imagen antes de ser seleccionada.
     */
    public void preview1() {
        if (jugable){ CartaPreview.setImage(Carta1.getImage()); }
    }

    /**
     * Preview 2.
     * Muestra una vista previa de la imagen antes de ser seleccionada.
     */
    public void preview2() {
        if (jugable){ CartaPreview.setImage(Carta2.getImage()); }
    }

    /**
     * Preview 3.
     * Muestra una vista previa de la imagen antes de ser seleccionada.
     */
    public void preview3() {
        if (jugable){ CartaPreview.setImage(Carta3.getImage()); }
    }

    /**
     * Preview 4.
     * Muestra una vista previa de la imagen antes de ser seleccionada.
     */
    public void preview4() {
        if (jugable){ CartaPreview.setImage(Carta4.getImage()); }
    }

    /**
     * Preview 5.
     * Muestra una vista previa de la imagen antes de ser seleccionada.
     */
    public void preview5() {
        if (jugable){ CartaPreview.setImage(Carta5.getImage()); }
    }

    /**
     * Preview 6.
     * Muestra una vista previa de la imagen antes de ser seleccionada.
     */
    public void preview6() {
        if (jugable){ CartaPreview.setImage(Carta6.getImage()); }
    }

    /**
     * Preview 7.
     * Muestra una vista previa de la imagen antes de ser seleccionada.
     */
    public void preview7() {
        if (jugable){ CartaPreview.setImage(Carta7.getImage()); }
    }

    /**
     * Preview 8.
     * Muestra una vista previa de la imagen antes de ser seleccionada.
     */
    public void preview8() {
        if (jugable){ CartaPreview.setImage(Carta8.getImage()); }
    }

    /**
     * Preview 9.
     * Muestra una vista previa de la imagen antes de ser seleccionada.
     */
    public void preview9() {
        if (jugable){ CartaPreview.setImage(Carta9.getImage()); }
    }

    /**
     * Preview 10.
     * Muestra una vista previa de la imagen antes de ser seleccionada.
     */
    public void preview10() {
        if (jugable){ CartaPreview.setImage(Carta10.getImage()); }
    }

    /**
     * Exit.
     * Se encarga de quitar la vista previa de las imagenes.
     */
    public void exit() {
        if (jugable){ CartaPreview.setImage(null); }
    }

    /**
     * Invocacion 1.
     * Se encarga de comprobar la carte seleccionada y verificar si puede ser usada para luego enviar la carta seleccionada al rival.
     * @throws IOException the io exception
     */
    @FXML
    public void invocacion1() throws IOException {
        Jugador jugador = Jugador.getInstance();
        Carta carta = jugador.getMano().buscar(0);
        if(carta.getNombre().equals("Vapor")){
            setCongelado(false);
        }
        if ((jugable) && (Carta1.getImage() != null) && (!congelado)) {
            if((carta.getCoste()<=jugador.getMana()) || (gratis > 0)){
                if(carta.getNombre().equals("Robar")){
                    roboGUI();
                }
                else if(carta.getNombre().equals("Codicia")){
                    roboGUI();
                    roboGUI();
                }
                jugador.invocar(0, null);
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

    /**
     * Invocacion 2.
     *Se encarga de comprobar la carte seleccionada y verificar si puede ser usada para luego enviar la carta seleccionada al rival.
     * @throws IOException the io exception
     */
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
                else if(carta.getNombre().equals("Codicia")){
                    roboGUI();
                    roboGUI();
                }
                jugador.invocar(1, null);
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

    /**
     * Invocacion 3.
     *Se encarga de comprobar la carte seleccionada y verificar si puede ser usada para luego enviar la carta seleccionada al rival.
     * @throws IOException the io exception
     */
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
                else if(carta.getNombre().equals("Codicia")){
                    roboGUI();
                    roboGUI();
                }
                jugador.invocar(2, null);
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

    /**
     * Invocacion 4.
     *Se encarga de comprobar la carte seleccionada y verificar si puede ser usada para luego enviar la carta seleccionada al rival.
     * @throws IOException the io exception
     */
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
                else if(carta.getNombre().equals("Codicia")){
                    roboGUI();
                    roboGUI();
                }
                jugador.invocar(3, null);
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

    /**
     * Invocacion 5.
     *Se encarga de comprobar la carte seleccionada y verificar si puede ser usada para luego enviar la carta seleccionada al rival.
     * @throws IOException the io exception
     */
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
                else if(carta.getNombre().equals("Codicia")){
                    roboGUI();
                    roboGUI();
                }
                jugador.invocar(4, null);
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

    /**
     * Invocacion 6.
     *Se encarga de comprobar la carte seleccionada y verificar si puede ser usada para luego enviar la carta seleccionada al rival.
     * @throws IOException the io exception
     */
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
                else if(carta.getNombre().equals("Codicia")){
                    roboGUI();
                    roboGUI();
                }
                jugador.invocar(5, null);
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

    /**
     * Invocacion 7.
     *Se encarga de comprobar la carte seleccionada y verificar si puede ser usada para luego enviar la carta seleccionada al rival.
     * @throws IOException the io exception
     */
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
                else if(carta.getNombre().equals("Codicia")){
                    roboGUI();
                    roboGUI();
                }
                jugador.invocar(6, null);
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

    /**
     * Invocacion 8.
     *Se encarga de comprobar la carte seleccionada y verificar si puede ser usada para luego enviar la carta seleccionada al rival.
     * @throws IOException the io exception
     */
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
                else if(carta.getNombre().equals("Codicia")){
                    roboGUI();
                    roboGUI();
                }
                jugador.invocar(7, null);
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

    /**
     * Invocacion 9.
     *Se encarga de comprobar la carte seleccionada y verificar si puede ser usada para luego enviar la carta seleccionada al rival.
     * @throws IOException the io exception
     */
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
                else if(carta.getNombre().equals("Codicia")){
                    roboGUI();
                    roboGUI();
                }
                jugador.invocar(8, null);
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

    /**
     * Invocacion 10.
     *Se encarga de comprobar la carte seleccionada y verificar si puede ser usada para luego enviar la carta seleccionada al rival.
     * @throws IOException the io exception
     */
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
                else if(carta.getNombre().equals("Codicia")){
                    roboGUI();
                    roboGUI();
                }
                jugador.invocar(9, null);
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
