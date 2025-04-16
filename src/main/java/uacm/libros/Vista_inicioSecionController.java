/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package uacm.libros;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import uacm.conexion.Conection;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

/**
 * FXML Controller class
 *
 * @author crisu
 */
public class Vista_inicioSecionController implements Initializable {

    @FXML
    private Button creaCuenta;

    @FXML
    private Button boton;

    @FXML
    private Button bt_atras;

    @FXML
    private ImageView img;

    @FXML
    private Label text_titulo;

    @FXML
    private TextField txtF;

    @FXML
    private PasswordField txtF2;

    @FXML
    private Label txt_ask;

    @FXML
    private Label txt_contra;

    @FXML
    private Label txt_corr;

    @FXML
    private Label txt_subtitulo;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        txtF.setTextFormatter(new TextFormatter<>(change -> {
            if (change.getText().contains(" ")) {
                return null; // Rechaza el cambio si hay espacios
            }
            return change; // Acepta el cambio si no hay espacios
        }));

        txtF2.setTextFormatter(new TextFormatter<>(change -> {
            if (change.getText().contains(" ")) {
                return null; // Rechaza el cambio si hay espacios
            }
            return change; // Acepta el cambio si no hay espacios
        }));

    }

    @FXML
    private void cerrar (ActionEvent event) {
        Stage stage = (Stage) ((Node) (event.getSource())).getScene().getWindow();
        stage.close();
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
        //Cerrar la ventana actual al obtener el botón desde el evento
        Stage ventanaActual = (Stage) ((Button) event.getSource()).getScene().getWindow();
        ventanaActual.close();
    }

    @FXML
    private void Login () {
        String correo = txtF.getText().trim();
        String password = txtF2.getText().trim();

        if (correo.isEmpty() || password.isEmpty()) {
            Alert alert = new Alert(AlertType.ERROR, "Ingrese usuario y contraseña");
            alert.show();
            return;
        }

        try (Connection con = Conection.getConnection()) {
            String sql = "SELECT * FROM Usuarios WHERE Correo = ? AND Contraseña = ?";

            try (PreparedStatement statement = con.prepareStatement(sql)){
                statement.setString(1, correo);
                statement.setString(2, password);

                try (ResultSet res = statement.executeQuery()) {
                    if (res.next()) {
                        Alert alert = new Alert(AlertType.CONFIRMATION, "Bienvenido");
                        alert.show();
                        //Aquí se puede abrir otra ventana
                    } else {
                        Alert alert = new Alert(AlertType.ERROR, "Usuario o contraseña incorrectos ");
                        alert.show();
                    }

                }

            }

        } catch (SQLException e) {
            System.out.println("No se pudo conectar a la base de datos..."+e.getMessage());
        }

    }

}
