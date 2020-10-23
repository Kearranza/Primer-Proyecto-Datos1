package sample.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

public class ControllerTablero implements Initializable {
    @FXML
    public void click(ActionEvent evente){
        System.out.println("HOla");
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
