/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package uacm.libros;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

//import javax.swing.Action;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author crisu
 */
public class Vista_principalController implements Initializable {
    @FXML
    private SplitMenuButton carrito;

    @FXML
    private ScrollPane vistaScroll;

    @FXML
    private AnchorPane rootPane;

    @FXML
    private Button histo;

    @FXML
    private Button fav;

    @FXML
    private Button regis;

    @FXML
    private Button btt_iniSecion;

    @FXML
    private Button button_Buscar;

    @FXML
    private Label lb_inicio;

    @FXML
    private Label lb_titulo;

    @FXML
    private MenuButton menu_Categ;

    @FXML
    private TextField text_Busqueda;

    private String usuarioActual = null;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        button_Buscar.setOnAction(event -> Buscar());
    }

    @FXML
    private void abrirInicioSecion(ActionEvent event) throws IOException {
        if (usuarioActual == null) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/vista_inicioSecion.fxml"));
            Parent root = loader.load();

            // Aquí recuperas el controlador del login
            Vista_inicioSecionController loginController = loader.getController();
            loginController.setPrincipalController(this); // ← le pasas el controlador principal

            Stage stage = new Stage();
            Scene scene = new Scene(root);

            String css = getClass().getResource("/styles/vista_iniciosecion.css").toExternalForm();
            scene.getStylesheets().add(css);

            stage.setScene(scene);
            stage.setTitle("Inicio de Sesión");
            stage.show();
        } else {
            // Cierra sesión
            usuarioActual = null;
            lb_inicio.setText("Inicio");
            btt_iniSecion.setText("Iniciar Sesión");
        }
    }

    @FXML
    private void abrirRegistro(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/vista_registro.fxml"));
        Parent root = loader.load();

        Stage stage = new Stage();
        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.setTitle("Registro");
        stage.show();
    }

    private void Buscar() {
        String text = text_Busqueda.getText();
        System.out.println("Busqueda realizada: "+text);//Aquí se agrega la busqueda
    }

    public void setUsuario(String nombre) {
        usuarioActual = nombre;
        lb_inicio.setText(nombre);
        btt_iniSecion.setText("Cerrar Sesión");
    }
    

}
