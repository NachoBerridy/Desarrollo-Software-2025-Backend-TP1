package main.java.factory;

public class LogisticaLibro {
    public static Libro crearLibro(String tipo, String titulo, String autor) {
        if ("fisico".equalsIgnoreCase(tipo)) {
            return new LibroFisico(titulo, autor);
        } else if ("digital".equalsIgnoreCase(tipo)) {
            return new LibroDigital(titulo, autor);
        }
        throw new IllegalArgumentException("Tipo de libro no soportado: " + tipo);
    }
}