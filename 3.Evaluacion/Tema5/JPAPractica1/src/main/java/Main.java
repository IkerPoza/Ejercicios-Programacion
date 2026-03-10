//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import Utilidades.DBConnection;
import Vista.MenuTitulares;

public class Main {
    public static void main(String[] args) {
        DBConnection.crearEMF();

        MenuTitulares menu = new MenuTitulares();
        menu.mostrarMenu();
    }
}
