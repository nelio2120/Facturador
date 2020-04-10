package com.example.facturador.Activity.Model;

import java.io.Serializable;

public class DetalleEquipo  implements Serializable {

    private int iddetalle_equipo;
    private int idequipo;
    private int idcomercio;
    private int id_base;

    public DetalleEquipo() {

    }

    public int getId_base() {
        return id_base;
    }

    public void setId_base(int id_base) {
        this.id_base = id_base;
    }

    public DetalleEquipo(int iddetalle_equipo, int idequipo, int idcomercio) {
        this.iddetalle_equipo = iddetalle_equipo;
        this.idequipo = idequipo;
        this.idcomercio = idcomercio;
    }

    public int getIddetalle_equipo() {
        return iddetalle_equipo;
    }

    public void setIddetalle_equipo(int iddetalle_equipo) {
        this.iddetalle_equipo = iddetalle_equipo;
    }

    public int getIdequipo() {
        return idequipo;
    }

    public void setIdequipo(int idequipo) {
        this.idequipo = idequipo;
    }

    public int getIdcomercio() {
        return idcomercio;
    }

    public void setIdcomercio(int idcomercio) {
        this.idcomercio = idcomercio;
    }
}
