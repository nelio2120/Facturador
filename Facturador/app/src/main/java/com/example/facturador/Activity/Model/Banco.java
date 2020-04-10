package com.example.facturador.Activity.Model;

import java.io.Serializable;

public class Banco  implements Serializable {
    private int idbanco ;
    private String descripcion;
    private String estado;
    private int id_base;

    public Banco() {

    }

    public int getId_base() {
        return id_base;
    }

    public void setId_base(int id_base) {
        this.id_base = id_base;
    }

    public Banco(int idbanco, String descripcion, String estado) {
        this.idbanco = idbanco;
        this.descripcion = descripcion;
        this.estado = estado;
    }

    public int getIdbanco() {
        return idbanco;
    }

    public void setIdbanco(int idbanco) {
        this.idbanco = idbanco;
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
