package com.example.facturador.Activity.Model;

import java.util.ArrayList;
import java.util.List;
import com.example.facturador.Activity.Model.*;
public class UserDeserializer {
    private ArrayList<Usuarios> Luser;

    public UserDeserializer(ArrayList<Usuarios> luser) {
        Luser = luser;
    }

    public UserDeserializer() {

    }

    public ArrayList<Usuarios> getLuser() {
        return Luser;
    }

    public void setLuser(ArrayList<Usuarios> luser) {
        Luser = luser;
    }
}
