package com.example.facturador.Activity.Model;

import java.util.List;

public class CiudadSerializable {

    private List<Ciudad> ciudads;

    public CiudadSerializable(List<Ciudad> ciudads) {
        this.ciudads = ciudads;
    }

    public CiudadSerializable() {

    }

    public List<Ciudad> getCiudads() {
        return ciudads;
    }

    public void setCiudads(List<Ciudad> ciudads) {
        this.ciudads = ciudads;
    }
}
