package com.example.facturador.Activity.Model;

import java.util.List;

public class DetalleEquipoSerializable {

    private List<DetalleEquipo> detalleEquipos;

    public DetalleEquipoSerializable(List<DetalleEquipo> detalleEquipos) {
        this.detalleEquipos = detalleEquipos;
    }

    public DetalleEquipoSerializable() {

    }

    public List<DetalleEquipo> getDetalleEquipos() {
        return detalleEquipos;
    }

    public void setDetalleEquipos(List<DetalleEquipo> detalleEquipos) {
        this.detalleEquipos = detalleEquipos;
    }
}
