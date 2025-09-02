package main.java.abstractfactory;

public class AdminUI implements InterfazUI {
    @Override
    public void render() {
        System.out.println("[UI admin] Dashboard, gestion de libros, usuarios, reportes ");
    }
    @Override
    public String tipo() {
        return "AdminUI";
    }
}
