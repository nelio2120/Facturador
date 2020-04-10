package com.example.facturador.Activity.API.Desarializers;

import com.example.facturador.Activity.Model.DetalleEquipo;
import com.example.facturador.Activity.Model.DetalleEquipoSerializable;
import com.example.facturador.Activity.Model.Equipo;
import com.example.facturador.Activity.Model.EquipoSerializable;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class DetalleEquipoDeserializer  implements JsonDeserializer {


    @Override
    public Object deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {


        {
            JsonArray detalle_equipo = json.getAsJsonObject().get("detalle_equipo").getAsJsonArray();

            ArrayList<DetalleEquipo> list = new ArrayList();
            for (int i =0; i<detalle_equipo.size();i++){
                int id = detalle_equipo.get(i).getAsJsonObject().get("iddetalle_equipo").getAsInt();
                String estado = detalle_equipo.get(i).getAsJsonObject().get("estado").getAsString();
                int idequipo = detalle_equipo.get(i).getAsJsonObject().get("idequipo").getAsInt();
                int idcomercio = detalle_equipo.get(i).getAsJsonObject().get("idcomercio").getAsInt();

                DetalleEquipo comercio = new DetalleEquipo(id,idcomercio,idequipo);
                list.add(comercio);
            }
            DetalleEquipoSerializable lista = new DetalleEquipoSerializable();
            lista.setDetalleEquipos(list);
            return lista;
        }






    }
}
