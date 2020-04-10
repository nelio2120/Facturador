package com.example.facturador.Activity.API.Desarializers;


import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.example.facturador.Activity.Model.Usuarios;
import com.google.gson.JsonParseException;
import com.example.facturador.Activity.Model.UserDeserializer;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class UsuarioEnDeserializer implements JsonDeserializer {

    @Override
    public Object deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        JsonArray usuario = json.getAsJsonObject().get("usuarios").getAsJsonArray();
        UserDeserializer listUsuario = new UserDeserializer();
        ArrayList<Usuarios> luser = new ArrayList<>();
        for(int i = 0;i < usuario.size();i++) {
            Usuarios user = new Usuarios();
            user.setIdusuario(usuario.get(i).getAsJsonObject().get("idusuarios").getAsInt());
            user.setUsuario(usuario.get(i).getAsJsonObject().get("usuario").getAsString());
            user.setClave(usuario.get(i).getAsJsonObject().get("clave").getAsString());
            user.setPersona(usuario.get(i).getAsJsonObject().get("rol").getAsInt());
            user.setRol(usuario.get(i).getAsJsonObject().get("persona").getAsInt());
            luser.add(user);
        }
        listUsuario.setLuser(luser);
        return listUsuario;
    }
}
