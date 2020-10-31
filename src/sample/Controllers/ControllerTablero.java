package sample.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;

import java.net.URL;
import java.util.ResourceBundle;

public class ControllerTablero implements Initializable {
    @FXML
    private TextArea historial;
    @FXML
    public void click(ActionEvent evente){
        historial.appendText("Hola"+"\n");
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }
}
