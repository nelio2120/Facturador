package com.example.facturador.Activity.Model;

import java.io.Serializable;

public class Equipo implements Serializable {

    private int idequipo;
    private String serie;
    private String modelo;
    private int idestatus;
    private int idbanco;
    private int id_base;

    public Equipo() {

    }

    public int getId_base() {
        return id_base;
    }

    public void setId_base(int id_base) {
        this.id_base = id_base;
    }

    public Equipo(int idequipo, String serie, String modelo, int idestatus, int idbanco) {
        this.idequipo = idequipo;
        this.serie = serie;
        this.modelo = modelo;
        this.idestatus = idestatus;
        this.idbanco = idbanco;
    }

    public int getIdequipo() {
        return idequipo;
    }

    public void setIdequipo(int idequipo) {
        this.idequipo = idequipo;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getIdestatus() {
        return idestatus;
    }

    public void setIdestatus(int idestatus) {
        this.idestatus = idestatus;
    }

    public int getIdbanco() {
        return idbanco;
    }

    public void setIdbanco(int idbanco) {
        this.idbanco = idbanco;
    }
}
