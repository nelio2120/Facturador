package com.example.facturador.Activity.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.facturador.Activity.Database.DbMedianet;
import com.example.facturador.Activity.Model.Ciudad;

import java.util.ArrayList;


public class CiudadDao {

    public void guardar_Ciudad(Ciudad ciudad, Context context){
        DbMedianet admin = new DbMedianet(context,"medianet",null,1);
        SQLiteDatabase db = admin.getWritableDatabase();
        ContentValues valores = new ContentValues();
        valores.put("idciudad",ciudad.getIdciudad());
        valores.put("nombre",ciudad.getNombre());
        valores.put("idprovincia",ciudad.getIdprovincia());
        db.insert("ciudad",null,valores);
        db.close();
    }
    public ArrayList<Ciudad> listar_CIUDAD(Context context){

        DbMedianet admin = new DbMedianet(context,"medianet",null,1);
        SQLiteDatabase db = admin.getWritableDatabase();

        Cursor row = db.rawQuery("SELECT * FROM ciudad where estado ='ACTIVO'",null);
        ArrayList<Ciudad> lista =  new ArrayList<>();
        if(row.moveToFirst()){
            do{
                Ciudad obj = new Ciudad();
                obj.setIdciudad(row.getInt(0));
                obj.setNombre(row.getString(1));
                obj.setIdprovincia(row.getInt(2));
                obj.setId_base(row.getInt(3));
                lista.add(obj);
            }while (row.moveToNext());
        }
        db.close();
        return lista;
    }

}
