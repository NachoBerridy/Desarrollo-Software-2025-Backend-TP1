package main.java.factory;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class LibroDigital implements Libro {
    private String titulo;
    private String autor;
}