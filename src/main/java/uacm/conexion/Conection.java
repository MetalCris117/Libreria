package uacm.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conection {
    public static Connection con = null;

    public static Connection getConnection () {
        if(con == null) {
            try {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

                String url = "jdbc:sqlserver://localhost:1433;databaseName=BaseDatos;encrypt=true;trustServerCertificate=true";
                String user = "userSQL";
                String password = "root";

                con = DriverManager.getConnection(url, user, password);
                // Agregamos el shutdown hook para cerrar conexión al salir
                Runtime.getRuntime().addShutdownHook(new MiShutdownHook());

            } catch (ClassNotFoundException | SQLException e) {
                throw new RuntimeException("❌ Error al conectar con la base de datos", e);
            }
        }
        return con;
    }
    
    public static void cerrarConexion() {
        if (con != null) {
            try {
                con.close();
                System.out.println("Conexion cerrada exitosamente.");
            } catch (SQLException e) {
                System.err.println("⚠️ Error al cerrar la conexion: " + e.getMessage());
            }
        }
    }
}
