package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    public void clickUnirse(){
        System.out.println("Hola");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
