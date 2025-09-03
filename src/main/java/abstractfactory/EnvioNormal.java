package main.java.abstractfactory;

public class EnvioNormal implements MetodoEnvio {
    @Override
    public String tipo() {
        return "Envio Normal";
    }

    @Override
    public int diasEstimados(int distanciakm) {
        //Regla simple: ~400 km/días, minimo 2 dias
        int dias = (int) Math.ceil(distanciakm / 400.0);
        return Math.max(dias, 2);
    }

    @Override
    public double costo(double pesokg, int distanciakm) {
        // Base + (por kg) + (por km)
        return 1200.0 + (pesokg * 200.0) + (distanciakm * 5.0);
    }


}
