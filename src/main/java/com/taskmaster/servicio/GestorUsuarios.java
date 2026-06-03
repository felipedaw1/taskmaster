package com.taskmaster.servicio;

import com.taskmaster.modelo.Usuario;

import java.util.ArrayList;
import java.util.List;

public class GestorUsuarios {
    private final List<Usuario> usuarios;

    public GestorUsuarios() {
        this.usuarios = new ArrayList<>();
    }

    public boolean crearUsuario(Usuario usuario) {
        if (buscarUsuarioPorId(usuario.getIdUsuario()) != null) {
            return false;
        }
        if (buscarUsuarioPorEmail(usuario.getEmail()) != null) {
            return false;
        }
        usuarios.add(usuario);
        return true;
    }

    public List<Usuario> mostrarUsuarios() {
        return usuarios;
    }

    public Usuario buscarUsuarioPorId(int idUsuario) {
        for (Usuario usuario : usuarios) {
            if (usuario.getIdUsuario() == idUsuario) {
                return usuario;
            }
        }
        return null;
    }

    public Usuario buscarUsuarioPorEmail(String email) {
        for (Usuario usuario : usuarios) {
            if (usuario.getEmail().equalsIgnoreCase(email)) {
                return usuario;
            }
        }
        return null;
    }
}