package uacm.conexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioDAO {
    //Esta funcion me valida el correo
    public boolean validCorreo (String email) {
        String corr = "^[a-zA-Z0-9_+&-]+(?:\\.[a-zA-Z0-9_+&-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        return email.matches(corr);
    }
    //Aquí registro el usuario
    public boolean userRegistro (String name, String apellidos, char sexo, String email, String password) throws SQLException {
        String sql = "INSERT INTO Usuarios (Nombre, Apellidos, Sexo, Correo, Contraseña) VALUES (?, ?, ?, ?, ?)";

        try (Connection con = Conection.getConnection(); PreparedStatement statement = con.prepareStatement(sql)) {
            statement.setString(1, name);
            statement.setString(2, apellidos);
            statement.setString(3, String.valueOf(sexo));
            statement.setString(4, email);
            statement.setString(5, password);

            int rowsAffected = statement.executeUpdate();
            return rowsAffected > 0;
        }
    }

    public boolean existsCorreo(String email) throws SQLException {
        try (Connection con = Conection.getConnection()) {
            String sql = "SELECT TOP 1 1 FROM Usuarios WHERE Correo = ?"; // Optimizado, no necesitas traer todo
    
            try (PreparedStatement statement = con.prepareStatement(sql)) {
                statement.setString(1, email);
    
                try (ResultSet res = statement.executeQuery()) {
                    return res.next(); // Devuelve true si encontró un resultado
                    //res.next() ya te dice si hay algún resultado.
                }
            }
        }
    }    

}
