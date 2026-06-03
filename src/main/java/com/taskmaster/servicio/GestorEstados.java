package com.taskmaster.servicio;

import com.taskmaster.modelo.Estado;

import java.util.ArrayList;
import java.util.List;

public class GestorEstados {
    private final List<Estado> estados;

    public GestorEstados() {
        this.estados = new ArrayList<>();
        inicializarEstados();
    }

    private void inicializarEstados() {
        estados.add(new Estado(1, "Pendiente", "Tarea pendiente de realizar"));
        estados.add(new Estado(2, "En progreso", "Tarea en desarrollo"));
        estados.add(new Estado(3, "Completada", "Tarea finalizada"));
        estados.add(new Estado(4, "Cancelada", "Tarea cancelada"));
    }

    public List<Estado> mostrarEstados() {
        return estados;
    }

    public Estado buscarEstadoPorId(int idEstado) {
        for (Estado estado : estados) {
            if (estado.getIdEstado() == idEstado) {
                return estado;
            }
        }
        return null;
    }
}