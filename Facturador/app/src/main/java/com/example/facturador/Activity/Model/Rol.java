package com.example.facturador.Activity.Model;

import java.io.Serializable;

public class Rol implements Serializable {
    private int idrol;
    private String nombre;
    private String estado;
    private int id_base;

    public int getId_base() {
        return id_base;
    }

    public void setId_base(int id_base) {
        this.id_base = id_base;
    }

    public Rol(int idrol, String nombre, String estado) {
        this.idrol = idrol;
        this.nombre = nombre;
        this.estado = estado;
    }

    public Rol() {

    }

    public int getIdrol() {
        return idrol;
    }

    public void setIdrol(int idrol) {
        this.idrol = idrol;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
