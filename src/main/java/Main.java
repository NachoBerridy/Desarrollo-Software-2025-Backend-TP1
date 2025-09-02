package main.java;

import main.java.builder.Usuario;
import main.java.factory.Libro;
import main.java.factory.LogisticaLibro;
import main.java.singleton.Database;


public class Main {
    public static void main(String[] args) {

        // probar singleton
         Database db = Database.getInstance();
         Database db2 = Database.getInstance();

         System.out.println("es la misma instancia? " + ((db == db2) ? "SI" : "NO" )); // true

        // probar factory
        Libro libroFisico = LogisticaLibro.crearLibro("fisico", "El Quijote", "Cervantes");
        Libro libroDigital = LogisticaLibro.crearLibro("digital", "1984", "George Orwell");

        System.out.println("Libro físico: " + libroFisico.getTitulo() + " - " + libroFisico.getAutor());
        System.out.println("Libro digital: " + libroDigital.getTitulo() + " - " + libroDigital.getAutor());

        //probar builder
        System.out.println("\n--- PROBANDO BUILDER ---");
        Usuario usuario1 = Usuario.builder()
                .nombre("Miguel Borja")
                .email("costillares@gmail.com")
                .direccion("Area chica del Monumental 123")
                .telefono("23412341")
                .fechaNacimiento("26/01/1993")
                .build();

        Usuario usuario2 = Usuario.builder()
                .nombre("Edinson Cavani")
                .email("cavani@boca.com")
                .direccion("Sección 'casi gol' de la Bombonera 321")
                .fechaNacimiento("14/02/1987")
                .build();

        System.out.println("Ejemplo usuario 1: "+usuario1);
        System.out.println("Ejemplo usuario 2: "+usuario2);
    }
}