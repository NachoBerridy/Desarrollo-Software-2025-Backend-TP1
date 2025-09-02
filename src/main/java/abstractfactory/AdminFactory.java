package main.java.abstractfactory;

public class AdminFactory implements AbstractFactory {

    @Override
    public InterfazUI crearUI() {
        return new AdminUI();
    }

    @Override
    public MetodoEnvio crearEnvio() {
        //Política; admin usa express por defecto
        return new EnvioExpres();
    }
}
