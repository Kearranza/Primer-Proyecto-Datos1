package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.codehaus.jackson.map.ObjectMapper;
import sample.Juego.Cartas.Esbirro;
import sample.Juego.Cartas.Hechizos.Calamidad;
import sample.Juego.InventarioCartas;
import sample.Juego.Jugador;
import sample.Juego.Mano;
import sample.Juego.Mazo;

public class MonsterTECG extends Application {

    @Override
    public void start(Stage loginStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("Controllers/Login.fxml"));
        loginStage.setTitle("MonstersTECG");
        root.setId("pane");
        Scene scene = new Scene(root, 1280, 720);
        loginStage.setResizable(false);
        loginStage.setScene(scene);
        Jugador jugador = new Jugador();
        loginStage.show();

        //ObjectMapper objectMapper = new ObjectMapper();
        //Esbirro cali = new Esbirro(10,"Esbirro/Jorge.png",10);
        //String mecagoenmaven = objectMapper.writeValueAsString(cali);
        //System.out.println(mecagoenmaven);

    }


    public static void main(String[] args) {
        launch(args);
    }
}
