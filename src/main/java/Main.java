package main.java;

import main.java.singleton.Database;

public class Main {
    public static void main(String[] args) {

        // probar singleton
         Database db = Database.getInstance();
         Database db2 = Database.getInstance();

         System.out.println("es la misma instancia? " + ((db == db2) ? "SI" : "NO" )); // true
    }
}