package com.example.facturador.Activity.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.facturador.Activity.Database.DbMedianet;

import com.example.facturador.Activity.Model.Provincia;

import java.util.ArrayList;

public class ProvinciaDao {
    public void guardar_Provincia(Provincia provincia, Context context){
        DbMedianet admin = new DbMedianet(context,"medianet",null,1);
        SQLiteDatabase db = admin.getWritableDatabase();
        ContentValues valores = new ContentValues();
        valores.put("nombre", provincia.getNombre());
        valores.put("estado",provincia.getEstado());
        db.insert("provincia",null,valores);
        db.close();
    }
    public ArrayList<Provincia> listar_PROVINCIA(Context context){

        DbMedianet admin = new DbMedianet(context,"medianet",null,1);
        SQLiteDatabase db = admin.getWritableDatabase();

        Cursor row = db.rawQuery("SELECT * FROM provincia where estado ='ACTIVO'",null);
        ArrayList<Provincia> lista =  new ArrayList<>();
        if(row.moveToFirst()){
            do{
                Provincia obj = new Provincia();
                obj.setIdprovincia(row.getInt(0));
                obj.setNombre(row.getString(1));
                obj.setId_base(row.getInt(2));
                lista.add(obj);
            }while (row.moveToNext());
        }
        db.close();
        return lista;
    }

}
