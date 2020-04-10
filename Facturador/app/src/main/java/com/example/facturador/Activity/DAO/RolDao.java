package com.example.facturador.Activity.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.facturador.Activity.Database.*;
import com.example.facturador.Activity.Model.*;

import java.util.ArrayList;

public class RolDao {
    private DbMedianet admin;
    private SQLiteDatabase db;
    public RolDao(Context context) {
        this.admin = new DbMedianet(context,",medianet",null,1);
        this.db = this.admin.getWritableDatabase();
    }

    public RolDao() {

    }

    public void guardar_Rol(Rol rol){
        ContentValues valores = new ContentValues();
        valores.put("rol_nombre",rol.getNombre());
        valores.put("estado","ACTIVO");
        valores.put("id_base",rol.getIdrol());
        Log.e("EL USUARIO ES ","ROLES "+rol.getNombre());
        this.db.insert("rol",null,valores);
        this.db.close();
    }
    public ArrayList<Rol> listar_todo(){
        Cursor row = this.db.rawQuery("SELECT * FROM rol where estado ='ACTIVO'",null);
        ArrayList<Rol> lista =  new ArrayList<>();
        if(row.moveToFirst()){
            do{
                Rol obj = new Rol();
                obj.setIdrol(row.getInt(0));
                obj.setNombre(row.getString(1));
                lista.add(obj);
            }while (row.moveToNext());
        }
        this.db.close();
        return lista;
    }
}
