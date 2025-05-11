package uacm.conexion;

import uacm.modelo.Usuario;

public class Session {
    private static Usuario usuarioActual;

    private Session() {
        // Constructor privado para evitar instanciación
    }

    public static void iniciarSesion(Usuario usuario) {
        usuarioActual = usuario;
    }

    public static Usuario getUsuarioActual() {
        return usuarioActual;
    }

    public static void cerrarSesion() {
        usuarioActual = null;
    }

    public static boolean isSesionIniciada() {
        return usuarioActual != null;
    }
}
