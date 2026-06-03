package com.taskmaster.servicio;

import com.taskmaster.modelo.Categoria;

import java.util.ArrayList;
import java.util.List;

/**
 * Gestiona las categorías de tareas de la aplicación.
 *
 * @author Felipe
 * @version 1.0
 */

public class GestorCategorias {
    private final List<Categoria> categorias;

    public GestorCategorias() {
        this.categorias = new ArrayList<>();
    }

    public boolean crearCategoria(Categoria categoria) {
        if (buscarCategoriaPorId(categoria.getIdCategoria()) != null) {
            return false;
        }
        categorias.add(categoria);
        return true;
    }

    public List<Categoria> mostrarCategorias() {
        return categorias;
    }

    public Categoria buscarCategoriaPorId(int idCategoria) {
        for (Categoria categoria : categorias) {
            if (categoria.getIdCategoria() == idCategoria) {
                return categoria;
            }
        }
        return null;
    }
}