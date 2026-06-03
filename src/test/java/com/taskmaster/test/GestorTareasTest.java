package com.taskmaster.test;

import com.taskmaster.modelo.Categoria;
import com.taskmaster.modelo.Estado;
import com.taskmaster.modelo.Tarea;
import com.taskmaster.modelo.Usuario;
import com.taskmaster.servicio.GestorTareas;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class GestorTareasTest {

    private Tarea crearTareaEjemplo(int id) {
        Usuario usuario = new Usuario(1, "Ana", "ana@mail.com", "1234");
        Categoria categoria = new Categoria(1, "Estudios", "Tareas académicas");
        Estado estado = new Estado(1, "Pendiente", "Tarea pendiente");

        return new Tarea(
                id,
                "Hacer resumen",
                "Resumen del tema 1",
                LocalDate.of(2026, 6, 1),
                LocalDate.of(2026, 6, 3),
                "Sin observaciones",
                usuario,
                categoria,
                estado
        );
    }

    @Test
    void crearTarea_deberiaCrearCorrectamente() {
        GestorTareas gestor = new GestorTareas();
        assertTrue(gestor.crearTarea(crearTareaEjemplo(1)));
    }

    @Test
    void crearTarea_noDeberiaPermitirIdDuplicado() {
        GestorTareas gestor = new GestorTareas();
        gestor.crearTarea(crearTareaEjemplo(1));

        assertFalse(gestor.crearTarea(crearTareaEjemplo(1)));
    }

    @Test
    void buscarTareaPorId_deberiaEncontrarTarea() {
        GestorTareas gestor = new GestorTareas();
        Tarea tarea = crearTareaEjemplo(1);
        gestor.crearTarea(tarea);

        assertEquals(tarea, gestor.buscarTareaPorId(1));
    }

    @Test
    void eliminarTarea_deberiaEliminarCorrectamente() {
        GestorTareas gestor = new GestorTareas();
        gestor.crearTarea(crearTareaEjemplo(1));

        assertTrue(gestor.eliminarTarea(1));
        assertNull(gestor.buscarTareaPorId(1));
    }

    @Test
    void eliminarTarea_deberiaDevolverFalseSiNoExiste() {
        GestorTareas gestor = new GestorTareas();
        assertFalse(gestor.eliminarTarea(99));
    }
}