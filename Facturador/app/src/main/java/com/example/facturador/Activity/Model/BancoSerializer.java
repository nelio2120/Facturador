package com.example.facturador.Activity.Model;

import java.util.List;

public class BancoSerializer {


    private List<Banco> banco;

    public BancoSerializer(List<Banco> banco) {
        this.banco = banco;
    }

    public BancoSerializer() {

    }

    public List<Banco> getBanco() {
        return banco;
    }

    public void setBanco(List<Banco> banco) {
        this.banco = banco;
    }
}
