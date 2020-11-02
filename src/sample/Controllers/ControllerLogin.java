package sample.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.DialogPane;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import sample.Conexion.Cliente;
import sample.Conexion.Servidor;
import sample.Juego.Cartas.Esbirro;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ControllerLogin implements Initializable {
    @FXML
    private TextField ipE;
    @FXML
    private TextField portP;
    @FXML
    private TextField portE;
    @FXML
    public void clickHost(ActionEvent event) throws IOException {
        String portPer = portP.getText();
        boolean flag = true;
        try{
            Integer.parseInt(portPer);
            Servidor s = new Servidor(Integer.parseInt(portPer));
            if (s.isConectado() == false){
                throw new IllegalArgumentException();
            }
            else{
                Thread ts = new Thread(s);
                ts.start();

                Parent esperandoParent = FXMLLoader.load(getClass().getResource("Esperando.fxml"));
                Scene esperandoScene = new Scene(esperandoParent);

                Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
                window.setScene(esperandoScene);
                window.show();
            }

        }
        catch(NumberFormatException e){
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
        catch (IllegalArgumentException e){
            ipE.setText("");
            portP.setText("");
            portE.setText("");
            Alert error = new Alert(Alert.AlertType.ERROR);
            DialogPane dialogPane = error.getDialogPane();
            error.setTitle("Alerta");
            error.setHeaderText("Hubo un error a la hora de procesar la información digitada");
            error.setContentText("No se pudo realizar la conexion al puerto asignado.");
            error.showAndWait();
        }

    }
    @FXML
    public void clickUnirse(ActionEvent event) throws IOException {
        String portPer = portP.getText();
        String ipEx = ipE.getText();
        String portEx = portE.getText();
        boolean flag = true;
        try{
            Integer.parseInt(portPer);
            String[] componentsE = ipEx.split("\\.");
            for (int i = 0; i < componentsE.length;i++){
                Integer.parseInt(componentsE[i]);
                flag =false;
            }
            if (flag){
                Integer.parseInt(ipEx);
            }
            Integer.parseInt(portPer);
            Integer.parseInt(portEx);
            Cliente c = new Cliente(Integer.parseInt(portEx), "conectado", null, ipE.getText());
            if (c.isConectado() == false){
                throw new IllegalArgumentException();
            }
            Servidor s = new Servidor(Integer.parseInt(portPer));
            if (s.isConectado() == false){
                throw new IllegalArgumentException();
            }
            else{
                Thread tc = new Thread(c);
                tc.start();
                Thread ts = new Thread(s);
                ts.start();
                Parent esperandoParent = FXMLLoader.load(getClass().getResource("Tablero.fxml"));
                Scene esperandoScene = new Scene(esperandoParent);

                Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
                window.setScene(esperandoScene);
                window.show();
            }

        }
        catch(NumberFormatException e){
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
        catch (IllegalArgumentException e){
            ipE.setText("");
            portP.setText("");
            portE.setText("");
            Alert error = new Alert(Alert.AlertType.ERROR);
            DialogPane dialogPane = error.getDialogPane();
            error.setTitle("Alerta");
            error.setHeaderText("Hubo un error a la hora de procesar la información digitada");
            error.setContentText("No se pudo realizar la conexion al puerto asignado.");
            error.showAndWait();
        }

    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
