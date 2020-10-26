package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
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
    }


    public static void main(String[] args) {
        launch(args);
    }
}
