package com.taskmaster.test;

import com.taskmaster.modelo.Categoria;
import com.taskmaster.servicio.GestorCategorias;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GestorCategoriasTest {

    @Test
    void crearCategoria_deberiaCrearCorrectamente() {
        GestorCategorias gestor = new GestorCategorias();
        Categoria categoria = new Categoria(1, "Estudios", "Tareas académicas");

        assertTrue(gestor.crearCategoria(categoria));
    }

    @Test
    void crearCategoria_noDeberiaPermitirIdDuplicado() {
        GestorCategorias gestor = new GestorCategorias();
        gestor.crearCategoria(new Categoria(1, "Estudios", "Tareas académicas"));

        assertFalse(gestor.crearCategoria(new Categoria(1, "Trabajo", "Tareas laborales")));
    }

    @Test
    void buscarCategoriaPorId_deberiaEncontrarCategoria() {
        GestorCategorias gestor = new GestorCategorias();
        Categoria categoria = new Categoria(1, "Estudios", "Tareas académicas");
        gestor.crearCategoria(categoria);

        assertEquals(categoria, gestor.buscarCategoriaPorId(1));
    }

    @Test
    void buscarCategoriaPorId_deberiaDevolverNullSiNoExiste() {
        GestorCategorias gestor = new GestorCategorias();
        assertNull(gestor.buscarCategoriaPorId(99));
    }
}