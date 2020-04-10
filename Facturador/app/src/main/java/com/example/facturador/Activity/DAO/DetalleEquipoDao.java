package com.example.facturador.Activity.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.facturador.Activity.Database.DbMedianet;

import com.example.facturador.Activity.Model.DetalleEquipo;

import java.util.ArrayList;

public class DetalleEquipoDao {

    public void guardar_DetalleEquipo(DetalleEquipo detalleEquipo, Context context){
        DbMedianet admin = new DbMedianet(context,"medianet",null,1);
        SQLiteDatabase db = admin.getWritableDatabase();
        ContentValues valores = new ContentValues();
        valores.put("idequipo",detalleEquipo.getIdequipo());
        valores.put("idcomercio",detalleEquipo.getIdcomercio());
        db.insert("detalle_equipo",null,valores);
        db.close();
    }

    public void update_idbase(int id,int idbase, Context context){
        DbMedianet admin = new DbMedianet(context,"medianet",null,1);
        SQLiteDatabase db = admin.getWritableDatabase();
        ContentValues valores = new ContentValues();
        valores.put("id_base",idbase);
        db.update("detalle_equipo",valores,"iddetalle_equipo="+id,null);
        db.close();
    }
    public ArrayList<DetalleEquipo> listar_DETALLE(Context context){

        DbMedianet admin = new DbMedianet(context,"medianet",null,1);
        SQLiteDatabase db = admin.getWritableDatabase();

        Cursor row = db.rawQuery("SELECT * FROM detalle_equipo where estado ='ACTIVO'",null);
        ArrayList<DetalleEquipo> lista =  new ArrayList<>();
        if(row.moveToFirst()){
            do{
                DetalleEquipo obj = new DetalleEquipo();
                obj.setIddetalle_equipo(row.getInt(0));
                obj.setId_base(row.getInt(1));
                obj.setIdequipo(row.getInt(2));
                obj.setIdcomercio(row.getInt(3));
                lista.add(obj);
            }while (row.moveToNext());
        }
        db.close();
        return lista;
    }

}
