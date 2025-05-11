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
    //private static Libro libroActual;

    public LibroDAO() throws SQLException {
        con = Conection.getConnection();
        System.out.println(con.isValid(1000)?"conexion exitosa": "Fallo la conexion");
    }

    public List<Libro> obtenerTodosLosLibros() {
        List<Libro> libros = new ArrayList<>();

        String sql = "SELECT Id, Titulo, Autor, AnioPublicacion, Editorial, Genero, Presio, Existencias, Portada FROM Libreria";

        try (Connection conn = Conection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                int Id = rs.getInt("Id");
                String titulo = rs.getString("Titulo");
                String autor = rs.getString("Autor");
                int anioP = rs.getInt("AnioPublicacion");
                String edit = rs.getString("Editorial");
                String genero = rs.getString("Genero");
                float presio = rs.getFloat("Presio");
                int exis = rs.getInt("Existencias");
                byte[] portada = rs.getBytes("Portada");

                libros.add(new Libro(Id, titulo, autor, anioP, edit, genero, presio, exis, portada));
            }

        } catch (SQLException e) {
            Logger.getLogger(LibroDAO.class.getName()).log(Level.SEVERE, "Erro al obtener los libros", e);
        }

        return libros;
    }

    /*public static Libro getLibro() {
        return libroActual;
    }*/

}
