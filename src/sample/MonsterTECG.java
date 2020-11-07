package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
/**
 * @author Bryan Martínez y Kevin Carranza
 * The type Monster tecg.
 * Esta es la clase main MonsterTECG, que se encarga de iniciar el juego.
 */
public class MonsterTECG extends Application {

    @Override
    public void start(Stage loginStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("Controllers/Login.fxml"));
        loginStage.setTitle("MonstersTECG");
        root.setId("pane");
        Scene scene = new Scene(root, 1280, 720);
        loginStage.setResizable(false);
        loginStage.setScene(scene);
        loginStage.show();
    }


    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
