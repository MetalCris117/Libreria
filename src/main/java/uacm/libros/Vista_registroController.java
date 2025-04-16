package uacm.libros;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Vista_registroController {

    @FXML
    private TextField aux2Contra;

    @FXML
    private TextField auxContra;

    @FXML
    private TextField apellidos;

    @FXML
    private Button conCuenta;

    @FXML
    private PasswordField confirm;

    @FXML
    private PasswordField contra;

    @FXML
    private Text indicacion;

    @FXML
    private CheckBox mostrarCon;

    @FXML
    private TextField nombre;

    @FXML
    private Button siguiente;

    @FXML
    private Text subtitulo;

    @FXML
    private Label titulo;

    @FXML
    private TextField usuario;

     /**
     * Initializes the controller class.
     */
    public void initialize() {

        usuario.setTextFormatter(new TextFormatter<>(change -> {
            if (change.getText().contains(" ")) {
                return null; // Rechaza el cambio si hay espacios
            }
            return change; // Acepta el cambio si no hay espacios
        }));
        
        contra.setTextFormatter(new TextFormatter<>(change -> {
            if (change.getText().contains(" ")) {
                return null; // Rechaza el cambio si hay espacios
            }
            return change; // Acepta el cambio si no hay espacios
        }));

        confirm.setTextFormatter(new TextFormatter<>(change -> {
            if (change.getText().contains(" ")) {
                return null; // Rechaza el cambio si hay espacios
            }
            return change; // Acepta el cambio si no hay espacios
        }));

        auxContra.textProperty().addListener((obs, oldText, newText) -> {
            if (mostrarCon.isSelected()) {
                contra.setText(newText);
            }
        });
    
        contra.textProperty().addListener((obs, oldText, newText) -> {
            if (!mostrarCon.isSelected()) {
                auxContra.setText(newText);
            }
        });

        aux2Contra.textProperty().addListener((obs, oldText, newText) -> {
            if (mostrarCon.isSelected()) {
                confirm.setText(newText);
            }
        });
    
        confirm.textProperty().addListener((obs, oldText, newText) -> {
            if (!mostrarCon.isSelected()) {
                aux2Contra.setText(newText);
            }
        });
        
    }

    @FXML
    private void verContra() {
        if (mostrarCon.isSelected()) {
            auxContra.setText(contra.getText());
            auxContra.setVisible(true);
            auxContra.setManaged(true);
            contra.setVisible(false);
            contra.setManaged(false);

            aux2Contra.setText(confirm.getText());
            aux2Contra.setVisible(true);
            aux2Contra.setManaged(true);
            confirm.setVisible(false);
            confirm.setManaged(false);
        } else {
            contra.setText(auxContra.getText());
            contra.setVisible(true);
            contra.setManaged(true);
            auxContra.setVisible(false);
            auxContra.setManaged(false);

            confirm.setText(aux2Contra.getText());
            confirm.setVisible(true);
            confirm.setManaged(true);
            aux2Contra.setVisible(false);
            aux2Contra.setManaged(false);
        }
    }

    @FXML
    private void abrirInicioSecion(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/vista_inicioSecion.fxml"));
        Parent root = loader.load();

        Stage stage = new Stage();
        Scene scene = new Scene(root);

        String css = getClass().getResource("/styles/vista_iniciosecion.css").toExternalForm();
        scene.getStylesheets().add(css);

        stage.setScene(scene);
        stage.setTitle("Inicio de Sesion");
        stage.show();
        //Cerrar la ventana actual al obtener el botón desde el evento
        Stage ventanaActual = (Stage) ((Button) event.getSource()).getScene().getWindow();
        ventanaActual.close();
    }

}
