package com.taskmaster.servicio;

import com.taskmaster.modelo.Categoria;

import java.util.ArrayList;
import java.util.List;

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