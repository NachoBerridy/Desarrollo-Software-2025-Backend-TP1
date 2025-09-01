package main.java.singleton;

import main.java.factory.Libro;

import java.util.ArrayList;
import java.util.List;


// Singleton sin sincronización ni volatilidad
// No es seguro en entornos multihilo
// Pero es más sencillo y rápido en entornos de un solo hilo

/*
public class Database {
    private static Database instance;
    private Database() { }
    private final List<Libro> libros = new ArrayList<>();

    public static Database getInstance() {
        if (instance == null) {
            instance = new Database();
        }
        return instance;
    }
    public void addLibro(Libro libro) {
        libros.add(libro);
    }
    public List<Libro> getLibros() {
        return libros;
    }
}
*/


/*
// Singleton con sincronización, problemas con performance porque sincroniza siempre que se llama a getInstance

public class Database {
    private static Database instance;
    private Database() {}
    private final List<Libro> libros = new ArrayList<>();

    public static synchronized Database getInstance() { //sincroniza siempre
        if (instance == null) {
            instance = new Database();
        }
        return instance;
    }

    public void addLibro(Libro libro) {
        libros.add(libro);
    }

    public List<Libro> getLibros() {
        return libros;
    }
}
*/





// singleton con doble verificación y volatilidad, es más complejo pero mejora el rendimiento en entornos multihilo
public class Database {
    private static volatile Database instance;

    private Database() {
    }

    private final List<Libro> libros = new ArrayList<>();

    public static Database getInstance() {
        if (instance == null) {
            synchronized (Database.class) { //sincroniza solo la primera vez
                if (instance == null) {
                    instance = new Database();
                }
            }
        }
        return instance;
    }

    public void addLibro(Libro libro) {
        libros.add(libro);
    }

    public List<Libro> getLibros() {
        return libros;
    }
}




/*
// Singleton con holder, es el más sencillo y eficiente, aprovecha la inicialización de clases en Java
public class Database {
    private Database() {}
    private final List<Libro> libros = new ArrayList<>();

    private static class Holder {
        private static final Database INSTANCE = new Database();
    }

    public static Database getInstance() {
        return Holder.INSTANCE;
    }

    public void addLibro(Libro libro) {
        libros.add(libro);
    }

    public List<Libro> getLibros() {
        return libros;
    }
}
*/