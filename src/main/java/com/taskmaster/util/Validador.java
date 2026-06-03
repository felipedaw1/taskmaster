package com.taskmaster.util;

import java.time.LocalDate;

public class Validador {

    public static boolean validarFechaLimite(LocalDate fechaCreacion, LocalDate fechaLimite) {
        return fechaLimite.isEqual(fechaCreacion) || fechaLimite.isAfter(fechaCreacion);
    }

    public static boolean validarTextoNoVacio(String texto) {
        return texto != null && !texto.trim().isEmpty();
    }

    public static boolean validarEmail(String email) {
        return email != null && email.contains("@") && email.contains(".");
    }
}