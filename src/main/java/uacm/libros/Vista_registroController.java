package uacm.libros;

import java.io.IOException;
import java.sql.SQLException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.control.ToggleGroup;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import uacm.conexion.UsuarioDAO;

public class Vista_registroController {

    @FXML
    private RadioButton M;

    @FXML
    private RadioButton H;

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

    private char opcionSeleccionada = '\0';

     /**
     * Initializes the controller class.
     */
    public void initialize() {
        //Para que solo pueda seleccionar un radio button
        ToggleGroup group = new ToggleGroup();
        H.setToggleGroup(group);
        M.setToggleGroup(group);

        H.setOnAction(e -> {
            if (H.isSelected()) {
                opcionSeleccionada = 'H';
                System.out.println("Seleccionado: " + opcionSeleccionada);
            }
        });
    
        M.setOnAction(e -> {
            if (M.isSelected()) {
                opcionSeleccionada = 'M';
                System.out.println("Seleccionado: " + opcionSeleccionada);
            }
        });

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
    //Esta funcion me limpia lo que tiene el textField y el PasswordField
    private void limpiaDatos () {
        nombre.clear();
        contra.clear();
        confirm.clear();
        usuario.clear();
    }
    //Este es mi evento
    @FXML
    private void Registrar () throws SQLException {
        String name = nombre.getText().trim();
        String apellido = apellidos.getText().trim();
        char sex = opcionSeleccionada;
        String email = usuario.getText().trim();
        String password = contra.getText().trim();
        String confirmPassword = confirm.getText().trim();
        UsuarioDAO userDAO = new UsuarioDAO ();

        // Valida campos vacíos
        if (name.isEmpty() || apellido.isEmpty() || email.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
            Alert alert = new Alert(AlertType.ERROR, "Debes llenar todos los campos");
            alert.show();
            return;
        }
        // Valida selección de sexo
        if (sex == '\0') {
            Alert alert = new Alert(AlertType.ERROR, "Debes seleccionar el sexo");
            alert.show();
            return;
        }
        // Valida las contraseñas
        if (!password.equals(confirmPassword)) {
            Alert alert = new Alert(AlertType.ERROR, "Las contraseñas no coinciden");
            alert.show();
            return;
        }
        //Valida el correo
        if (userDAO.existsCorreo(email)) {
            Alert alert = new Alert(AlertType.ERROR, "El correo ya existe");
            alert.show();
            return;
        }
        // Validar formato de correo
        if (!userDAO.validCorreo(email)) {
            Alert alert = new Alert(AlertType.ERROR, "Ingresa un correo válido");
            alert.show();
            return;
        }
        //Lo registro
        try {
            if (userDAO.userRegistro(name, apellido, sex, email, confirmPassword)) {
                Alert alert = new Alert(AlertType.CONFIRMATION, "Usuario registrado");
                alert.show();
                limpiaDatos();
            } else {
                Alert alert = new Alert(AlertType.ERROR, "No se pudo registrar el usuario");
                alert.show();
            }
        } catch (SQLException e) {
            Alert alert = new Alert(AlertType.ERROR, "Error en la base de datos"+e.getMessage());
            alert.show();
        }

    }

}
