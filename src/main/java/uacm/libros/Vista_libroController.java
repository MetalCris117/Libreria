package uacm.libros;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import uacm.conexion.CarritoDAO;
import uacm.conexion.Session;
import uacm.modelo.Libro;
import uacm.modelo.Usuario;

import java.io.ByteArrayInputStream;
import java.io.IOException;

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
        this.libroActual = libro;
        lb_titulo.setText(libro.getTitulo());
        lb_autor.setText(libro.getAutor());
        lb_anio.setText(String.valueOf("Presio: "+libro.getPresio())+"$");

        if (libro.getPortada() != null) {
            Image image = new Image(new ByteArrayInputStream(libro.getPortada()));
            imag.setImage(image);
        }
    }

    @FXML
    private void verDetalles(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/vista_detallesLibro.fxml"));
            Parent detalle = loader.load();

            Vista_detalleLibroController control = loader.getController();
            control.setDatos(libroActual);

            Scene currScene = ((Node) event.getSource()).getScene();//Cambia la escena actual para mostrar el nuevo contenido
            currScene.setRoot(detalle);// esto reemplaza la vista actual en la misma ventana

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    @FXML
    private void agregarAlCarrito(ActionEvent event) {
        Usuario usuarioActual = Session.getUsuarioActual();
    
        if (usuarioActual == null) {
            Alert alert = new Alert(Alert.AlertType.WARNING, "Debes iniciar sesión para agregar al carrito");
            alert.show();
            return;
        }

        if (libroActual == null) {
            Alert alert = new Alert(Alert.AlertType.WARNING, "No se ha seleccionado un libro");
            alert.show();
            return;
        }

        CarritoDAO carrito = new CarritoDAO();
        carrito.agregarAlCarrito(libroActual);
        
    }

}
