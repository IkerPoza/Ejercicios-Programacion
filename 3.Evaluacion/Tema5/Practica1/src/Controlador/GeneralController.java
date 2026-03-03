package Controlador;

import DAO.CuentaDAO;
import DAO.CuentaTitularDAO;
import DAO.TitularDAO;
import Modelo.Cuenta;
import Modelo.Titular;

import java.util.ArrayList;
import java.util.HashMap;
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

    public static Map<Titular,Cuenta> mostrarAsociaciones() throws Exception {
        Map<Titular,Cuenta> asociaciones = new HashMap<>();
        asociaciones = CuentaTitularDAO.mostrarAsociaciones();
        for (Map.Entry<Titular,Cuenta> entry : asociaciones.entrySet()) {
            Titular titular = TitularDAO.verTitularPorId(entry.getKey().getId());
            entry.getKey().setDni(titular.getDni());
            entry.getKey().setNombre(titular.getNombre());
            Cuenta cuenta = CuentaDAO.verCuentaPorId(String.valueOf(entry.getValue().getId()));
            entry.getValue().setIban(cuenta.getIban());
            entry.getValue().setSaldo(cuenta.getSaldo());
        }
        return asociaciones;
    }

    public static ArrayList<Cuenta> mostrarCuentasPorTitular(String dni) throws Exception {
        Titular titular = TitularDAO.verTitularPorDni(dni);
        if (titular != null) {
            ArrayList<Cuenta> cuentas = CuentaTitularDAO.mostrarCuentasPorTitular(titular);
            for (Cuenta cuenta : cuentas) {
                Cuenta cuentaCompleta = CuentaDAO.verCuentaPorId(String.valueOf(cuenta.getId()));
                cuenta.setIban(cuentaCompleta.getIban());
                cuenta.setSaldo(cuentaCompleta.getSaldo());
            }
            return cuentas;
        }
        return null;
    }

    public static ArrayList<Titular> mostrarTitularesPorCuenta(String iban) throws Exception {
        Cuenta cuenta = CuentaDAO.verCuentaPorIban(iban);
        if (cuenta != null) {
            ArrayList<Titular> titulares = CuentaTitularDAO.mostrarTitularesPorCuenta(cuenta);
            for (Titular titular : titulares) {
                Titular titularCompleto = TitularDAO.verTitularPorId(titular.getId());
                titular.setDni(titularCompleto.getDni());
                titular.setNombre(titularCompleto.getNombre());
            }
            return titulares;
        }
        return null;
    }
}
