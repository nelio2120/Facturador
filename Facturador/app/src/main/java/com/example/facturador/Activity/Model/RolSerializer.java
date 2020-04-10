package com.example.facturador.Activity.Model;

import java.util.ArrayList;
import java.util.List;
import com.example.facturador.Activity.Model.*;
public class RolSerializer {
    private ArrayList<Rol> lrol;

    public RolSerializer() {
    }

    public RolSerializer(ArrayList<Rol> lrol) {
        this.lrol = lrol;
    }

    public List<Rol> getLrol() {
        return lrol;
    }

    public void setLrol(ArrayList<Rol> lrol) {
        this.lrol = lrol;
    }
}
