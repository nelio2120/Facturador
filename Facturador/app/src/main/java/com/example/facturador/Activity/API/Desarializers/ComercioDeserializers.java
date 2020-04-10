package com.example.facturador.Activity.API.Desarializers;

import com.example.facturador.Activity.Model.Comercio;
import com.example.facturador.Activity.Model.ComercioSerializable;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class ComercioDeserializers implements JsonDeserializer {
    @Override
    public Object deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        JsonArray usuario = json.getAsJsonObject().get("comercio").getAsJsonArray();

        ArrayList<Comercio> list = new ArrayList();
        for (int i =0; i<usuario.size();i++){
            int id = usuario.get(i).getAsJsonObject().get("idcomercio").getAsInt();
            String codigo = usuario.get(i).getAsJsonObject().get("codigo").getAsString();
            String nombre = usuario.get(i).getAsJsonObject().get("nombre_comercial").getAsString();
            String estado = usuario.get(i).getAsJsonObject().get("estado").getAsString();
            String direccion = usuario.get(i).getAsJsonObject().get("direccion").getAsString();
            int idciudad = usuario.get(i).getAsJsonObject().get("idciudad").getAsInt();
            String correo = usuario.get(i).getAsJsonObject().get("correo").getAsString();
            String telefono = usuario.get(i).getAsJsonObject().get("telefono").getAsString();
            int idusuario = usuario.get(i).getAsJsonObject().get("idusuario").getAsInt();
            Comercio comercio = new Comercio(id,codigo,nombre,direccion,correo,telefono,idusuario,idciudad);
            list.add(comercio);
        }
        ComercioSerializable lista = new ComercioSerializable();
        lista.setComercios(list);
        return lista;
    }
}
