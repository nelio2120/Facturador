package com.example.facturador.Activity.Model;

import java.io.Serializable;

public class Estatus implements Serializable {
    private int idestatus;
    private String descripcion;
    private String estado;
    private int id_base;

    public Estatus() {

    }

    public int getId_base() {
        return id_base;
    }

    public void setId_base(int id_base) {
        this.id_base = id_base;
    }

    public Estatus(int idestatus, String descripcion, String estado) {
        this.idestatus = idestatus;
        this.descripcion = descripcion;
        this.estado = estado;
    }

    public int getIdestatus() {
        return idestatus;
    }

    public void setIdestatus(int idestatus) {
        this.idestatus = idestatus;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
