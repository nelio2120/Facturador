package com.example.facturador.Activity.Model;

import java.util.List;
import com.example.facturador.Activity.Model.*;
public class PersonaSerializer {
    List<Persona> lpersona;

    public PersonaSerializer(List<Persona> lpersona) {
        this.lpersona = lpersona;
    }

    public PersonaSerializer() {
    }

    public List<Persona> getLpersona() {
        return lpersona;
    }

    public void setLpersona(List<Persona> lpersona) {
        this.lpersona = lpersona;
    }
}
