package uacm.modelo;

public class Libro {
    private int id_libro;
    private String titulo;
    private String autor;
    private int anioPublicacion;
    private String editorial;
    private String genero;
    private float presio;
    private int existecias;
    private byte[] portada;

    public Libro(int id, String titulo, String autor, int anioP, String editorial, String genero, float presio, int exist, byte[] portada) {
        this.id_libro = id;
        this.titulo = titulo;
        this.autor = autor;
        this.anioPublicacion = anioP;
        this.editorial = editorial;
        this.genero = genero;
        this.presio = presio;
        this.existecias = exist;
        this.portada = portada;
    }

    public int getId_Libro() {
        return id_libro;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public int getAnioPublicacion() {
        return anioPublicacion;
    }

    public String getEditorial() {
        return editorial;
    }

    public String getGenero() {
        return genero;
    }

    public float getPresio() {
        return presio;
    }

    public int getExistencias() {
        return existecias;
    }

    public byte[] getPortada() {
        return portada;
    }

}
