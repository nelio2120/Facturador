package com.example.facturador.Activity.Model;

public class Provincia {

    private int idprovincia;
    private String nombre;
    private  String estado;
    private int id_base;

    public Provincia() {

    }

    public int getId_base() {
        return id_base;
    }

    public void setId_base(int id_base) {
        this.id_base = id_base;
    }

    public Provincia(int idprovincia, String nombre, String estado) {
        this.idprovincia = idprovincia;
        this.nombre = nombre;
        this.estado = estado;
    }

    public int getIdprovincia() {
        return idprovincia;
    }

    public void setIdprovincia(int idprovincia) {
        this.idprovincia = idprovincia;
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
