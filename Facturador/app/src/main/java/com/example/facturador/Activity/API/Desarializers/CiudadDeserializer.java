package com.example.facturador.Activity.API.Desarializers;

import com.example.facturador.Activity.Model.Ciudad;
import com.example.facturador.Activity.Model.CiudadSerializable;
import com.example.facturador.Activity.Model.Provincia;
import com.example.facturador.Activity.Model.ProvinciaSerializable;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class CiudadDeserializer implements JsonDeserializer {


    @Override
    public Object deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {

        {
            JsonArray ciudad = json.getAsJsonObject().get("ciudad").getAsJsonArray();

            ArrayList<Ciudad> list = new ArrayList();
            for (int i =0; i<ciudad.size();i++){
                int id_ciudad = ciudad.get(i).getAsJsonObject().get("idciudad").getAsInt();
                int id = ciudad.get(i).getAsJsonObject().get("idprovincia").getAsInt();
                String   nombre = ciudad.get(i).getAsJsonObject().get("nombre").getAsString();
                Ciudad comercio = new Ciudad(id_ciudad,nombre,id);
                list.add(comercio);
            }
            CiudadSerializable lista = new CiudadSerializable();
            lista.setCiudads (list);
            return lista;
        }







    }
}
