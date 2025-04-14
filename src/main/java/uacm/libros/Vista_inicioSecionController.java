/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package uacm.libros;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author crisu
 */
public class Vista_inicioSecionController implements Initializable {
    @FXML
    private Label txt_corr;

    @FXML
    private Label txt_contra;

    @FXML
    private TextField txtF2;

    @FXML
    private Label text_titulo;

    @FXML
    private Label txt_subtitulo;

    @FXML
    private ImageView img;

    @FXML
    private Label txt_ask;

    @FXML
    private TextField txtF;

    @FXML
    private Button boton;

    @FXML
    private Button bt_atras;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @FXML
    private void cerrar(ActionEvent event) {
        Stage stage = (Stage) ((Node) (event.getSource())).getScene().getWindow();
        stage.close();
    }

}
