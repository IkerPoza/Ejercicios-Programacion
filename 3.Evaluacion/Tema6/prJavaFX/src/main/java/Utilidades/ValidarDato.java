package Utilidades;


import java.time.LocalDate;

public class ValidarDato {
    public static String validarDato(String valor, String exp) throws Exception {
        if (valor.matches(exp)) {
            return valor;
        } else {
            throw new Exception();
        }
    }

    public static LocalDate validarDate(LocalDate valor) throws Exception {
        if (valor.isBefore(LocalDate.now())) {
            return valor;
        }else {
            throw new Exception();
        }
    }
}
