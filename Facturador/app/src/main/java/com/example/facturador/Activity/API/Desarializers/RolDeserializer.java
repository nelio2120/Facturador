package com.example.facturador.Activity.API.Desarializers;

import com.example.facturador.Activity.Model.*;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class RolDeserializer  implements JsonDeserializer {
    @Override
    public Object deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        JsonArray usuario = json.getAsJsonObject().get("roles").getAsJsonArray();
        Gson gson = new Gson();
        RolSerializer rol = new RolSerializer();
        ArrayList<Rol> lista = new ArrayList<>();
        for(int i = 0; i < usuario.size(); i++){
            Rol roles = null;
            int idrol = usuario.get(i).getAsJsonObject().get("idrol").getAsInt();
            String nombre = usuario.get(i).getAsJsonObject().get("nombre").getAsString();
            String estado = usuario.get(i).getAsJsonObject().get("estado").getAsString();
            roles = new Rol(idrol,nombre,estado);
            lista.add(roles);
        }
        rol.setLrol(lista);
        return rol;
    }
}
