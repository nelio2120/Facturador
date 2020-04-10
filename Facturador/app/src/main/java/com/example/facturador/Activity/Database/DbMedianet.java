package com.example.facturador.Activity.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbMedianet extends SQLiteOpenHelper {


    public DbMedianet(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS persona (" +
                "  idpersona integer PRIMARY KEY  AUTOINCREMENT NOT NULL ," +
                "  nombre text NOT NULL," +
                "  apellido text NOT NULL," +
                "  cedula text NOT NULL," +
                "  telefono text NOT NULL," +
                "  correo text NOT NULL," +
                "estado text  DEFAULT 'ACTIVO'," +
                "  id_base integer)");
        db.execSQL("CREATE TABLE IF NOT EXISTS rol (" +
                "  idrol integer PRIMARY KEY  AUTOINCREMENT NOT NULL ," +
                "  rol_nombre text NOT NULL," +
                "estado text  DEFAULT 'ACTIVO'," +
                "id_base integer)");
        db.execSQL("CREATE TABLE IF NOT EXISTS usuarios (" +
                "  idusuarios INTEGER PRIMARY KEY  AUTOINCREMENT NOT NULL ," +
                "  usuario text NOT NULL," +
                "  clave text NOT NULL," +
                "  idrol text NOT NULL," +
                "   id_base integer," +
                "  idpersona INTEGER NOT NULL," +
                "estado text  DEFAULT 'ACTIVO'," +
                "    FOREIGN KEY (idpersona)" +
                "    REFERENCES persona (idpersona)," +
                "    FOREIGN KEY (idrol)" +
                "    REFERENCES rol (idrol))");

        db.execSQL("CREATE TABLE IF NOT EXISTS equipo (" +
                "  idequipo INTEGER PRIMARY KEY  AUTOINCREMENT NOT NULL ," +
                "  serie text NOT NULL," +
                "  modelo text NOT NULL," +
                "  idestatus INTEGER NOT NULL" +
                ",id_base integer," +
                "  idbanco INTEGER NOT NULL," +
                "estado text  DEFAULT 'ACTIVO'," +
                "    FOREIGN KEY (idestatus)" +
                "    REFERENCES estatus (idestatus)," +
                "    FOREIGN KEY (idbanco)" +
                "    REFERENCES banco (idbanco))");

        db.execSQL("CREATE TABLE IF NOT EXISTS comercio (" +
                "  idcomercio INTEGER PRIMARY KEY  AUTOINCREMENT NOT NULL ," +
                "  codigo text NOT NULL," +
                "  nombre_comercial text NOT NULL," +
                "direccion text NOT NULL," +
                "correo text NOT NULL," +
                " telefono text NOT NULL,  " +
                "  idusuario INTEGER NOT NULL" +
                ",id_base integer," +
                "  idciudad INTEGER NOT NULL," +
                "estado text  DEFAULT 'ACTIVO'," +

                "    FOREIGN KEY (idusuario)" +
                "    REFERENCES usuarios (idusuarios)," +
                "    FOREIGN KEY (idciudad)" +
                "    REFERENCES ciudad (idciudad))");


        db.execSQL("CREATE TABLE IF NOT EXISTS ciudad (" +
                "  idciudad INTEGER PRIMARY KEY  AUTOINCREMENT NOT NULL ," +
                "  nombre text NOT NULL," +
                "  idprovincia INTEGER NOT NULL" +
                ",id_base integer," +
                "estado text  DEFAULT 'ACTIVO'," +
                "    FOREIGN KEY (idprovincia)" +
                "    REFERENCES provincia (idprovincia))");

        db.execSQL("CREATE TABLE IF NOT EXISTS provincia (" +
                "  idprovincia INTEGER PRIMARY KEY  AUTOINCREMENT NOT NULL ," +
                "  nombre text NOT NULL" +
                ", id_base integer," +
                "estado text  DEFAULT 'ACTIVO'" +
                ")");

        db.execSQL("CREATE TABLE IF NOT EXISTS estatus (" +
                "  idestatus INTEGER PRIMARY KEY  AUTOINCREMENT NOT NULL ," +
                "  descripcion text NOT NULL" +
                ",id_base integer," +
                "estado text  DEFAULT 'ACTIVO'" +
                ")");

        db.execSQL("CREATE TABLE IF NOT EXISTS banco (" +
                "  idbanco INTEGER PRIMARY KEY  AUTOINCREMENT NOT NULL ," +
                "  descripcion text NOT NULL" +
                ",id_base integer," +
                "estado text  DEFAULT 'ACTIVO'" +
                ")");

        db.execSQL("CREATE TABLE IF NOT EXISTS detalle_equipo (" +
                "  iddetalle_equipo INTEGER PRIMARY KEY  AUTOINCREMENT NOT NULL " +
                ",id_base integer," +
                "idequipo integer not null ," +
                "idcomercio integer not null," +
                "estado text  DEFAULT 'ACTIVO',UNIQUE(idcomercio)," +

                "    FOREIGN KEY (idequipo)" +
                "    REFERENCES equipo (idequipo)," +
                "    FOREIGN KEY (idcomercio)" +
                "    REFERENCES comercio (idcomercio))");


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
