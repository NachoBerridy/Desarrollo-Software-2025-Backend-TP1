package main.java.factory;

public class LibroFisico extends Libro{

    public LibroFisico(String titulo, String autor) {
      super(titulo, autor);
    }

    @Override
    public String getTitulo() {
        return titulo;
    }

    @Override
    public String getAutor() {
        return autor;
    }
}
