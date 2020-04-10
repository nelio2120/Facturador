package com.example.facturador.Activity.API.Desarializers;

import com.example.facturador.Activity.Model.Sincronizacion;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;

public class ResponseSerializer implements JsonDeserializer {
    @Override
    public Object deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        int id = json.getAsJsonObject().get("id").getAsInt();
        Sincronizacion sin = new Sincronizacion();
        sin.setId(id);
        return sin;
    }
}
