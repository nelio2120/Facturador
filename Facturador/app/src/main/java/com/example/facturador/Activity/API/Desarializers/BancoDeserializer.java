package com.example.facturador.Activity.API.Desarializers;

import com.example.facturador.Activity.Model.Banco;
import com.example.facturador.Activity.Model.BancoSerializer;
import com.example.facturador.Activity.Model.Comercio;
import com.example.facturador.Activity.Model.ComercioSerializable;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;
import java.util.ArrayList;



public class BancoDeserializer implements JsonDeserializer {


    @Override
    public Object deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {

        {
            JsonArray banco = json.getAsJsonObject().get("entidad_bancaria").getAsJsonArray();

            ArrayList<Banco> list = new ArrayList();
            for (int i =0; i<banco.size();i++){
                int id = banco.get(i).getAsJsonObject().get("idbanco").getAsInt();
                String descripcion = banco.get(i).getAsJsonObject().get("descripcion").getAsString();
                String estado = banco.get(i).getAsJsonObject().get("estado").getAsString();


                Banco comercio = new Banco(id,descripcion,estado);
                list.add(comercio);
            }
            BancoSerializer lista = new BancoSerializer();
            lista.setBanco(list);
            return lista;
        }




    }
}
