import Utilidades.ConexionDB;
import Vista.menuPrincipal;

public class Main {
    public static void main(String[] args) throws Exception {
        ConexionDB.crearEMF();
        menuPrincipal.mostrarMenu();
    }
}