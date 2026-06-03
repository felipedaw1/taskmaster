package com.taskmaster.vista;

import com.taskmaster.modelo.Categoria;
import com.taskmaster.modelo.Estado;
import com.taskmaster.modelo.Tarea;
import com.taskmaster.modelo.Usuario;
import com.taskmaster.servicio.GestorCategorias;
import com.taskmaster.servicio.GestorEstados;
import com.taskmaster.servicio.GestorTareas;
import com.taskmaster.servicio.GestorUsuarios;
import com.taskmaster.util.DatosIniciales;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class MenuConsola {
    private final Scanner scanner;
    private final GestorUsuarios gestorUsuarios;
    private final GestorCategorias gestorCategorias;
    private final GestorEstados gestorEstados;
    private final GestorTareas gestorTareas;

    public MenuConsola() {
        this.scanner = new Scanner(System.in);
        this.gestorUsuarios = new GestorUsuarios();
        this.gestorCategorias = new GestorCategorias();
        this.gestorEstados = new GestorEstados();
        this.gestorTareas = new GestorTareas();
        DatosIniciales.cargarDatos(gestorUsuarios, gestorCategorias, gestorEstados, gestorTareas);
    }

    public void mostrarMenuPrincipal() {
        int opcion;
        do {
            System.out.println("\n=============================");
            System.out.println("        TASKMASTER");
            System.out.println("=============================");
            System.out.println("1. Gestionar usuarios");
            System.out.println("2. Gestionar tareas");
            System.out.println("3. Gestionar categorías");
            System.out.println("4. Gestionar estados");
            System.out.println("5. Consultas");
            System.out.println("0. Salir");
            System.out.print("Elige una opción: ");
            opcion = Integer.parseInt(scanner.nextLine());

            switch (opcion) {
                case 1 -> menuUsuarios();
                case 2 -> menuTareas();
                case 3 -> menuCategorias();
                case 4 -> menuEstados();
                case 5 -> menuConsultas();
                case 0 -> System.out.println("Saliendo de TaskMaster...");
                default -> System.out.println("Opción no válida.");
            }
        } while (opcion != 0);
    }

    private void menuUsuarios() {
        int opcion;
        do {
            System.out.println("\n--- GESTIONAR USUARIOS ---");
            System.out.println("1. Crear usuario");
            System.out.println("2. Mostrar usuarios");
            System.out.println("3. Buscar usuario por ID");
            System.out.println("0. Volver");
            System.out.print("Elige una opción: ");
            opcion = Integer.parseInt(scanner.nextLine());

            switch (opcion) {
                case 1 -> crearUsuario();
                case 2 -> mostrarUsuarios();
                case 3 -> buscarUsuarioPorId();
                case 0 -> System.out.println("Volviendo al menú principal...");
                default -> System.out.println("Opción no válida.");
            }
        } while (opcion != 0);
    }

    private void menuTareas() {
        int opcion;
        do {
            System.out.println("\n--- GESTIONAR TAREAS ---");
            System.out.println("1. Crear tarea");
            System.out.println("2. Editar tarea");
            System.out.println("3. Eliminar tarea");
            System.out.println("4. Mostrar listado de tareas");
            System.out.println("5. Marcar tarea como completada");
            System.out.println("6. Filtrar tareas por categoría");
            System.out.println("7. Mostrar tareas de un usuario");
            System.out.println("8. Buscar tarea por ID");
            System.out.println("0. Volver");
            System.out.print("Elige una opción: ");
            opcion = Integer.parseInt(scanner.nextLine());

            switch (opcion) {
                case 1 -> crearTarea();
                case 2 -> editarTarea();
                case 3 -> eliminarTarea();
                case 4 -> mostrarTareas();
                case 5 -> marcarTareaComoCompletada();
                case 6 -> filtrarTareasPorCategoria();
                case 7 -> mostrarTareasDeUsuario();
                case 8 -> buscarTareaPorId();
                case 0 -> System.out.println("Volviendo al menú principal...");
                default -> System.out.println("Opción no válida.");
            }
        } while (opcion != 0);
    }

    private void menuCategorias() {
        int opcion;
        do {
            System.out.println("\n--- GESTIONAR CATEGORÍAS ---");
            System.out.println("1. Crear categoría");
            System.out.println("2. Mostrar categorías");
            System.out.println("3. Buscar categoría por ID");
            System.out.println("0. Volver");
            System.out.print("Elige una opción: ");
            opcion = Integer.parseInt(scanner.nextLine());

            switch (opcion) {
                case 1 -> crearCategoria();
                case 2 -> mostrarCategorias();
                case 3 -> buscarCategoriaPorId();
                case 0 -> System.out.println("Volviendo al menú principal...");
                default -> System.out.println("Opción no válida.");
            }
        } while (opcion != 0);
    }

    private void menuEstados() {
        int opcion;
        do {
            System.out.println("\n--- GESTIONAR ESTADOS ---");
            System.out.println("1. Mostrar estados");
            System.out.println("2. Buscar estado por ID");
            System.out.println("0. Volver");
            System.out.print("Elige una opción: ");
            opcion = Integer.parseInt(scanner.nextLine());

            switch (opcion) {
                case 1 -> mostrarEstados();
                case 2 -> buscarEstadoPorId();
                case 0 -> System.out.println("Volviendo al menú principal...");
                default -> System.out.println("Opción no válida.");
            }
        } while (opcion != 0);
    }

    private void menuConsultas() {
        int opcion;
        do {
            System.out.println("\n--- CONSULTAS ---");
            System.out.println("1. Mostrar tareas por estado");
            System.out.println("2. Mostrar tareas completadas");
            System.out.println("0. Volver");
            System.out.print("Elige una opción: ");
            opcion = Integer.parseInt(scanner.nextLine());

            switch (opcion) {
                case 1 -> System.out.println("Funcionalidad pendiente de implementar.");
                case 2 -> System.out.println("Funcionalidad pendiente de implementar.");
                case 0 -> System.out.println("Volviendo al menú principal...");
                default -> System.out.println("Opción no válida.");
            }
        } while (opcion != 0);
    }

    private void crearUsuario() {
        System.out.print("ID usuario: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.print("Nombre usuario: ");
        String nombre = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Password: ");
        String password = scanner.nextLine();

        if (!com.taskmaster.util.Validador.validarTextoNoVacio(nombre) ||
                !com.taskmaster.util.Validador.validarEmail(email) ||
                !com.taskmaster.util.Validador.validarTextoNoVacio(password)) {
            System.out.println("Datos de usuario no válidos.");
            return;
        }

        boolean creado = gestorUsuarios.crearUsuario(new Usuario(id, nombre, email, password));
        System.out.println(creado ? "Usuario creado correctamente." : "Ya existe un usuario con ese ID o email.");
    }

    private void mostrarUsuarios() {
        List<Usuario> usuarios = gestorUsuarios.mostrarUsuarios();
        for (Usuario usuario : usuarios) {
            System.out.println(usuario);
        }
    }

    private void buscarUsuarioPorId() {
        System.out.print("ID usuario: ");
        int id = Integer.parseInt(scanner.nextLine());
        Usuario usuario = gestorUsuarios.buscarUsuarioPorId(id);
        System.out.println(usuario != null ? usuario : "Usuario no encontrado.");
    }

    private void crearCategoria() {
        System.out.print("ID categoría: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Descripción: ");
        String descripcion = scanner.nextLine();

        boolean creada = gestorCategorias.crearCategoria(new Categoria(id, nombre, descripcion));
        System.out.println(creada ? "Categoría creada correctamente." : "Ya existe una categoría con ese ID.");
    }

    private void mostrarCategorias() {
        for (Categoria categoria : gestorCategorias.mostrarCategorias()) {
            System.out.println(categoria);
        }
    }

    private void buscarCategoriaPorId() {
        System.out.print("ID categoría: ");
        int id = Integer.parseInt(scanner.nextLine());
        Categoria categoria = gestorCategorias.buscarCategoriaPorId(id);
        System.out.println(categoria != null ? categoria : "Categoría no encontrada.");
    }

    private void mostrarEstados() {
        for (Estado estado : gestorEstados.mostrarEstados()) {
            System.out.println(estado);
        }
    }

    private void buscarEstadoPorId() {
        System.out.print("ID estado: ");
        int id = Integer.parseInt(scanner.nextLine());
        Estado estado = gestorEstados.buscarEstadoPorId(id);
        System.out.println(estado != null ? estado : "Estado no encontrado.");
    }

    private void crearTarea() {
        System.out.print("ID tarea: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.print("Título: ");
        String titulo = scanner.nextLine();
        System.out.print("Descripción: ");
        String descripcion = scanner.nextLine();
        System.out.print("Fecha creación (YYYY-MM-DD): ");
        LocalDate fechaCreacion = LocalDate.parse(scanner.nextLine());
        System.out.print("Fecha límite (YYYY-MM-DD): ");
        LocalDate fechaLimite = LocalDate.parse(scanner.nextLine());
        System.out.print("Observaciones: ");
        String observaciones = scanner.nextLine();

        if (!com.taskmaster.util.Validador.validarTextoNoVacio(titulo) ||
                !com.taskmaster.util.Validador.validarFechaLimite(fechaCreacion, fechaLimite)) {
            System.out.println("Datos de tarea no válidos.");
            return;
        }

        System.out.print("ID usuario: ");
        Usuario usuario = gestorUsuarios.buscarUsuarioPorId(Integer.parseInt(scanner.nextLine()));
        System.out.print("ID categoría: ");
        Categoria categoria = gestorCategorias.buscarCategoriaPorId(Integer.parseInt(scanner.nextLine()));
        System.out.print("ID estado: ");
        Estado estado = gestorEstados.buscarEstadoPorId(Integer.parseInt(scanner.nextLine()));

        if (usuario == null || categoria == null || estado == null) {
            System.out.println("Usuario, categoría o estado no encontrados.");
            return;
        }

        boolean creada = gestorTareas.crearTarea(
                new Tarea(id, titulo, descripcion, fechaCreacion, fechaLimite, observaciones, usuario, categoria, estado)
        );
        System.out.println(creada ? "Tarea creada correctamente." : "Ya existe una tarea con ese ID.");
    }

    private void mostrarTareas() {
        for (Tarea tarea : gestorTareas.mostrarTareas()) {
            System.out.println(tarea);
        }
    }

    private void editarTarea() {
        System.out.print("ID de la tarea a editar: ");
        int id = Integer.parseInt(scanner.nextLine());

        Tarea tareaExistente = gestorTareas.buscarTareaPorId(id);
        if (tareaExistente == null) {
            System.out.println("Tarea no encontrada.");
            return;
        }

        System.out.print("Nuevo título: ");
        String titulo = scanner.nextLine();
        System.out.print("Nueva descripción: ");
        String descripcion = scanner.nextLine();
        System.out.print("Nueva fecha creación (YYYY-MM-DD): ");
        LocalDate fechaCreacion = LocalDate.parse(scanner.nextLine());
        System.out.print("Nueva fecha límite (YYYY-MM-DD): ");
        LocalDate fechaLimite = LocalDate.parse(scanner.nextLine());
        System.out.print("Nuevas observaciones: ");
        String observaciones = scanner.nextLine();

        System.out.print("Nuevo ID usuario: ");
        Usuario usuario = gestorUsuarios.buscarUsuarioPorId(Integer.parseInt(scanner.nextLine()));
        System.out.print("Nuevo ID categoría: ");
        Categoria categoria = gestorCategorias.buscarCategoriaPorId(Integer.parseInt(scanner.nextLine()));
        System.out.print("Nuevo ID estado: ");
        Estado estado = gestorEstados.buscarEstadoPorId(Integer.parseInt(scanner.nextLine()));

        Tarea tareaActualizada = new Tarea(id, titulo, descripcion, fechaCreacion, fechaLimite, observaciones, usuario, categoria, estado);
        boolean editada = gestorTareas.editarTarea(tareaActualizada);

        System.out.println(editada ? "Tarea editada correctamente." : "No se pudo editar la tarea.");
    }

    private void eliminarTarea() {
        System.out.print("ID de la tarea a eliminar: ");
        int id = Integer.parseInt(scanner.nextLine());

        boolean eliminada = gestorTareas.eliminarTarea(id);
        System.out.println(eliminada ? "Tarea eliminada correctamente." : "Tarea no encontrada.");
    }

    private void filtrarTareasPorCategoria() {
        System.out.print("ID de categoría: ");
        int idCategoria = Integer.parseInt(scanner.nextLine());

        Categoria categoria = gestorCategorias.buscarCategoriaPorId(idCategoria);
        if (categoria == null) {
            System.out.println("Categoría no encontrada.");
            return;
        }

        List<Tarea> filtradas = gestorTareas.filtrarTareasPorCategoria(categoria);
        for (Tarea tarea : filtradas) {
            System.out.println(tarea);
        }
    }

    private void mostrarTareasDeUsuario() {
        System.out.print("ID de usuario: ");
        int idUsuario = Integer.parseInt(scanner.nextLine());

        Usuario usuario = gestorUsuarios.buscarUsuarioPorId(idUsuario);
        if (usuario == null) {
            System.out.println("Usuario no encontrado.");
            return;
        }

        List<Tarea> tareasUsuario = gestorTareas.mostrarTareasDeUsuario(usuario);
        for (Tarea tarea : tareasUsuario) {
            System.out.println(tarea);
        }
    }

    private void buscarTareaPorId() {
        System.out.print("ID de tarea: ");
        int id = Integer.parseInt(scanner.nextLine());
        Tarea tarea = gestorTareas.buscarTareaPorId(id);
        System.out.println(tarea != null ? tarea : "Tarea no encontrada.");
    }

    private void marcarTareaComoCompletada() {
        System.out.print("ID de la tarea: ");
        int id = Integer.parseInt(scanner.nextLine());

        Estado completada = gestorEstados.buscarEstadoPorId(3); // Completada
        boolean actualizada = gestorTareas.marcarTareaComoCompletada(id, completada);

        System.out.println(actualizada ? "Tarea marcada como completada." : "Tarea no encontrada.");
    }
}