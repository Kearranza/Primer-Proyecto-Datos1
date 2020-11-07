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
import sample.Conexion.Cliente;
import sample.Conexion.Servidor;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * @author Bryan Martínez y Kevin Carranza
 * The type Controller login.
 * Esta es la clase ControllerLogin que se encarga de controlar lo que sucede en Login.fxml
 */
public class ControllerLogin implements Initializable {
    @FXML
    private TextField ipE;
    @FXML
    private TextField portP;
    @FXML
    private TextField portE;

    /**
     * Click host.
     * Cuando se da click en el boton host se encarga de levantar un servidor con el port dado.
     * @param event the event
     * @throws IOException the io exception
     */
    @FXML
    public void clickHost(ActionEvent event) throws IOException {
        String portPer = portP.getText();
        try{
            Integer.parseInt(portPer);
            Servidor s = new Servidor (Integer.parseInt(portPer));
            if (s.isConectado() == false){
                throw new IllegalArgumentException();
            }
            else{
                Thread ts = new Thread(s);
                ts.start();

                Parent tableroParent = FXMLLoader.load(getClass().getResource("Tablero.fxml"));
                Scene tableroScene = new Scene(tableroParent);

                Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
                window.setScene(tableroScene);
                window.show();
                ControllerTablero.setJugable(false);
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

    /**
     * Click unirse.
     * Cuando se da click en el boton unirse se encarga de conectarse a un servidor con el port dado y brindando un port propio e ip.
     * @param event the event
     * @throws IOException the io exception
     */
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
            Cliente c = new Cliente(Integer.parseInt(portEx), "conectado"+"|"+portP.getText()+"|"+ipE.getText(), null, ipE.getText());
            if (c.isConectado() == false){
                throw new IllegalArgumentException();
            }
            Servidor s = new Servidor(Integer.parseInt(portPer));
            if (s.isConectado() == false){
                throw new IllegalArgumentException();
            }
            else{
                s.setOcupado(true);
                Thread tc = new Thread(c);
                tc.start();
                Thread ts = new Thread(s);
                ts.start();

                Parent tableroParent = FXMLLoader.load(getClass().getResource("Tablero.fxml"));
                Scene tableroScene = new Scene(tableroParent);

                Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
                window.setScene(tableroScene);
                window.show();
                ControllerTablero.setJugable(true);
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
