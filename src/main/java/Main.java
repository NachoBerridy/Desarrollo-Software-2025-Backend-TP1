package main.java;

import main.java.abstractfactory.*;
import main.java.builder.Usuario;
import main.java.factory.Libro;
import main.java.factory.LogisticaLibro;
import main.java.prototype.Prestamo;
import main.java.singleton.Database;


//Main Tester
// */
// * Se prueban los patrones de diseño:
// * - Singleton
// * - Factory Method
// * - Abstract Factory
// * - Builder
// * - Prototype

public class Main {

    private static AbstractFactory seleccionarFactory(String tipoUsuario) {
        if ("admin".equalsIgnoreCase(tipoUsuario)) {
            return new AdminFactory();
        } else if ("usuario".equalsIgnoreCase(tipoUsuario)) {
            return new UsuarioFactory();
        }
        throw new IllegalArgumentException("No se puede seleccionar un tipo de usuario." + tipoUsuario);
    }

    public static void main(String[] args) {

        // ========================= SINGLETON START =========================
        System.out.println("\n--- PROBANDO SINGLETON ---");

        Database db = Database.getInstance();
        Database db2 = Database.getInstance();
        System.out.println("es la misma instancia? " + ((db == db2) ? "SI" : "NO")); // true

        System.out.println("--- SINGLETON TERMINADO ---\n");
        // ========================= SINGLETON END =========================

        // ========================= FACTORY START =========================
        System.out.println("\n--- PROBANDO FACTORY ---");

        Libro libroFisico = LogisticaLibro.crearLibro("fisico", "El Quijote", "Cervantes");
        Libro libroDigital = LogisticaLibro.crearLibro("digital", "1984", "George Orwell");

        System.out.println("Libro físico: " + libroFisico.getTitulo() + " - " + libroFisico.getAutor());
        System.out.println("Libro digital: " + libroDigital.getTitulo() + " - " + libroDigital.getAutor());

        System.out.println("--- FACTORY TERMINADO ---\n");
        // ========================= FACTORY END =========================

        // ========================= ABSTRACT FACTORY START =========================
        System.out.println("\n--- PROBANDO ABSTRACT FACTORY ---");

        String tipoUsuario = "admin"; // creamo una variable para eligir el tipo de usuario
        AbstractFactory factory = seleccionarFactory(tipoUsuario); // 1) Selecciono la fabrica según el rol
        InterfazUI ui = factory.crearUI();// 2) Creo los productos de la familia con la mimsa fabrica
        MetodoEnvio envio = factory.crearEnvio();

        ui.render(); // 3) Los uso: muestro la UI y calculo logistica
        System.out.println("UI seleccionada: " + ui.tipo());

        double peso = 1.8; // kg
        int distancia = 950; // km

        System.out.println("Metodo de envio: " + envio.tipo());
        System.out.println("Días estimados:  " + envio.diasEstimados(distancia));
        System.out.println("Costo estimado: $" + envio.costo(peso, distancia));

        System.out.println("--- ABSTRACT FACTORY TERMINADO ---\n");
        // ========================= ABSTRACT FACTORY END =========================

        // ========================= BUILDER START =========================
        System.out.println("\n--- PROBANDO BUILDER ---");

        /*
        // CON LOMBOK

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
          */



        // SIN LOMBOK

        Usuario usuario1 =  new Usuario.Builder().
                nombre("Miguel Borja")
                .email("costillares@gmail.com")
                .direccion("Area chica del Monumental 123")
                .telefono("23412341")
                .fechaNacimiento("26/01/1993")
                .build();

        Usuario usuario2 = new Usuario.Builder()
                .nombre("Edinson Cavani")
                .email("cavani@boca.com")
                .direccion("Sección 'casi gol' de la Bombonera 321")
                .fechaNacimiento("14/02/1987")
                .build();



        System.out.println("Ejemplo usuario 1: " + usuario1);
        System.out.println("Ejemplo usuario 2: " + usuario2);

        System.out.println("--- BUILDER TERMINADO ---\n");
        // ========================= BUILDER END =========================

        // ========================= PROTOTYPE START =========================
        System.out.println("\n--- PROBANDO PROTOTYPE ---");
        try {

            // Original object
            System.out.println("Creando un préstamo original...");
            Prestamo prestamoOriginal = new Prestamo("Carlos Tevez", "El Principito", "01/10/2023", "15/10/2023");

            // Shallow copy
            System.out.println("Creando una copia (shallow) del préstamo original...");
            Prestamo prestamoCopiaShallow = prestamoOriginal.clone();

            // Deep copy
            System.out.println("Creando una copia (deep) del préstamo original...");
            Prestamo prestamoCopiaDeep = prestamoOriginal.clone(true);

            System.out.println("\n Todos los préstamos fueron copiados con el mismo usuario:");
            System.out.println(
                    "Préstamo original: " + prestamoOriginal.getUsuario() + " - " + prestamoOriginal.getLibro());
            System.out.println("Préstamo shallow copy: " + prestamoCopiaShallow.getUsuario() + " - "
                    + prestamoCopiaShallow.getLibro());
            System.out.println(
                    "Préstamo deep copy: " + prestamoCopiaDeep.getUsuario() + " - " + prestamoCopiaDeep.getLibro());

            prestamoCopiaShallow.setUsuario("Leonel Messi"); // Change user in shallow copy
            prestamoCopiaDeep.setUsuario("Sergio Agüero"); // Change user in deep copy

            System.out.println("\n Todos los préstamos ahora pertenecen a usuarios distintos:");
            System.out.println(
                    "Préstamo original: " + prestamoOriginal.getUsuario() + " - " + prestamoOriginal.getLibro());
            System.out.println("Préstamo shallow copy: " + prestamoCopiaShallow.getUsuario() + " - "
                    + prestamoCopiaShallow.getLibro());
            System.out.println(
                    "Préstamo deep copy: " + prestamoCopiaDeep.getUsuario() + " - " + prestamoCopiaDeep.getLibro());

            System.out.println("\nEs el prestamo original igual a su shallow copy? "
                    + (prestamoOriginal == prestamoCopiaShallow ? "SI" : "NO"));
            System.out.println("Es el prestamo original igual a su deep copy? "
                    + (prestamoOriginal == prestamoCopiaDeep ? "SI" : "NO"));
            System.out.println("Es la shallow copy igual a la deep copy? "
                    + (prestamoCopiaShallow == prestamoCopiaDeep ? "SI" : "NO"));

        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        System.out.println("\n--- PROTOTYPE TERMINADO ---\n");
        // ========================= PROTOTYPE END =========================

    }
}

/*

public class Main {
    public static void main(String[] args) {
        try{
        // Parte 1 – Singleton
        System.out.println("=== Singleton ===");
        Database db1 = Database.getInstance();

        // Parte 2 – Factory Method
        System.out.println("\n=== Factory Method ===");
        Libro libroFisico = LogisticaLibro.crearLibro("fisico", "El Quijote", "Cervantes");
        Libro libroDigital = LogisticaLibro.crearLibro("digital", "1984", "Orwell");
        db1.addLibro(libroFisico);
        db1.addLibro(libroDigital);
        for (Libro l : db1.getLibros()) {
            System.out.println("Libro: " + l.getTitulo() + " | Tipo: " + l.getClass().getSimpleName());
        }

        // Parte 3 – Abstract Factory
        System.out.println("\n=== Abstract Factory ===");
        AbstractFactory adminFactory = new AdminFactory();
        InterfazUI adminUI = adminFactory.crearUI();
        MetodoEnvio envioExpress = adminFactory.crearEnvio();
        adminUI.render();
        System.out.println("Método de envío: " + envioExpress.tipo());

        AbstractFactory usuarioFactory = new UsuarioFactory();
        InterfazUI usuarioUI = usuarioFactory.crearUI();
        MetodoEnvio envioNormal = usuarioFactory.crearEnvio();
        usuarioUI.render();
        System.out.println("Método de envío: " + envioNormal.tipo());

        // Parte 4 – Builder
        System.out.println("\n=== Builder ===");
        Usuario usuario1 = Usuario.builder().nombre("Ana").email("ana@mail.com").telefono("123456").build();
        Usuario usuario2 = Usuario.builder().nombre("Luis").direccion("Calle Falsa 123").fechaNacimiento("01/01/2000").build();
        System.out.println(usuario1);
        System.out.println(usuario2);

        // Parte 5 – Prototype
        System.out.println("\n=== Prototype ===");
        Prestamo prestamoOriginal = new Prestamo(usuario1.getNombre(), libroFisico.getTitulo(), "10/06/2024", "20/06/2024");
        Prestamo prestamoClon1 = prestamoOriginal.clone();
        prestamoClon1.setFechaFin("25/06/2024");
        Prestamo prestamoClon2 = prestamoOriginal.clone(true);
        prestamoClon2.setUsuario(usuario2.getNombre());
        System.out.println("Original: " + prestamoOriginal.getUsuario() + " | " + prestamoOriginal.getLibro() + " | " + prestamoOriginal.getFechaFin());
        System.out.println("Clon 1: " + prestamoClon1.getUsuario() + " | " + prestamoClon1.getLibro() + " | " + prestamoClon1.getFechaFin());
        System.out.println("Clon 2: " + prestamoClon2.getUsuario() + " | " + prestamoClon2.getLibro() + " | " + prestamoClon2.getFechaFin());
    }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}

*/