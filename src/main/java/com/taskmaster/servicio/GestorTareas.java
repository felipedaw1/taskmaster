package com.taskmaster.servicio;

import com.taskmaster.modelo.Categoria;
import com.taskmaster.modelo.Estado;
import com.taskmaster.modelo.Tarea;
import com.taskmaster.modelo.Usuario;

import java.util.ArrayList;
import java.util.List;

public class GestorTareas {
    private final List<Tarea> tareas;

    public GestorTareas() {
        this.tareas = new ArrayList<>();
    }

    public boolean crearTarea(Tarea tarea) {
        if (buscarTareaPorId(tarea.getIdTarea()) != null) {
            return false;
        }
        tareas.add(tarea);
        return true;
    }

    public List<Tarea> mostrarTareas() {
        return tareas;
    }

    public Tarea buscarTareaPorId(int idTarea) {
        for (Tarea tarea : tareas) {
            if (tarea.getIdTarea() == idTarea) {
                return tarea;
            }
        }
        return null;
    }

    public boolean editarTarea(Tarea tareaActualizada) {
        Tarea tarea = buscarTareaPorId(tareaActualizada.getIdTarea());
        if (tarea != null) {
            tarea.setTitulo(tareaActualizada.getTitulo());
            tarea.setDescripcion(tareaActualizada.getDescripcion());
            tarea.setFechaCreacion(tareaActualizada.getFechaCreacion());
            tarea.setFechaLimite(tareaActualizada.getFechaLimite());
            tarea.setObservaciones(tareaActualizada.getObservaciones());
            tarea.setUsuario(tareaActualizada.getUsuario());
            tarea.setCategoria(tareaActualizada.getCategoria());
            tarea.setEstado(tareaActualizada.getEstado());
            return true;
        }
        return false;
    }

    public boolean eliminarTarea(int idTarea) {
        Tarea tarea = buscarTareaPorId(idTarea);
        if (tarea != null) {
            tareas.remove(tarea);
            return true;
        }
        return false;
    }

    public boolean marcarTareaComoCompletada(int idTarea, Estado estadoCompletada) {
        Tarea tarea = buscarTareaPorId(idTarea);
        if (tarea != null) {
            tarea.setEstado(estadoCompletada);
            return true;
        }
        return false;
    }

    public List<Tarea> filtrarTareasPorCategoria(Categoria categoria) {
        List<Tarea> resultado = new ArrayList<>();
        for (Tarea tarea : tareas) {
            if (tarea.getCategoria() != null &&
                    tarea.getCategoria().getIdCategoria() == categoria.getIdCategoria()) {
                resultado.add(tarea);
            }
        }
        return resultado;
    }

    public List<Tarea> mostrarTareasDeUsuario(Usuario usuario) {
        List<Tarea> resultado = new ArrayList<>();
        for (Tarea tarea : tareas) {
            if (tarea.getUsuario() != null &&
                    tarea.getUsuario().getIdUsuario() == usuario.getIdUsuario()) {
                resultado.add(tarea);
            }
        }
        return resultado;
    }
}