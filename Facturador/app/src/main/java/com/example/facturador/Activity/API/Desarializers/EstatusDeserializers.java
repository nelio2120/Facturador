package com.example.facturador.Activity.API.Desarializers;

import com.example.facturador.Activity.Model.Estatus;
import com.example.facturador.Activity.Model.EstatusSerializable;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class EstatusDeserializers implements JsonDeserializer {
    @Override
    public Object deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        JsonArray usuario = json.getAsJsonObject().get("estatus").getAsJsonArray();

        ArrayList<Estatus> list = new ArrayList();
        for (int i =0; i<usuario.size();i++){
            int id = usuario.get(i).getAsJsonObject().get("idestatus").getAsInt();
            String codigo = usuario.get(i).getAsJsonObject().get("nombre").getAsString();
            String nombre = usuario.get(i).getAsJsonObject().get("estado").getAsString();
            Estatus comercio = new Estatus(id,codigo,nombre);
            list.add(comercio);
        }
        EstatusSerializable lista = new EstatusSerializable();
        lista.setEstatuses(list);
        return lista;
    }
}
