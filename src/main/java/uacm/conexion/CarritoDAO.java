package uacm.conexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class CarritoDAO {
    
    public void agregarAlCarrito(int libroId) {
        String sql = "INSERT INTO Carrito (libro_id) VALUES (?)";

        try (Connection con = Conection.getConnection();
            PreparedStatement stmt = con.prepareStatement(sql)) {
            
            stmt.setInt(1, libroId);
            stmt.executeQuery();

            System.out.println("Libro agregado al carrito");
        } catch (SQLException e) {
            Alert alert = new Alert(AlertType.ERROR, "Libro no agregado: "+e.getMessage());
            alert.show();
            System.out.println(e.getMessage());
        }
    }

}
