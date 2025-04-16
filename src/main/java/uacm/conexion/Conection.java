package uacm.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conection {

    public static Connection getConnection () {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            String url = "jdbc:sqlserver://localhost:1433;databaseName=Libros;encrypt=true;trustServerCertificate=true";
            String user = "userSQL";
            String password = "root";

            Connection con = DriverManager.getConnection(url, user, password);
            return con;

        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException("Error al conectar con la base de datos", e);
        }
    }

    public static void cerrarConexion(Connection con) {
        if (con != null) {
            try {
                con.close();
                System.out.println("Conexión cerrada exitosamente.");
            } catch (SQLException e) {
                System.err.println("Error al cerrar la conexión: " + e.getMessage());
            }
        }
    }
}

