package main.java.factory;

import lombok.AllArgsConstructor;
import lombok.Getter;

/*
// Con LOMBOK
@Getter
@AllArgsConstructor
public class LibroFisico implements Libro {
    private String titulo;
    private String autor;
}

*/

// Sin LOMBOK
public class LibroFisico implements Libro {
    private String titulo;
    private String autor;

    public LibroFisico(String titulo, String autor) {
        this.titulo = titulo;
        this.autor = autor;
    }
    public String getTitulo() {
        return titulo;
    }
    public String getAutor() {
        return autor;
    }

}