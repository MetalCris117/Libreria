package uacm.conexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import uacm.modelo.Libro;
import uacm.modelo.Usuario;

public class CarritoDAO {
    
    public void agregarAlCarrito(Libro libro) {
        Usuario usuarioActual = Session.getUsuarioActual();

        if (usuarioActual == null) {
            Alert alert = new Alert(AlertType.WARNING, "Debes iniciar sesión para agregar al carrito");
            alert.show();
            return;
        }

        String sql = "INSERT INTO Carrito (libro_id, usuario_id) VALUES (?, ?)";

        try (Connection con = Conection.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            int usuarioId = usuarioActual.getId();
            System.out.println("Insertando en Carrito: libro_id = " + libro.getId_Libro() + ", usuario_id = " + usuarioId);

            stmt.setInt(1, libro.getId_Libro());
            stmt.setInt(2, usuarioActual.getId());
            
            stmt.executeUpdate(); // Debe ser executeUpdate() para consultas INSERT, UPDATE o DELETE

            Alert alert = new Alert(AlertType.CONFIRMATION, "Libro agregado: ");
            alert.show();
        } catch (SQLException e) {
            Alert alert = new Alert(AlertType.ERROR, "Libro no agregado: " + e.getMessage());
            alert.show();
            System.out.println(e.getMessage());
        }

    }

}
