package sample;

import javafx.beans.property.ObjectProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    public void cambiarEsperar(ActionEvent event) throws IOException {
        Parent esperandoParent = FXMLLoader.load(getClass().getResource("Esperando.fxml"));
        Scene esperandoScene = new Scene(esperandoParent);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(esperandoScene);
        window.show();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
