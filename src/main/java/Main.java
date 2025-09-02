package main.java;

import main.java.abstractfactory.*;
import main.java.singleton.Database;

public class Main {


    public static void main(String[] args) {

        // probar singleton
         Database db = Database.getInstance();
         Database db2 = Database.getInstance();

         System.out.println("es la misma instancia? " + ((db == db2) ? "SI" : "NO" )); // true

        //creamo una variable para eligir el tipo de usuario
        String tipoUsuario = "admin";

        //1) Selecciono la fabrica según el rol
        AbstractFactory factory = seleccionarFactory(tipoUsuario);

        //2) Creo los productos de la familia con la mimsa fabrica
        InterfazUI ui = factory.crearUI();
        MetodoEnvio envio = factory.crearEnvio();

        //3) Los uso: muestro la UI y calculo logistica
        ui.render();
        System.out.println("UI seleccionada: " + ui.tipo());

        double peso = 1.8; //kg
        int distancia = 950; //km

        System.out.println("Metodo de envio: " + envio.tipo());
        System.out.println("Días estimados:  " + envio.diasEstimados(distancia));
        System.out.println("Costo estimado: $" + envio.costo(peso, distancia));

    }

    private static AbstractFactory seleccionarFactory(String tipoUsuario){
        if("admin".equalsIgnoreCase(tipoUsuario)){
            return new AdminFactory();
        }
        if("usuario".equalsIgnoreCase(tipoUsuario)){
            return new UsuarioFactory();
        }
        throw new IllegalArgumentException("No se puede seleccionar un tipo de usuario." +tipoUsuario);
    }
}