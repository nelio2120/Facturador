package com.example.facturador.Activity.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.facturador.Activity.Database.DbMedianet;
import com.example.facturador.Activity.Model.Comercio;

import java.util.ArrayList;

public class ComercioDao {
    public void guardar_comercio(Comercio comercio, Context context){
        DbMedianet admin = new DbMedianet(context,"medianet",null,1);
        SQLiteDatabase db = admin.getWritableDatabase();
        ContentValues valores = new ContentValues();
        valores.put("codigo",comercio.getCodigo());
        valores.put("nombre_comercial",comercio.getNombre_comercial());
        valores.put("direccion",comercio.getDireccion());
        valores.put("correo",comercio.getCorreo());
        valores.put("telefono",comercio.getTelefono());
        valores.put("idusuario",comercio.getIdusuario());
        valores.put("idciudad" ,comercio.getIdciudad());
        db.insert("comercio",null,valores);
        db.close();
    }
    public ArrayList<Comercio> listar_COMERCIO(Context context){

        DbMedianet admin = new DbMedianet(context,"medianet",null,1);
        SQLiteDatabase db = admin.getWritableDatabase();

        Cursor row = db.rawQuery("SELECT * FROM comercio where estado ='ACTIVO'",null);
        ArrayList<Comercio> lista =  new ArrayList<>();
        if(row.moveToFirst()){
            do{
                Comercio obj = new Comercio();
                obj.setIdcomercio(row.getInt(0));
                obj.setCodigo(row.getString(1));
                obj.setNombre_comercial(row.getString(2));
                obj.setDireccion(row.getString(3));
                obj.setCorreo(row.getString(4));
                obj.setTelefono(row.getString(5));
                obj.setIdusuario(row.getInt(6));
                obj.setId_base(row.getInt(7));
                obj.setIdciudad(row.getInt(8));
                lista.add(obj);
            }while (row.moveToNext());
        }
        db.close();
        return lista;
    }


}
