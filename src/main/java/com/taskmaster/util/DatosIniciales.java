package com.taskmaster.util;

import com.taskmaster.modelo.Categoria;
import com.taskmaster.modelo.Estado;
import com.taskmaster.modelo.Tarea;
import com.taskmaster.modelo.Usuario;
import com.taskmaster.servicio.GestorCategorias;
import com.taskmaster.servicio.GestorEstados;
import com.taskmaster.servicio.GestorTareas;
import com.taskmaster.servicio.GestorUsuarios;

import java.time.LocalDate;

public class DatosIniciales {

    public static void cargarDatos(GestorUsuarios gestorUsuarios,
                                   GestorCategorias gestorCategorias,
                                   GestorEstados gestorEstados,
                                   GestorTareas gestorTareas) {

        // Usuarios
        gestorUsuarios.crearUsuario(new Usuario(1, "admin", "admin@taskmaster.com", "admin123"));
        gestorUsuarios.crearUsuario(new Usuario(2, "ana", "ana@taskmaster.com", "ana123"));

        // Categorías
        gestorCategorias.crearCategoria(new Categoria(1, "Estudios", "Tareas académicas"));
        gestorCategorias.crearCategoria(new Categoria(2, "Personal", "Tareas personales"));
        gestorCategorias.crearCategoria(new Categoria(3, "Trabajo", "Tareas laborales"));

        // Los estados ya se cargan en GestorEstados

        // Tareas
        gestorTareas.crearTarea(new Tarea(
                1,
                "Hacer resumen de bases de datos",
                "Resumir los apuntes del tema 1",
                LocalDate.of(2026, 6, 3),
                LocalDate.of(2026, 6, 5),
                "Empezado por la mañana",
                gestorUsuarios.buscarUsuarioPorId(1),
                gestorCategorias.buscarCategoriaPorId(1),
                gestorEstados.buscarEstadoPorId(1)
        ));

        gestorTareas.crearTarea(new Tarea(
                2,
                "Entregar proyecto intermodular",
                "Preparar y entregar la memoria final",
                LocalDate.of(2026, 6, 3),
                LocalDate.of(2026, 6, 10),
                "Revisar formato final",
                gestorUsuarios.buscarUsuarioPorId(2),
                gestorCategorias.buscarCategoriaPorId(1),
                gestorEstados.buscarEstadoPorId(2)
        ));
    }
}