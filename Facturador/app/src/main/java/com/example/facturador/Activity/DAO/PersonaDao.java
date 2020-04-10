package com.example.facturador.Activity.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.facturador.Activity.Database.DbMedianet;
import com.example.facturador.Activity.Model.Persona;
import com.example.facturador.Activity.Model.Rol;

import java.util.ArrayList;

public class PersonaDao {
    public void guardar_Persona(Persona persona, Context context){
        DbMedianet admin = new DbMedianet(context,"medianet",null,1);
        SQLiteDatabase db = admin.getWritableDatabase();
        ContentValues valores = new ContentValues();
        valores.put("nombre",persona.getNombre());
        valores.put("apellido",persona.getApellido());
        valores.put("cedula",persona.getCedula());
        valores.put("telefono",persona.getTelefono());
        valores.put("correo",persona.getCorreo());
        valores.put("estado","ACTIVO");
        valores.put("id_base",persona.getIdpersona());
        db.insert("persona",null,valores);
        db.close();
    }
    public ArrayList<Persona> listar_persona(Context context){
        DbMedianet admin = new DbMedianet(context,"medianet",null,1);
        SQLiteDatabase db = admin.getWritableDatabase();
        Cursor row = db.rawQuery("SELECT * FROM persona where estado ='ACTIVO'",null);
        ArrayList<Persona> lista = new ArrayList<>();
        if(row.moveToFirst()){
            do{
                Persona persona = new Persona();
                persona.setIdpersona(row.getInt(0));
                persona.setNombre(row.getString(1));
                persona.setApellido(row.getString(2));
                persona.setCedula(row.getString(3));
                persona.setTelefono(row.getString(4));
                persona.setCorreo(row.getString(5));
                persona.setIdbase(row.getInt(7));
                lista.add(persona);
            }while(row.moveToNext());
        }
        db.close();
        return lista;
    }
}
