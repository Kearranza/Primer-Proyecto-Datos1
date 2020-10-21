package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.StackPane;


public class MonstersTECG extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage loginStage) throws Exception{
        loginStage.setTitle("MonstersTECG");
        StackPane root = new StackPane();
        root.setId("pane");
        Scene scene = new Scene(root, 1280, 720);
        scene.getStylesheets().addAll(this.getClass().getResource("loginFondo.css").toExternalForm());
        loginStage.setScene(scene);
        loginStage.show();
    }



}

