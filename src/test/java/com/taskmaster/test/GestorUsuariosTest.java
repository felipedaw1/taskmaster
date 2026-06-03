package com.taskmaster.test;

import com.taskmaster.modelo.Usuario;
import com.taskmaster.servicio.GestorUsuarios;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GestorUsuariosTest {

    @Test
    void crearUsuario_deberiaCrearCorrectamente() {
        GestorUsuarios gestor = new GestorUsuarios();
        Usuario usuario = new Usuario(1, "Ana", "ana@mail.com", "1234");

        assertTrue(gestor.crearUsuario(usuario));
    }

    @Test
    void crearUsuario_noDeberiaPermitirIdDuplicado() {
        GestorUsuarios gestor = new GestorUsuarios();
        gestor.crearUsuario(new Usuario(1, "Ana", "ana@mail.com", "1234"));

        assertFalse(gestor.crearUsuario(new Usuario(1, "Luis", "luis@mail.com", "abcd")));
    }

    @Test
    void crearUsuario_noDeberiaPermitirEmailDuplicado() {
        GestorUsuarios gestor = new GestorUsuarios();
        gestor.crearUsuario(new Usuario(1, "Ana", "ana@mail.com", "1234"));

        assertFalse(gestor.crearUsuario(new Usuario(2, "Luis", "ana@mail.com", "abcd")));
    }

    @Test
    void buscarUsuarioPorId_deberiaEncontrarUsuario() {
        GestorUsuarios gestor = new GestorUsuarios();
        Usuario usuario = new Usuario(1, "Ana", "ana@mail.com", "1234");
        gestor.crearUsuario(usuario);

        assertEquals(usuario, gestor.buscarUsuarioPorId(1));
    }

    @Test
    void buscarUsuarioPorId_deberiaDevolverNullSiNoExiste() {
        GestorUsuarios gestor = new GestorUsuarios();
        assertNull(gestor.buscarUsuarioPorId(99));
    }
}