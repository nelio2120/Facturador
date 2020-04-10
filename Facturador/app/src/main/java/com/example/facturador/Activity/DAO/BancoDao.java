package com.example.facturador.Activity.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.facturador.Activity.Database.DbMedianet;
import com.example.facturador.Activity.Model.Banco;

import java.util.ArrayList;

public class BancoDao {

    public void guardar_Banco(Banco banco, Context context){
        DbMedianet admin = new DbMedianet(context,"medianet",null,1);
        SQLiteDatabase db = admin.getWritableDatabase();
        ContentValues valores = new ContentValues();
        valores.put("descripcion", banco.getDescripcion());
        valores.put("estado",banco.getEstado());

        db.insert("banco",null,valores);
        db.close();
    }
    public ArrayList<Banco> listar_BANCO(Context context){

        DbMedianet admin = new DbMedianet(context,"medianet",null,1);
        SQLiteDatabase db = admin.getWritableDatabase();

        Cursor row = db.rawQuery("SELECT * FROM banco where estado ='ACTIVO'",null);
        ArrayList<Banco> lista =  new ArrayList<>();
        if(row.moveToFirst()){
            do{
                Banco obj = new Banco();
                obj.setIdbanco(row.getInt(0));
                obj.setDescripcion(row.getString(1));
                obj.setId_base(row.getInt(2));
                lista.add(obj);
            }while (row.moveToNext());
        }
        db.close();
        return lista;
    }

}
