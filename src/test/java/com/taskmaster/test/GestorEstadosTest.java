package com.taskmaster.test;

import com.taskmaster.modelo.Estado;
import com.taskmaster.servicio.GestorEstados;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GestorEstadosTest {

    @Test
    void mostrarEstados_noDeberiaEstarVacio() {
        GestorEstados gestor = new GestorEstados();
        assertFalse(gestor.mostrarEstados().isEmpty());
    }

    @Test
    void buscarEstadoPorId_deberiaEncontrarEstado() {
        GestorEstados gestor = new GestorEstados();
        Estado estado = gestor.buscarEstadoPorId(1);

        assertNotNull(estado);
    }

    @Test
    void buscarEstadoPorId_deberiaDevolverNullSiNoExiste() {
        GestorEstados gestor = new GestorEstados();
        assertNull(gestor.buscarEstadoPorId(99));
    }
}