package uacm.libros;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void init() {// Este metodo es para cargar una configuracion inicial
        // Este metodo se inicia antes que los demas
    }

    @Override
    public void start(@SuppressWarnings("exports") Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/vista_principal.fxml"));

        Scene scene = new Scene(root);// Creamos una ecena

        stage.setScene(scene);// Agregamos la ecena al ecenario
        stage.show();// Mostramos el ecenario
    }

    @Override
    public void stop() {// Este metodo se va a ejecutar al finalizar el programa
        // Lo usamos si queremos finalizar algun proceso
    }

    public static void main(String[] args) {
        launch();
    }

}