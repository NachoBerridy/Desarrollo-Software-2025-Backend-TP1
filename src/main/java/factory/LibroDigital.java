package main.java.factory;

import lombok.AllArgsConstructor;
import lombok.Getter;


/*
// Con LOMBOK
@Getter
@AllArgsConstructor
public class LibroDigital implements Libro {
    private String titulo;
    private String autor;
}
*/

// Sin LOMBOK
public class LibroDigital implements Libro {
    private String titulo;
    private String autor;

    public LibroDigital(String titulo, String autor) {
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
