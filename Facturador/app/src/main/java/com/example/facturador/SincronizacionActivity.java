package com.example.facturador;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.facturador.Activity.API.API;
import com.example.facturador.Activity.API.Desarializers.ResponseSerializer;
import com.example.facturador.Activity.API.Desarializers.UsuarioEnDeserializer;
import com.example.facturador.Activity.API.Services.Service;
import com.example.facturador.Activity.Activity.Listar_Detalle_equipo;
import com.example.facturador.Activity.DAO.DetalleEquipoDao;
import com.example.facturador.Activity.DAO.UsuarioDao;
import com.example.facturador.Activity.Database.DbMedianet;
import com.example.facturador.Activity.Model.DetalleEquipo;
import com.example.facturador.Activity.Model.Sincronizacion;
import com.example.facturador.Activity.Model.UserDeserializer;
import com.example.facturador.Activity.Model.Usuarios;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SincronizacionActivity extends AppCompatActivity {
    Button sincronizar;
    DbMedianet medianet;
    SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sincronizacion);

        sincronizar = (Button) findViewById(R.id.btn_sincronizar);

        sincronizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                medianet = new DbMedianet(SincronizacionActivity.this,"medianet",null,1);
                db = medianet.getWritableDatabase();
                Cursor row = db.rawQuery("SELECT * FROM usuarios where estado ='ACTIVO'",null);
                if(row.moveToFirst()){
                    do{
                        final Usuarios user = new Usuarios();
                        user.setIdusuario(row.getInt(0));
                        user.setUsuario(row.getString(1));
                        user.setClave(row.getString(2));
                        user.setRol(row.getInt(3));
                        user.setIdbase(row.getInt(4));
                        user.setPersona(row.getInt(5));
                        GsonBuilder builder = new GsonBuilder().setLenient();
                        builder.registerTypeAdapter(Sincronizacion.class,new ResponseSerializer());
                        API.retrofit = null;
                        Service serv = API.getAPI(builder).create(Service.class);
                        Gson gson = new Gson();
                        String json = "["+gson.toJson(user)+"]";
                        Log.e("JSON","el json es "+json);
                        Call<Sincronizacion> datos = serv.setUsuario(json);
                        datos.enqueue(new Callback<Sincronizacion>() {
                            @Override
                            public void onResponse(Call<Sincronizacion> call, Response<Sincronizacion> response) {
                                if (response.isSuccessful()){
                                    UsuarioDao dao = new UsuarioDao();
                                    Sincronizacion sin = response.body();
                                    dao.update_idbase_Usuario(user.getIdusuario(),sin.getId(),SincronizacionActivity.this);
                                    Toast.makeText(SincronizacionActivity.this,"Se ha actualizado de forma correcta",Toast.LENGTH_SHORT).show();
                                }
                            }

                            @Override
                            public void onFailure(Call<Sincronizacion> call, Throwable t) {
                                Toast.makeText(SincronizacionActivity.this,"OCURRIO UN ERROR",Toast.LENGTH_SHORT).show();
                                t.printStackTrace();
                            }
                        });
                    }while (row.moveToNext());
                }


                row = db.rawQuery("SELECT * FROM detalle_equipo where estado = 'ACTIVO'",null);
                if(row.moveToFirst()){
                    do {
                        final DetalleEquipo detalle = new DetalleEquipo();
                        detalle.setIddetalle_equipo(row.getInt(0));
                        detalle.setId_base(row.getInt(1));
                        detalle.setIdequipo(row.getInt(2));
                        detalle.setIdcomercio(row.getInt(3));
                        GsonBuilder builder = new GsonBuilder().setLenient();
                        builder.registerTypeAdapter(Sincronizacion.class,new ResponseSerializer());
                        API.retrofit = null;
                        Service serv = API.getAPI(builder).create(Service.class);
                        Gson gson = new Gson();
                        String json = "["+gson.toJson(detalle)+"]";
                        Log.e("JSON","el json es "+json);
                        Call<Sincronizacion> data = serv.setDetalle(json);
                        data.enqueue(new Callback<Sincronizacion>() {
                            @Override
                            public void onResponse(Call<Sincronizacion> call, Response<Sincronizacion> response) {
                                if (response.isSuccessful()){
                                    DetalleEquipoDao dao = new DetalleEquipoDao();
                                    Sincronizacion sin = response.body();
                                    if(sin.getId()!=0){
                                        dao.update_idbase(detalle.getIddetalle_equipo(),sin.getId(),SincronizacionActivity.this);
                                        Toast.makeText(SincronizacionActivity.this,"Se ha actualizado de forma correcta",Toast.LENGTH_SHORT).show();
                                    }else{
                                        Toast.makeText(SincronizacionActivity.this,"No ha actualizado de forma correcta",Toast.LENGTH_SHORT).show();
                                        Intent intent = new Intent(SincronizacionActivity.this, Listar_Detalle_equipo.class);
                                        startActivity(intent);
                                        finish();
                                    }
                                }
                            }

                            @Override
                            public void onFailure(Call<Sincronizacion> call, Throwable t) {
                                Toast.makeText(SincronizacionActivity.this,"OCURRIO UN ERROR",Toast.LENGTH_SHORT).show();
                                t.printStackTrace();
                            }
                        });
                    }while (row.moveToNext());
                }






            }
        });








    }
}
