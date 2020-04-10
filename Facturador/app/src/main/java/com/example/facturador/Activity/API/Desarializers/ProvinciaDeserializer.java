package com.example.facturador.Activity.API.Desarializers;

import com.example.facturador.Activity.Model.DetalleEquipo;
import com.example.facturador.Activity.Model.DetalleEquipoSerializable;
import com.example.facturador.Activity.Model.Provincia;
import com.example.facturador.Activity.Model.ProvinciaSerializable;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class ProvinciaDeserializer implements JsonDeserializer
{


    @Override
    public Object deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {

        {
            JsonArray provincia = json.getAsJsonObject().get("provincia").getAsJsonArray();

            ArrayList<Provincia> list = new ArrayList();
            for (int i =0; i<provincia.size();i++){
                int id = provincia.get(i).getAsJsonObject().get("idprovincia").getAsInt();
             String   nombre = provincia.get(i).getAsJsonObject().get("nombre").getAsString();
                String estado = provincia.get(i).getAsJsonObject().get("estado").getAsString();


                Provincia comercio = new Provincia(id,nombre,estado);
                list.add(comercio);
            }
            ProvinciaSerializable lista = new ProvinciaSerializable();
            lista.setProvincias(list);
            return lista;
        }



    }
}
