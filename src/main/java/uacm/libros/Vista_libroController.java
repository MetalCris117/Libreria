package uacm.libros;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import uacm.modelo.Libro;

import java.io.ByteArrayInputStream;

public class Vista_libroController {
    @FXML
    private Label lb_anio;

    @FXML
    private Button but_ver;

    @FXML
    private Button but_agrCarrito;

    @FXML
    private ImageView imag;

    @FXML
    private Label lb_titulo;

    @FXML
    private Label lb_autor;

    private Libro libroActual;

    /**
     * Initializes the controller class.
     */
    public void initialize() {
        // Hint: initialize() will be called when the associated FXML has been completely loaded.
    }

    public void setDatos(Libro libro) {
        //Aquí le estoy asegnando a los lbel el titulo, autor, etc
        lb_titulo.setText(libro.getTitulo());
        lb_autor.setText(libro.getAutor());
        lb_anio.setText(String.valueOf(libro.getAnioPublicacion()));

        if (libro.getPortada() != null) {
            Image image = new Image(new ByteArrayInputStream(libro.getPortada()));
            imag.setImage(image);
        }
    }

    @FXML
    private void verDetalles(ActionEvent event) {
        System.out.println("Ver detalles del libro: ");
        // Aquí podrías abrir una nueva ventana con más info
    }
    
    @FXML
    private void agregarAlCarrito(ActionEvent event) {
        System.out.println("Libro agregado al carrito: ");
        // Aquí podrías agregarlo a una lista o base de datos de carrito
    }

}
