package main.java.abstractfactory;

public interface MetodoEnvio {
    String tipo(); //tipo de envio Norma/Express
    int diasEstimados(int distanciakm); // ETA estimado
    double costo(double pesokg, int distanciakm); //costo simple
}
