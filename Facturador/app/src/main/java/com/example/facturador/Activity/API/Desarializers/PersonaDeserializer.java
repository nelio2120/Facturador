package com.example.facturador.Activity.API.Desarializers;


import com.example.facturador.Activity.Model.*;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;


public class PersonaDeserializer implements JsonDeserializer {

    @Override
    public Object deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        JsonArray usuario = json.getAsJsonObject().get("persona").getAsJsonArray();
        PersonaSerializer persona = new PersonaSerializer();
        List<Persona> lista = new ArrayList<>();
        for (int i = 0;i<usuario.size();i++){
            Persona personas = null;
            int id = usuario.get(i).getAsJsonObject().get("idpersona").getAsInt();
            String nombre = usuario.get(i).getAsJsonObject().get("Nombre").getAsString();
            String apellido = usuario.get(i).getAsJsonObject().get("Apellido").getAsString();
            String Cedula = usuario.get(i).getAsJsonObject().get("Cedula").getAsString();
            String telefono = usuario.get(i).getAsJsonObject().get("Telefono").getAsString();
            String Correo = usuario.get(i).getAsJsonObject().get("Correo").getAsString();
            String Estado = usuario.get(i).getAsJsonObject().get("Estado").getAsString();
            personas = new Persona(id,nombre,apellido,Cedula,telefono,Correo,Estado);
            lista.add(personas);
        }
        persona.setLpersona(lista);
        return persona;
    }
}
