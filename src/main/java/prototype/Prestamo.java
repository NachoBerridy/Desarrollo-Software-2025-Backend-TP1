package main.java.prototype;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Prestamo implements Cloneable {

    private String usuario;
    private String libro;
    private String fechaInicio;
    private String fechaFin;

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
