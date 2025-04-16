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

        //String css = getClass().getResource("/styles/vista_pago.css").toExternalForm();
        //scene.getStylesheets().add(css); //Esto es para que me encuentre el css

        stage.setScene(scene);// Agregamos la ecena al ecenario
        stage.setTitle("Pagina Principal");
        stage.show();// Mostramos el ecenario

        /*
         * <stylesheets>
            <URL value="@styles/vista_pago.css"/>    Esto lo quite del fxml porque no me corria
           </stylesheets>
         */
    }

    @Override
    public void stop() {// Este metodo se va a ejecutar al finalizar el programa
        // Lo usamos si queremos finalizar algun proceso
    }

    public static void main(String[] args) {
        launch();
    }

}