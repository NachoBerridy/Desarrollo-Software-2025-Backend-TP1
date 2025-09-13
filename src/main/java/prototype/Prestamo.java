package main.java.prototype;

public class Prestamo implements Cloneable {

    private String usuario;
    private String libro;
    private String fechaInicio;
    private String fechaFin;

    // Constructor
    public Prestamo(String usuario, String libro, String fechaInicio, String fechaFin) {
        this.usuario = usuario;
        this.libro = libro;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    // Getters
    public String getUsuario() {
        return usuario;
    }

    public String getLibro() {
        return libro;
    }

    // Setters
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setLibro(String libro) {
        this.libro = libro;
    }

    @Override
    // shallow copy method
    public Prestamo clone() throws CloneNotSupportedException {
        try {
            // Shallow clone
            return (Prestamo) super.clone();

        } catch (

        CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    // Deep copy method
    public Prestamo clone(Boolean deep) throws CloneNotSupportedException {
        try {
            if (!deep) {

                return this.clone(); // Call the original clone method (shallow)
            }
            // Deep copy
            return new Prestamo(this.usuario, this.libro, this.fechaInicio, this.fechaFin);

        } catch (

        CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
}
