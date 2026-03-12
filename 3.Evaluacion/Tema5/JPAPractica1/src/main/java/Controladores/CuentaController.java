package Controladores;

import DAO.CuentaDAO;
import Modelo.Cuenta;
import Modelo.Titular;

import java.util.ArrayList;

public class CuentaController {
    public static void crearCuenta(Titular titular,String iban,String saldo){
        CuentaDAO.insertar(new Cuenta(iban, Integer.parseInt(saldo), titular));
    }

    public static void borrarCuenta(String iban) {
        CuentaDAO.borrarCuenta(iban);
    }

    public static void modificarSaldo(String iban, String nuevoSaldo) {
        Cuenta cuenta = CuentaDAO.buscarCuentaPorIban(iban);
        if (cuenta != null) {
            cuenta.setSaldo(Integer.parseInt(nuevoSaldo));
            CuentaDAO.modificarCuenta(cuenta);
        }
    }

    public static ArrayList<Cuenta> mostrarCuentas() {
        return CuentaDAO.mostrarCuentas();
    }

    public static Cuenta verCuentaPorId(int id) {
        return CuentaDAO.buscarCuentaPorId(id);
    }

    public static Cuenta verCuentaPorIban(String iban) {
        return CuentaDAO.buscarCuentaPorIban(iban);
    }

    public static ArrayList<Cuenta> mostrarCuentasPorSaldo(int saldoMinimo) {
        return CuentaDAO.listarCuentasPorSaldo(saldoMinimo);
    }
}
