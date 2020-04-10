package com.example.facturador.Activity.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.facturador.Activity.Database.DbMedianet;
import com.example.facturador.Activity.Model.DetalleEquipo;
import com.example.facturador.Activity.Model.Equipo;

import java.util.ArrayList;

public class EquipoDao {
    public void guardar_Equipo(Equipo equipo, Context context){
        DbMedianet admin = new DbMedianet(context,"medianet",null,1);
        SQLiteDatabase db = admin.getWritableDatabase();
        ContentValues valores = new ContentValues();
        valores.put("serie",equipo.getSerie());
        valores.put("modelo",equipo.getModelo());
        valores.put("idestatus",equipo.getIdestatus());
        valores.put("idbanco",equipo.getIdbanco());

        db.insert("equipo",null,valores);
        db.close();
    }
    public ArrayList<Equipo> listar_EQUIPO(Context context){

        DbMedianet admin = new DbMedianet(context,"medianet",null,1);
        SQLiteDatabase db = admin.getWritableDatabase();

        Cursor row = db.rawQuery("SELECT * FROM equipo where estado ='ACTIVO'",null);
        ArrayList<Equipo> lista =  new ArrayList<>();
        if(row.moveToFirst()){
            do{
                Equipo obj = new Equipo();
                obj.setIdequipo(row.getInt(0));
                obj.setSerie(row.getString(1));
                obj.setModelo(row.getString(2));
                obj.setIdestatus(row.getInt(3));
                obj.setIdbanco(row.getInt(5));
                obj.setId_base(row.getInt(4));
                lista.add(obj);
            }while (row.moveToNext());
        }
        db.close();
        return lista;
    }






}
