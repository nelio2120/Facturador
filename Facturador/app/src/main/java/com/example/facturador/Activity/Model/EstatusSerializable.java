package com.example.facturador.Activity.Model;

import java.util.List;

public class EstatusSerializable {
    private List<Estatus> estatuses;

    public EstatusSerializable(List<Estatus> estatuses) {
        this.estatuses = estatuses;
    }

    public EstatusSerializable() {

    }

    public List<Estatus> getEstatuses() {
        return estatuses;
    }

    public void setEstatuses(List<Estatus> estatuses) {
        this.estatuses = estatuses;
    }
}
