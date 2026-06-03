package com.taskmaster.util;

import java.time.LocalDate;

/**
 * Clase de utilidades para validar datos de entrada.
 *
 * @author Felipe
 * @version 1.0
 */
public class Validador {

    /**
     * Valida que un texto no esté vacío.
     *
     * @param texto texto a validar
     * @return true si el texto contiene contenido; false en caso contrario
     */
    public static boolean validarTextoNoVacio(String texto) {
        return texto != null && !texto.trim().isEmpty();
    }

    /**
     * Valida que un email tenga un formato básico correcto.
     *
     * @param email correo electrónico a validar
     * @return true si el email tiene formato válido; false en caso contrario
     */
    public static boolean validarEmail(String email) {
        return email != null && email.matches("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$");
    }

    /**
     * Valida que la fecha límite no sea anterior a la fecha de creación.
     *
     * @param fechaCreacion fecha de creación
     * @param fechaLimite fecha límite
     * @return true si la fecha límite es válida; false en caso contrario
     */
    public static boolean validarFechaLimite(LocalDate fechaCreacion, LocalDate fechaLimite) {
        return fechaLimite != null && !fechaLimite.isBefore(fechaCreacion);
    }
}