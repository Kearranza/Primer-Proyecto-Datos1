package sample.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import sample.Juego.Cartas.Carta;
import sample.Juego.Jugador;

import java.net.URL;
import java.util.ResourceBundle;

public class ControllerTablero implements Initializable {
    @FXML
    private TextArea historial;
    @FXML
    private ImageView Carta1, Carta2, Carta3, Carta4, Carta5, Carta6, Carta7, Carta8, Carta9, Carta10, CartaPreview;
    private ImageView OrdenCartas[] = new ImageView[10];

    @FXML
    public void click(ActionEvent evente) {
        Jugador jugador = Jugador.getInstance();
        if (jugador.getMano().getSize()<10){
            jugador.robar();
            Carta current = jugador.getMano().getFirst();
            for (int i = 0; i < jugador.getMano().getSize(); i++) {
                OrdenCartas[i].setImage(current.getImage());
                current = current.getNextMano();
            }
        }
    }
    @FXML
    public void preview1(){ CartaPreview.setImage(Carta1.getImage());}
    @FXML
    public void preview2(){ CartaPreview.setImage(Carta2.getImage());}
    @FXML
    public void preview3(){ CartaPreview.setImage(Carta3.getImage());}
    @FXML
    public void preview4(){ CartaPreview.setImage(Carta4.getImage());}
    @FXML
    public void preview5(){ CartaPreview.setImage(Carta5.getImage());}
    @FXML
    public void preview6(){ CartaPreview.setImage(Carta6.getImage());}
    @FXML
    public void preview7(){ CartaPreview.setImage(Carta7.getImage());}
    @FXML
    public void preview8(){ CartaPreview.setImage(Carta8.getImage());}
    @FXML
    public void preview9(){ CartaPreview.setImage(Carta9.getImage());}
    @FXML
    public void preview10(){ CartaPreview.setImage(Carta10.getImage());}
    @FXML
    public void exit(){
        CartaPreview.setImage(null);
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
        for (int i = 0; i < jugador.getMano().getSize();i++){
            OrdenCartas[i].setImage(current.getImage());
            current = current.getNextMano();
        }
    }
}
