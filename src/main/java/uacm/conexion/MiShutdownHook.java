package uacm.conexion;

public class MiShutdownHook extends Thread {
    @Override
    public void run() {
        System.out.println("Apagando aplicacion... cerrando conexion a la base de datos.");
        Conection.cerrarConexion();
    }
}
