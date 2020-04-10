package com.example.facturador.Activity.Model;

import java.util.List;

public class EquipoSerializable {

    private List<Equipo> equipos;

    public EquipoSerializable(List<Equipo> equipos) {
        this.equipos = equipos;
    }

    public EquipoSerializable() {

    }

    public List<Equipo> getEquipos() {
        return equipos;
    }

    public void setEquipos(List<Equipo> equipos) {
        this.equipos = equipos;
    }
}
