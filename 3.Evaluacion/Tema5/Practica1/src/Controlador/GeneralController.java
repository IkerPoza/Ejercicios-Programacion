package Controlador;

import DAO.CuentaDAO;
import DAO.CuentaTitularDAO;
import DAO.TitularDAO;
import Modelo.Cuenta;
import Modelo.Titular;

import java.util.ArrayList;
import java.util.Map;

public class GeneralController {
    public static void crearAsociacion(String dni, String iban) throws Exception {
        Titular titular = TitularDAO.verTitularPorDni(dni);
        if (titular != null) {
            Cuenta cuenta = CuentaDAO.verCuentaPorIban(iban);
            if (cuenta != null) {
                CuentaTitularDAO.crearAsociacion(titular, cuenta);
            }
        }
    }
    public static void modificarAsociacionTitular(String dni, String iban, String dniN) throws Exception {
        Titular titular = TitularDAO.verTitularPorDni(dni);
        if (titular != null) {
            Cuenta cuenta = CuentaDAO.verCuentaPorIban(iban);
            if (cuenta != null) {
                Titular nuevoTitular = TitularDAO.verTitularPorDni(dniN);
                if (nuevoTitular != null) {
                    CuentaTitularDAO.modificarAsociacionTitular(titular, cuenta, nuevoTitular);
                }
            }
        }
    }

    public static void modificarAsociacionCuenta(String dni, String iban, String ibanN) throws Exception {
        Titular titular = TitularDAO.verTitularPorDni(dni);
        if (titular != null) {
            Cuenta cuenta = CuentaDAO.verCuentaPorIban(iban);
            if (cuenta != null) {
                Cuenta nuevaCuenta = CuentaDAO.verCuentaPorIban(ibanN);
                if (nuevaCuenta != null) {
                    CuentaTitularDAO.modificarAsociacionCuenta(titular, cuenta, nuevaCuenta);
                }
            }
        }
    }

    public static void borrarAsociacion(String dni, String iban) throws Exception {
        Titular titular = TitularDAO.verTitularPorDni(dni);
        if (titular != null) {
            Cuenta cuenta = CuentaDAO.verCuentaPorIban(iban);
            if (cuenta != null) {
                CuentaTitularDAO.borrarAsociacion(titular, cuenta);
            }
        }
    }

    public static Map<Titular,Cuenta> mostrarAsociaciones() {
        return  CuentaTitularDAO.mostrarAsociaciones();
    }

    public static ArrayList<Cuenta> mostrarCuentasPorTitular(String dni) throws Exception {
        Titular titular = TitularDAO.verTitularPorDni(dni);
        if (titular != null) {
            return CuentaTitularDAO.mostrarCuentasPorTitular(titular);
        }
        return null;
    }

    public static ArrayList<Titular> mostrarTitularesPorCuenta(String iban) throws Exception {
        Cuenta cuenta = CuentaDAO.verCuentaPorIban(iban);
        if (cuenta != null) {
            return CuentaTitularDAO.mostrarTitularesPorCuenta(cuenta);
        }
        return null;
    }
}
