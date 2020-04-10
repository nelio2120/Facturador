package com.example.facturador.Activity.Model;

import java.util.List;

public class ProvinciaSerializable {
    private List<Provincia> provincias;

    public ProvinciaSerializable(List<Provincia> provincias) {
        this.provincias = provincias;
    }

    public ProvinciaSerializable() {

    }

    public List<Provincia> getProvincias() {
        return provincias;
    }

    public void setProvincias(List<Provincia> provincias) {
        this.provincias = provincias;
    }
}
