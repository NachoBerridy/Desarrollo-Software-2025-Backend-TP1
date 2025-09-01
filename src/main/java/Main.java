package main.java;

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
    }
}