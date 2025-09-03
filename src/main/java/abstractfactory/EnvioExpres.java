package main.java.abstractfactory;

public class EnvioExpres implements MetodoEnvio{

    @Override
    public String tipo() {
        return "Envio Expres";
    }

    @Override
    public int diasEstimados(int distanciakm) {
        // Regla simpls: ~800 kn/día, mínimo 1 día
        int dias = (int) Math.ceil(distanciakm / 800.0);
        return Math.max(dias, 1);
    }

    @Override
    public double costo(double pesokg, int distanciakm) {
        //Mas caro que el normal
        return 2000.0 + (pesokg * 300.0) + (distanciakm * 8.0);
    }
}
