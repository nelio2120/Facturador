package com.example.facturador.Activity.Model;

import java.io.Serializable;

public class Persona implements Serializable {
    private int idpersona;
    private String nombre;
    private String apellido;
    private String cedula;
    private String telefono;
    private String correo;
    private String estado;
    private int idbase;

    public int getIdbase() {
        return idbase;
    }

    public void setIdbase(int idbase) {
        this.idbase = idbase;
    }

    public Persona(int idpersona, String nombre, String apellido, String cedula, String telefono, String correo, String estado) {
        this.idpersona = idpersona;
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula;
        this.telefono = telefono;
        this.correo = correo;
        this.estado = estado;
    }

    public Persona() {
    }

    public int getIdpersona() {
        return idpersona;
    }

    public void setIdpersona(int idpersona) {
        this.idpersona = idpersona;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
