package uacm.conexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import uacm.modelo.Libro;

public class LibroDAO {
    private Connection con;

    public LibroDAO() throws SQLException {
        con = Conection.getConnection();
        System.out.println(con.isValid(1000)?"conexion exitosa": "Fallo la conexion");
    }

    public List<Libro> obtenerTodosLosLibros() {
        List<Libro> libros = new ArrayList<>();

        String sql = "SELECT Titulo, Autor, AnioPublicacion, Genero, Portada FROM Libreria";

        try (Connection conn = Conection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                String titulo = rs.getString("Titulo");
                String autor = rs.getString("Autor");
                int anioP = rs.getInt("AnioPublicacion");
                String genero = rs.getString("Genero");
                byte[] portada = rs.getBytes("Portada");

                libros.add(new Libro(titulo, autor, anioP, genero, portada));
            }

        } catch (SQLException e) {
            Logger.getLogger(LibroDAO.class.getName()).log(Level.SEVERE, "Erro al obtener los libros", e);
        }

        return libros;
    }

}
