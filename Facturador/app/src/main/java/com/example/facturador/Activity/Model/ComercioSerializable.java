package com.example.facturador.Activity.Model;

import java.util.List;

public class ComercioSerializable {

    private List<Comercio> comercios;

    public ComercioSerializable(List<Comercio> comercios) {
        this.comercios = comercios;
    }

    public ComercioSerializable() {

    }

    public List<Comercio> getComercios() {
        return comercios;
    }

    public void setComercios(List<Comercio> comercios) {
        this.comercios = comercios;
    }
}
