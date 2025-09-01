package main.java.factory;

public class LibroDigital extends Libro {

    public LibroDigital(String titulo, String autor) {
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
