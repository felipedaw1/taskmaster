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

/**
 * Carga datos de ejemplo para inicializar la aplicación.
 *
 * @author Felipe
 * @version 1.0
 */
public class DatosIniciales {

    /**
     * Carga datos iniciales en los gestores de la aplicación.
     *
     * @param gestorUsuarios gestor de usuarios
     * @param gestorCategorias gestor de categorías
     * @param gestorEstados gestor de estados
     * @param gestorTareas gestor de tareas
     */
    public static void cargarDatos(GestorUsuarios gestorUsuarios,
                                   GestorCategorias gestorCategorias,
                                   GestorEstados gestorEstados,
                                   GestorTareas gestorTareas) {

        Usuario usuario = new Usuario(1, "Ana", "ana@mail.com", "1234");
        Categoria categoria = new Categoria(1, "Estudios", "Tareas académicas");
        Estado estado = gestorEstados.buscarEstadoPorId(1);

        gestorUsuarios.crearUsuario(usuario);
        gestorCategorias.crearCategoria(categoria);

        if (estado != null) {
            Tarea tarea = new Tarea(
                    1,
                    "Hacer resumen",
                    "Resumen de la unidad 1",
                    LocalDate.now(),
                    LocalDate.now().plusDays(2),
                    "Sin observaciones",
                    usuario,
                    categoria,
                    estado
            );
            gestorTareas.crearTarea(tarea);
        }
    }
}