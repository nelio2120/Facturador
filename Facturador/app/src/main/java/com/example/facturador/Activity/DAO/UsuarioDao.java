package com.example.facturador.Activity.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.facturador.Activity.Database.DbMedianet;
import com.example.facturador.Activity.Model.Usuarios;

import java.util.ArrayList;

public class UsuarioDao {
    public void guardar_Uuario(Usuarios usuario, Context context){
        DbMedianet admin = new DbMedianet(context,"medianet",null,1);
        SQLiteDatabase db = admin.getWritableDatabase();
        ContentValues valores = new ContentValues();
        valores.put("usuario",usuario.getUsuario());
        valores.put("clave",usuario.getClave());
        valores.put("idrol",usuario.getRol());
        valores.put("idpersona",usuario.getPersona());
        valores.put("id_base",usuario.getIdusuario());
        valores.put("estado","ACTIVO");
        db.insert("usuarios",null,valores);
        db.close();
    }
    public void editar_usuario(Usuarios usuario, Context context){
        DbMedianet admin = new DbMedianet(context,"medianet",null,1);
        SQLiteDatabase db = admin.getWritableDatabase();
        ContentValues valores = new ContentValues();
        valores.put("usuario",usuario.getUsuario());
        valores.put("clave",usuario.getClave());
        valores.put("idrol",usuario.getRol());
        valores.put("idpersona",usuario.getPersona());
        valores.put("estado","ACTIVO");
        db.update("usuarios",valores,"idusuarios="+usuario.getIdusuario(),null);
        db.close();
    }
    public void Eliminar_usuario(int usuarios,Context context)
    {
        DbMedianet admin = new DbMedianet(context,"medianet",null,1);
        SQLiteDatabase db = admin.getWritableDatabase();
        ContentValues valores = new ContentValues();
        valores.put("estado","INACTIVO");
        db.update("usuarios",valores,"idusuarios="+usuarios,null);
        db.close();
    }

    public void update_idbase_Usuario(int id,int idbase,Context context)
    {
        DbMedianet admin = new DbMedianet(context,"medianet",null,1);
        SQLiteDatabase db = admin.getWritableDatabase();
        ContentValues valores = new ContentValues();
        valores.put("id_base",idbase);
        db.update("usuarios",valores,"idusuarios="+id,null);
    }
    public ArrayList<Usuarios> listar_usuario(Context context){
        DbMedianet admin = new DbMedianet(context,"medianet",null,1);
        SQLiteDatabase db = admin.getWritableDatabase();
        Cursor row = db.rawQuery("SELECT * FROM usuarios",null);
        ArrayList<Usuarios> lista = new ArrayList<>();
        if(row.moveToFirst()){
            do{
                Usuarios obj = new Usuarios();
                obj.setIdusuario(row.getInt(0));
                obj.setUsuario(row.getString(1));
                obj.setClave(row.getString(2));
                obj.setRol(row.getInt(3));
                obj.setPersona(row.getInt(5));
                lista.add(obj);
            }while (row.moveToNext());
        }
        return lista;
    }
}
