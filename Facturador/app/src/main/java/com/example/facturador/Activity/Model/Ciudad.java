package com.example.facturador.Activity.Model;

import java.io.Serializable;

public class Ciudad implements Serializable {
    private int idciudad ;
    private String nombre;
    private int idprovincia;
    private int id_base;

    public Ciudad() {

    }

    public int getId_base() {
        return id_base;
    }

    public void setId_base(int id_base) {
        this.id_base = id_base;
    }

    public Ciudad(int idciudad, String nombre, int idprovincia) {
        this.idciudad = idciudad;
        this.nombre = nombre;
        this.idprovincia = idprovincia;
    }

    public int getIdciudad() {
        return idciudad;
    }

    public void setIdciudad(int idciudad) {
        this.idciudad = idciudad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getIdprovincia() {
        return idprovincia;
    }

    public void setIdprovincia(int idprovincia) {
        this.idprovincia = idprovincia;
    }
}
