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
import javafx.scene.control.Alert;
import javafx.scene.control.DialogPane;
import javafx.scene.control.TextField;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ControllerLogin implements Initializable {
    @FXML
    private TextField ipP;
    @FXML
    private TextField ipE;
    @FXML
    private TextField portP;
    @FXML
    private TextField portE;
    @FXML
    public void clickHost(ActionEvent event) throws IOException {
        String ipPer = ipP.getText();
        String portPer = portP.getText();
        boolean flag = true;
        try{
            String[] componentsP = ipPer.split("\\.");
            for (int i = 0; i < componentsP.length;i++){
                Integer.parseInt(componentsP[i]);
                flag =false;
            }
            if (flag){
                Integer.parseInt(ipPer);
            }
            Integer.parseInt(portPer);

            Parent esperandoParent = FXMLLoader.load(getClass().getResource("Esperando.fxml"));
            Scene esperandoScene = new Scene(esperandoParent);

            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            window.setScene(esperandoScene);
            window.show();
        }
        catch(NumberFormatException e){
            ipP.setText("");
            ipE.setText("");
            portP.setText("");
            portE.setText("");
            Alert error = new Alert(Alert.AlertType.ERROR);
            DialogPane dialogPane = error.getDialogPane();
            error.setTitle("Alerta");
            error.setHeaderText("Hubo un error a la hora de procesar la información digitada");
            error.setContentText("Se escribió de forma incorrecta, ya sea, un ip o un puerto, por favor escriba nada más números.");
            error.showAndWait();
        }

    }
    @FXML
    public void clickUnirse(ActionEvent event) throws IOException {
        String ipPer = ipP.getText();
        String portPer = portP.getText();
        String ipEx = ipE.getText();
        String portEx = portE.getText();
        boolean flag = true;
        try{
            String[] componentsP = ipPer.split("\\.");
            for (int i = 0; i < componentsP.length;i++){
                Integer.parseInt(componentsP[i]);
                flag =false;
            }
            if (flag){
                Integer.parseInt(ipPer);
            }
            Integer.parseInt(portPer);
            String[] componentsE = ipEx.split("\\.");
            for (int i = 0; i < componentsE.length;i++){
                Integer.parseInt(componentsE[i]);
                flag =false;
            }
            if (flag){
                Integer.parseInt(ipEx);
            }
            Integer.parseInt(portEx);
            Parent esperandoParent = FXMLLoader.load(getClass().getResource("Tablero.fxml"));
            Scene esperandoScene = new Scene(esperandoParent);

            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            window.setScene(esperandoScene);
            window.show();
        }
        catch(NumberFormatException e){
            ipP.setText("");
            ipE.setText("");
            portP.setText("");
            portE.setText("");
            Alert error = new Alert(Alert.AlertType.ERROR);
            DialogPane dialogPane = error.getDialogPane();
            error.setTitle("Alerta");
            error.setHeaderText("Hubo un error a la hora de procesar la información digitada");
            error.setContentText("Se escribió de forma incorrecta, ya sea, un ip o un puerto, por favor escriba nada más números.");
            error.showAndWait();
        }

    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
