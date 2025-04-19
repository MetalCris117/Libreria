package uacm.modelo;

public class Libro {
    private String titulo;
    private String autor;
    private int anioPublicacion;
    private String genero;
    private byte[] portada;

    public Libro(String titulo, String autor, int anioP, String genero, byte[] portada) {
        this.titulo = titulo;
        this.autor = autor;
        this.anioPublicacion = anioP;
        this.genero = genero;
        this.portada = portada;
    }

    public String getTitulo() {
        return titulo;
    }

    public int getAnioPublicacion() {
        return anioPublicacion;
    }

    public String getGenero() {
        return genero;
    }

    public String getAutor() {
        return autor;
    }

    public byte[] getPortada() {
        return portada;
    }

}
