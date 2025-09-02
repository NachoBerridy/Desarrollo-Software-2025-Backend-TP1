package main.java.abstractfactory;

public class UsuarioUI implements InterfazUI{
    @Override
    public void render() {
        System.out.println("[UI Usuario], Catálogo, mis préstamos, recomendaciones");
    }
    @Override
    public String tipo() {
        return "UsuarioUI";
    }
}
