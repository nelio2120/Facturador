package com.example.facturador.Activity.Model;

import java.io.Serializable;

public class Comercio implements Serializable
{
    private int idcomercio;
    private String codigo;
    private String nombre_comercial;
    private String direccion;
    private String correo;
    private String telefono;
    private String estado;
    private int idusuario;
    private int idciudad;
    private int id_base;

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Comercio() {

    }

    public int getId_base() {
        return id_base;
    }

    public void setId_base(int id_base) {
        this.id_base = id_base;
    }

    public Comercio(int idcomercio, String codigo, String nombre_comercial, String direccion, String correo, String telefono, int idusuario, int idciudad) {
        this.idcomercio = idcomercio;
        this.codigo = codigo;
        this.nombre_comercial = nombre_comercial;
        this.direccion = direccion;
        this.correo = correo;
        this.telefono = telefono;
        this.idusuario = idusuario;
        this.idciudad = idciudad;
    }

    public int getIdcomercio() {
        return idcomercio;
    }

    public void setIdcomercio(int idcomercio) {
        this.idcomercio = idcomercio;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre_comercial() {
        return nombre_comercial;
    }

    public void setNombre_comercial(String nombre_comercial) {
        this.nombre_comercial = nombre_comercial;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public int getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(int idusuario) {
        this.idusuario = idusuario;
    }

    public int getIdciudad() {
        return idciudad;
    }

    public void setIdciudad(int idciudad) {
        this.idciudad = idciudad;
    }
}
