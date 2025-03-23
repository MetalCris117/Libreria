/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package uacm.libros;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.SubScene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuButton;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author crisu
 */
public class Vista_principalController implements Initializable {

    @FXML
    private Label lb_inicio;
    @FXML
    private Label lb_titulo;
    @FXML
    private Button btt_iniSecion;
    @FXML
    private MenuBar men_Bar;
    @FXML
    private MenuButton menu_Categ;
    @FXML
    private TextField text_Busqueda;
    @FXML
    private Button button_Buscar;
    @FXML
    private SubScene vista_libros;
    @FXML
    private ScrollBar scroll;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        button_Buscar.setOnAction(event -> Buscar());
    }

    private void Buscar() {
        String text = text_Busqueda.getText();
        System.out.println("Busqueda realizada: "+text);//Aquí se agrega la busqueda
    }
    
}
