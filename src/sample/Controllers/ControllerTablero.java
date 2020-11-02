package sample.Controllers;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.util.Duration;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import sample.Juego.Cartas.Carta;
import sample.Juego.Jugador;

import java.io.IOException;
import java.net.URL;
import java.security.cert.TrustAnchor;
import java.util.ResourceBundle;

public class ControllerTablero implements Initializable {
    private static boolean jugable;
    private int turnos = 1;
    @FXML
    private TextArea historial;
    @FXML
    private ImageView Carta1,Carta2, Carta3, Carta4, Carta5, Carta6, Carta7, Carta8, Carta9, Carta10, CartaPreview, MazoMentira;
    private final ImageView[] OrdenCartas = new ImageView[10];
    @FXML
    private Label LabelTurnos;

    @FXML
    public void click(ActionEvent evente) throws InterruptedException, IOException {
        Jugador jugador = Jugador.getInstance();

        if (jugador.getMano().getSize() < 10) {
            Timeline t = new Timeline(new KeyFrame(Duration.seconds(0), new KeyValue(MazoMentira.translateXProperty(), 0)), new KeyFrame(Duration.seconds(1), new KeyValue(MazoMentira.translateXProperty(), 190)));
            t.play();
            t.setOnFinished(event -> {
                jugador.robar();
                Carta current = jugador.getMano().getFirst();
                for (int i = 0; i < jugador.getMano().getSize(); i++) {
                    OrdenCartas[i].setImage(current.getImage());
                    current = current.getNextMano();
                }
            });
            MazoMentira.setLayoutX(1091);
        }
        setJugable(!jugable);
        LabelTurnos.setText(String.valueOf(++this.turnos));

    }

    @FXML
    public void preview1() {
        if (jugable){
            CartaPreview.setImage(Carta1.getImage());
        }
    }

    @FXML
    public void preview2() {
        if (jugable){
            CartaPreview.setImage(Carta2.getImage());
        }
    }

    @FXML
    public void preview3() {
        if (jugable){
            CartaPreview.setImage(Carta3.getImage());
        }
    }

    @FXML
    public void preview4() {
        if (jugable){
            CartaPreview.setImage(Carta4.getImage());
        }
    }

    @FXML
    public void preview5() {
        if (jugable){
            CartaPreview.setImage(Carta5.getImage());
        }
    }

    @FXML
    public void preview6() {
        if (jugable){
            CartaPreview.setImage(Carta6.getImage());
        }
    }

    @FXML
    public void preview7() {
        if (jugable){
            CartaPreview.setImage(Carta7.getImage());
        }
    }

    @FXML
    public void preview8() {
        if (jugable){
            CartaPreview.setImage(Carta8.getImage());
        }
    }

    @FXML
    public void preview9() {
        if (jugable){
            CartaPreview.setImage(Carta9.getImage());
        }
    }

    @FXML
    public void preview10() {
        if (jugable){
            CartaPreview.setImage(Carta10.getImage());
        }
    }

    @FXML
    public void exit() {
        if (jugable){
            CartaPreview.setImage(null);
        }
    }

    public boolean isJugable() {
        return jugable;
    }

    public static void setJugable(boolean cambio) {
        jugable = cambio;
    }
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
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
            OrdenCartas[i].setImage(current.getImage());
            current = current.getNextMano();
        }
    }
}
