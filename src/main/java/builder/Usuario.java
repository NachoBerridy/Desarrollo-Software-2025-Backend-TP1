package main.java.builder;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

//USANDO LOMBOCK
@Builder
@Getter
@ToString
public class Usuario {
    private String nombre, email, direccion, telefono, fechaNacimiento;
}

/*
//SIN LOMBOCK

@ToString
public class Usuario{
    private String nombre, email, direccion, telefono, fechaNacimiento;

    private Usuario(Builder builder){
        this.nombre = builder.nombre;
        this.email = builder.email;
        this.direccion = builder.direccion;
        this.telefono = builder.telefono;
        this.fechaNacimiento = builder.fechaNacimiento;
    }

    public static class Builder{
        private String nombre, email, direccion, telefono, fechaNacimiento;
        public Builder nombre(String nombre){this.nombre = nombre;return this;}
        public Builder email(String nombre){this.email = email;return this;}
        public Builder direccion(String direccion){this.direccion = direccion;return this;}
        public Builder telefono(String telefono){this.telefono = telefono;return this;}
        public Builder fechaNacimiento(String fechaNacimiento){this.fechaNacimiento = fechaNacimiento;return this;}

        public Usuario build(){
            return new Usuario(this);
        }
    }
}
*/