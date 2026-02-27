package Controlador;

import DAO.CuentaDAO;
import Modelo.Cuenta;

import java.util.ArrayList;

public class CuentaController {
    public static void crearCuenta(String iban, double saldo) {
        Cuenta cuenta = new Cuenta(iban, saldo);
        CuentaDAO.crearCuenta(cuenta);
    }

    public static void borrarCuenta(String iban) throws Exception {
        CuentaDAO.borrarCuenta(iban);
    }

    public static void modificarSaldo(double nuevoSaldo, String iban) throws Exception {
        CuentaDAO.modificarSaldo(nuevoSaldo, iban);
    }

    public static ArrayList<Cuenta> mostrarCuentas() {
        return CuentaDAO.mostrarCuentas();
    }

    public static Cuenta verCuentaPorId(String id) throws Exception {
        return CuentaDAO.verCuentaPorId(id);
    }

    public static Cuenta verCuentaPorIban(String iban) throws Exception {
        return CuentaDAO.verCuentaPorIban(iban);
    }

    public static ArrayList<Cuenta> mostrarCuentasPorSaldo(double saldo) throws Exception {
        return CuentaDAO.mostrarCuentasPorSaldo(saldo);
    }
}
