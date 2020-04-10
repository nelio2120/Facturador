package com.example.facturador.Activity.Model;

import java.io.Serializable;

public class Usuarios implements Serializable {
    public int idusuario;
    public String usuario;
    public String clave;
    public int rol;
    public int persona;
    private int idbase;



    public Usuarios(int idusuario, String usuario, String clave, int rol, int persona) {
        this.idusuario = idusuario;
        this.usuario = usuario;
        this.clave = clave;
        this.rol = rol;
        this.persona = persona;
    }

    public Usuarios() {

    }
    public int getIdbase() {
        return idbase;
    }

    public void setIdbase(int idbase) {
        this.idbase = idbase;
    }

    public int getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(int idusuario) {
        this.idusuario = idusuario;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public int getRol() {
        return rol;
    }

    public void setRol(int rol) {
        this.rol = rol;
    }

    public int getPersona() {
        return persona;
    }

    public void setPersona(int persona) {
        this.persona = persona;
    }
}
