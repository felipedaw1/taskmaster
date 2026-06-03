package com.taskmaster.servicio;

import com.taskmaster.modelo.Usuario;
import java.util.ArrayList;
import java.util.List;

/**
 * Gestiona las operaciones relacionadas con los usuarios de la aplicación.
 *
 * @author Felipe
 * @version 1.0
 */
public class GestorUsuarios {

    private final List<Usuario> usuarios;

    /**
     * Crea un gestor de usuarios vacío.
     */
    public GestorUsuarios() {
        this.usuarios = new ArrayList<>();
    }

    /**
     * Crea un nuevo usuario si no existe otro con el mismo ID o email.
     *
     * @param usuario usuario que se desea añadir
     * @return true si el usuario se ha creado correctamente; false en caso contrario
     */
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

    /**
     * Obtiene la lista de usuarios registrados.
     *
     * @return lista de usuarios
     */
    public List<Usuario> mostrarUsuarios() {
        return usuarios;
    }

    /**
     * Busca un usuario por su identificador.
     *
     * @param idUsuario identificador del usuario
     * @return usuario encontrado o null si no existe
     */
    public Usuario buscarUsuarioPorId(int idUsuario) {
        for (Usuario usuario : usuarios) {
            if (usuario.getIdUsuario() == idUsuario) {
                return usuario;
            }
        }
        return null;
    }

    /**
     * Busca un usuario por su correo electrónico.
     *
     * @param email correo electrónico del usuario
     * @return usuario encontrado o null si no existe
     */
    public Usuario buscarUsuarioPorEmail(String email) {
        for (Usuario usuario : usuarios) {
            if (usuario.getEmail().equalsIgnoreCase(email)) {
                return usuario;
            }
        }
        return null;
    }
}