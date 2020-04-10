package com.example.facturador.Activity.API.Desarializers;

import com.example.facturador.Activity.Model.Banco;
import com.example.facturador.Activity.Model.BancoSerializer;
import com.example.facturador.Activity.Model.Equipo;
import com.example.facturador.Activity.Model.EquipoSerializable;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class EquipoDeserializer   implements JsonDeserializer {


    @Override
    public Object deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        {
            JsonArray equipo = json.getAsJsonObject().get("equipo").getAsJsonArray();
            ArrayList<Equipo> list = new ArrayList();
            for (int i =0; i<equipo.size();i++){
                int id = equipo.get(i).getAsJsonObject().get("idequipo").getAsInt();
                String serie = equipo.get(i).getAsJsonObject().get("serie").getAsString();
                String modelo = equipo.get(i).getAsJsonObject().get("modelo").getAsString();
                int idestatus = equipo.get(i).getAsJsonObject().get("idestatus").getAsInt();
                int idbanco = equipo.get(i).getAsJsonObject().get("idbannco").getAsInt();
                Equipo comercio = new Equipo(id,serie,modelo,idestatus,idbanco);
                list.add(comercio);
            }
            EquipoSerializable lista = new EquipoSerializable();
            lista.setEquipos(list);
            return lista;
        }









    }
}

