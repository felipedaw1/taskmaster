package com.taskmaster.modelo;

import java.time.LocalDate;

public class Tarea {
    private int idTarea;
    private String titulo;
    private String descripcion;
    private LocalDate fechaCreacion;
    private LocalDate fechaLimite;
    private String observaciones;
    private Usuario usuario;
    private Categoria categoria;
    private Estado estado;

    public Tarea() {
    }

    public Tarea(int idTarea, String titulo, String descripcion, LocalDate fechaCreacion, LocalDate fechaLimite, String observaciones, Usuario usuario, Categoria categoria, Estado estado) {
        this.idTarea = idTarea;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.fechaCreacion = fechaCreacion;
        this.fechaLimite = fechaLimite;
        this.observaciones = observaciones;
        this.usuario = usuario;
        this.categoria = categoria;
        this.estado = estado;
    }

    public int getIdTarea() {
        return idTarea;
    }

    public void setIdTarea(int idTarea) {
        this.idTarea = idTarea;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDate fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public LocalDate getFechaLimite() {
        return fechaLimite;
    }

    public void setFechaLimite(LocalDate fechaLimite) {
        this.fechaLimite = fechaLimite;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Tarea{" + "idTarea=" + idTarea + ", titulo='" + titulo + '\'' + ", fechaCreacion=" + fechaCreacion + ", fechaLimite=" + fechaLimite + ", estado=" + (estado != null ? estado.getNombre() : "sin estado") + '}';
    }
}