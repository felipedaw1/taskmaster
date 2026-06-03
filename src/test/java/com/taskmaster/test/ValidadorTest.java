package com.taskmaster.test;

import com.taskmaster.util.Validador;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class ValidadorTest {

    @Test
    void validarTextoNoVacio_deberiaDevolverTrue() {
        assertTrue(Validador.validarTextoNoVacio("Hola"));
    }

    @Test
    void validarTextoNoVacio_deberiaDevolverFalse() {
        assertFalse(Validador.validarTextoNoVacio("   "));
    }

    @Test
    void validarEmail_deberiaDevolverTrue() {
        assertTrue(Validador.validarEmail("test@mail.com"));
    }

    @Test
    void validarEmail_deberiaDevolverFalse() {
        assertFalse(Validador.validarEmail("testmail.com"));
    }

    @Test
    void validarFechaLimite_deberiaDevolverTrue() {
        LocalDate creacion = LocalDate.of(2026, 6, 1);
        LocalDate limite = LocalDate.of(2026, 6, 3);
        assertTrue(Validador.validarFechaLimite(creacion, limite));
    }

    @Test
    void validarFechaLimite_deberiaDevolverFalse() {
        LocalDate creacion = LocalDate.of(2026, 6, 3);
        LocalDate limite = LocalDate.of(2026, 6, 1);
        assertFalse(Validador.validarFechaLimite(creacion, limite));
    }
}