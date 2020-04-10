package com.example.facturador.Activity.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.facturador.Activity.Database.DbMedianet;
import com.example.facturador.Activity.Model.Estatus;

import java.util.ArrayList;

public class EstatusDao {
    public void guardar_Estatus(Estatus estatus, Context context){
        DbMedianet admin = new DbMedianet(context,"medianet",null,1);
        SQLiteDatabase db = admin.getWritableDatabase();
        ContentValues valores = new ContentValues();
        valores.put("descripcion", estatus.getDescripcion());
        valores.put("estado",estatus.getEstado());

        db.insert("estatus",null,valores);
        db.close();
    }
    public ArrayList<Estatus> listar_ESTATUS(Context context){

        DbMedianet admin = new DbMedianet(context,"medianet",null,1);
        SQLiteDatabase db = admin.getWritableDatabase();

        Cursor row = db.rawQuery("SELECT * FROM estatus where estado ='ACTIVO'",null);
        ArrayList<Estatus> lista =  new ArrayList<>();
        if(row.moveToFirst()){
            do{
                Estatus obj = new Estatus();
                obj.setIdestatus(row.getInt(0));
                obj.setDescripcion(row.getString(1));
                obj.setId_base(row.getInt(2));
                lista.add(obj);
            }while (row.moveToNext());
        }
        db.close();
        return lista;
    }
}
