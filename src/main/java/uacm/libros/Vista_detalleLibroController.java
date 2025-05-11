package uacm.libros;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import uacm.modelo.Libro;

public class Vista_detalleLibroController {
    @FXML
    private Button bt_inicioSesion;

    @FXML
    private Label lb_detalle;

    @FXML
    private Button bt_atras;

    @FXML
    private Label lb_genero;

    @FXML
    private Label lb_titulo;

    @FXML
    private Label lb_publi;

    @FXML
    private Label lb_existencias;

    @FXML
    private Label lb_presio;

    @FXML
    private Button bt_carrito;

    @FXML
    private Button bt_comprar;

    @FXML
    private Spinner sp_unidades;

    @FXML
    private ImageView img;

    @FXML
    private Label lb_autor;

    @FXML
    private Label lb_edito;

    private Libro libro;

    private int cantidadSeleccionada = 0;

    /**
     * Initializes the controller class.
     */
    public void initialize() {
        // Actualiza la cantidad seleccionada cuando el valor del Spinner cambia
        sp_unidades.valueProperty().addListener((obs, oldValue, newValue) -> {
            cantidadSeleccionada = (int) newValue;
            System.out.println("Cantidad seleccionada: " + cantidadSeleccionada);
        });
        // Inicializa el Spinner con un rango de 0 a 100 y valor inicial 0
        SpinnerValueFactory<Integer> valueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 100, 0);
        sp_unidades.setValueFactory(valueFactory);
    }

    public void setDatos(Libro libro) {
        if (libro == null) {
            System.out.println("Libro es null en setDatos");
            return;
        }

        this.libro = libro;

        lb_titulo.setText(libro.getTitulo());
        lb_autor.setText("Autor: "+libro.getAutor());
        lb_edito.setText("Editorial: "+libro.getEditorial());
        lb_genero.setText("Genero: "+libro.getGenero());
        lb_presio.setText("Precio: "+String.valueOf(libro.getPresio())+"$");
        lb_publi.setText("Año de publicaciónZ: "+String.valueOf(libro.getAnioPublicacion()));
        lb_existencias.setText(String.valueOf(libro.getExistencias())+" en existencias");

        if (libro.getPortada() != null) {
            Image image = new Image(new ByteArrayInputStream(libro.getPortada()));
            img.setImage(image);
        }        
    }

    @FXML
    private void atras(ActionEvent event) {
        System.out.println("Atras");
        try {
            Parent principal = FXMLLoader.load(getClass().getResource("/fxml/vista_principal.fxml"));
            Scene scene = ((Node) event.getSource()).getScene();
            scene.setRoot(principal);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}
