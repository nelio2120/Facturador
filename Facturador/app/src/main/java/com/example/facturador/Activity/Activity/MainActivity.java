package com.example.facturador.Activity.Activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


import com.example.facturador.Activity.API.Desarializers.BancoDeserializer;
import com.example.facturador.Activity.API.Desarializers.CiudadDeserializer;
import com.example.facturador.Activity.API.Desarializers.ComercioDeserializers;
import com.example.facturador.Activity.API.Desarializers.EquipoDeserializer;
import com.example.facturador.Activity.API.Desarializers.EstatusDeserializers;
import com.example.facturador.Activity.API.Desarializers.PersonaDeserializer;
import com.example.facturador.Activity.API.Desarializers.ProvinciaDeserializer;
import com.example.facturador.Activity.API.Desarializers.RolDeserializer;
import com.example.facturador.Activity.API.Desarializers.UsuarioEnDeserializer;
import com.example.facturador.Activity.API.Services.Service;
import com.example.facturador.Activity.DAO.*;
import com.example.facturador.Activity.Database.*;
import com.example.facturador.Activity.Model.PersonaSerializer;
import com.example.facturador.Activity.Model.*;
import com.example.facturador.Activity.Model.RolSerializer;
import com.example.facturador.Activity.Model.UserDeserializer;
import com.example.facturador.R;
import com.example.facturador.SincronizacionActivity;
import com.google.gson.GsonBuilder;
import com.example.facturador.Activity.API.*;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    EditText etUsuario,etPass;
    Button btn_iniciar,btn_salir;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etUsuario = (EditText)findViewById(R.id.txt_usuario);
        etPass = (EditText)findViewById(R.id.txt_pass);
        btn_iniciar = (Button) findViewById(R.id.btnRegistro);
        btn_salir = (Button)findViewById(R.id.btn_salir);





        btn_iniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String Usuario = etUsuario.getText().toString();
                String Clave = etPass.getText().toString();
                DbMedianet admin = new DbMedianet(MainActivity.this,"medianet",null,1);
                final SQLiteDatabase db = admin.getWritableDatabase();
                Cursor row = db.rawQuery("select clave,idusuarios from usuarios where usuario='"+Usuario+"'",null);
                if(row.moveToFirst()){
                    if(Clave.equals(row.getString(0))){

                        Toast.makeText(MainActivity.this,"Usuario Registrado",Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(MainActivity.this, Listar_activity_Usuario.class);
                        startActivity(intent);
                        finish();
                    }else{
                        Toast.makeText(MainActivity.this,"Usuario o Contraseña Incorrecta",Toast.LENGTH_LONG).show();

                    }
                }else{
                    final GsonBuilder builder = new GsonBuilder().setLenient();
                    builder.registerTypeAdapter(UserDeserializer.class,new UsuarioEnDeserializer());
                    API.retrofit = null;
                    Service serv = API.getAPI(builder).create(Service.class);
                    Call<UserDeserializer> datos = serv.getUsuario(Usuario);
                    datos.enqueue(new Callback<UserDeserializer>() {
                        @Override
                        public void onResponse(Call<UserDeserializer> call, Response<UserDeserializer> response) {
                            Toast.makeText(MainActivity.this,"si pasa por falso",Toast.LENGTH_LONG).show();
                            if(response.isSuccessful()){
                                    builder.registerTypeAdapter(RolSerializer.class, new RolDeserializer());
                                    API.retrofit = null;
                                    Service serv = API.getAPI(builder).create(Service.class);
                                    Call<RolSerializer> data = serv.getRol();
                                    data.enqueue(new Callback<RolSerializer>() {
                                        @Override
                                        public void onResponse(Call<RolSerializer> call, Response<RolSerializer> response) {
                                            if (response.isSuccessful()) {
                                                RolSerializer roles = response.body();
                                                for (int i = 0; i < roles.getLrol().size(); i++) {
                                                    Log.e("ERROR DE ROLES","LO QUE TE ESTA TRAYENDO ES: "+response.body().getLrol().get(i).getNombre().toString());
                                                    RolDao roldao = new RolDao(MainActivity.this);
                                                    Rol rol = (Rol) roles.getLrol().get(i);
                                                    roldao.guardar_Rol(rol);
                                                }
                                            }
                                        }

                                        @Override
                                        public void onFailure(Call<RolSerializer> call, Throwable t) {
                                            Toast.makeText(MainActivity.this, "TIENES UN ERROR AL TRAER LOS DATOS ROLES", Toast.LENGTH_LONG).show();
                                            t.printStackTrace();
                                            Log.e("DATO","usuario pasa pro row");

                                        }
                                    });

                                        Toast.makeText(MainActivity.this, "ERROR LOGICO", Toast.LENGTH_LONG).show();
                                        Toast.makeText(MainActivity.this,"si pasa por falso persona",Toast.LENGTH_LONG).show();
                                        builder.registerTypeAdapter(PersonaSerializer.class, new PersonaDeserializer());
                                        API.retrofit = null;
                                        serv = API.getAPI(builder).create(Service.class);
                                        Call<PersonaSerializer> datos = serv.getPersona();
                                        datos.enqueue(new Callback<PersonaSerializer>() {
                                            @Override
                                            public void onResponse(Call<PersonaSerializer> call, Response<PersonaSerializer> response) {
                                                if(response.isSuccessful()){
                                                    PersonaSerializer persona_object = response.body();
                                                    for (int i = 0; i < persona_object.getLpersona().size(); i++) {
                                                        PersonaDao persona_dao = new PersonaDao();
                                                        persona_dao.guardar_Persona(persona_object.getLpersona().get(i), MainActivity.this);
                                                    }
                                                }
                                            }

                                            @Override
                                            public void onFailure(Call<PersonaSerializer> call, Throwable t) {
                                                Toast.makeText(MainActivity.this, "TIENES UN ERROR AL TRAER LOS DATOS PERSONA", Toast.LENGTH_LONG).show();
                                                t.printStackTrace();
                                                Log.e("DATO","usuario pasa pro row");

                                            }
                                        });
                                traer_dato();
                                        String Usuario = etUsuario.getText().toString();
                                        String Clave = etPass.getText().toString();
                                        UserDeserializer user = response.body();
                                        Log.e("error el lista","lo que traporque es "+response.raw().request().url());
                                        for (int i=0 ; i < user.getLuser().size();i++){
                                            if(Usuario.equals(user.getLuser().get(i).getUsuario())&& Clave.equals(user.getLuser().get(i).getClave())){
                                                UsuarioDao dao = new UsuarioDao();
                                                dao.guardar_Uuario(user.getLuser().get(i),MainActivity.this);
                                                Toast.makeText(MainActivity.this, "USUARIO LOGEADO", Toast.LENGTH_LONG).show();
                                                Intent intent = new Intent(MainActivity.this, Listar_activity_Usuario.class);
                                                startActivity(intent);
                                                finish();
                                            }
                                            else{
                                                Toast.makeText(MainActivity.this, "USUARIO NO LOGEADO", Toast.LENGTH_LONG).show();
                                            }
                                        }
                                    }
                                }
                        @Override
                        public void onFailure(Call<UserDeserializer> call, Throwable t) {
                            Toast.makeText(MainActivity.this, "Usuario no existente en la base de datso remota", Toast.LENGTH_LONG).show();
                            t.printStackTrace();
                        }
                    });
                }



            }
        });


    }
    public void traer_dato(){
        final GsonBuilder builder = new GsonBuilder().setLenient();
        builder.registerTypeAdapter(ComercioSerializable.class,new ComercioDeserializers());
        API.retrofit = null;
        Service serv = API.getAPI(builder).create(Service.class);
        Call<ComercioSerializable> data = serv.getComercio();
        data.enqueue(new Callback<ComercioSerializable>() {
            @Override
            public void onResponse(Call<ComercioSerializable> call, Response<ComercioSerializable> response) {
                if(response.isSuccessful()){
                    ComercioSerializable persona_object = response.body();
                    for (int i = 0; i < persona_object.getComercios().size(); i++) {
                        ComercioDao persona_dao = new ComercioDao();
                        persona_dao.guardar_comercio(persona_object.getComercios().get(i), MainActivity.this);
                    }
                }
            }

            @Override
            public void onFailure(Call<ComercioSerializable> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Usuario no existente en la base de datso remota", Toast.LENGTH_LONG).show();
                t.printStackTrace();
            }
        });

        builder.registerTypeAdapter(EstatusSerializable.class,new EstatusDeserializers());
        API.retrofit = null;
        serv = API.getAPI(builder).create(Service.class);
        Call<EstatusSerializable> dataserv = serv.getEstatus();
        dataserv.enqueue(new Callback<EstatusSerializable>() {
            @Override
            public void onResponse(Call<EstatusSerializable> call, Response<EstatusSerializable> response) {
                if(response.isSuccessful()){
                    EstatusSerializable persona_object = response.body();
                    for (int i = 0; i < persona_object.getEstatuses().size(); i++) {
                        EstatusDao persona_dao = new EstatusDao();
                        persona_dao.guardar_Estatus(persona_object.getEstatuses().get(i), MainActivity.this);
                    }
                }
            }

            @Override
            public void onFailure(Call<EstatusSerializable> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Usuario no existente en la base de datso remota", Toast.LENGTH_LONG).show();
                t.printStackTrace();
            }
        });

        builder.registerTypeAdapter(BancoSerializer.class,new BancoDeserializer());
        API.retrofit = null;
        serv = API.getAPI(builder).create(Service.class);
        Call<BancoSerializer> dataBanco = serv.getBanco();
        dataBanco.enqueue(new Callback<BancoSerializer>() {
            @Override
            public void onResponse(Call<BancoSerializer> call, Response<BancoSerializer> response) {
                if(response.isSuccessful()){
                    BancoSerializer persona_object = response.body();
                    for (int i = 0; i < persona_object.getBanco().size(); i++) {
                        BancoDao persona_dao = new BancoDao();
                        persona_dao.guardar_Banco(persona_object.getBanco().get(i), MainActivity.this);
                    }
                }
            }

            @Override
            public void onFailure(Call<BancoSerializer> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Usuario no existente en la base de datso remota", Toast.LENGTH_LONG).show();
                t.printStackTrace();
            }
        });

        builder.registerTypeAdapter(CiudadSerializable.class,new CiudadDeserializer());
        API.retrofit = null;
        serv = API.getAPI(builder).create(Service.class);
        Call<CiudadSerializable> dataCiudad = serv.getCiudad();
        dataCiudad.enqueue(new Callback<CiudadSerializable>() {
            @Override
            public void onResponse(Call<CiudadSerializable> call, Response<CiudadSerializable> response) {
                if(response.isSuccessful()){
                    CiudadSerializable persona_object = response.body();
                    for (int i = 0; i < persona_object.getCiudads().size(); i++) {
                        CiudadDao persona_dao = new CiudadDao();
                        persona_dao.guardar_Ciudad(persona_object.getCiudads().get(i), MainActivity.this);
                    }
                }
            }

            @Override
            public void onFailure(Call<CiudadSerializable> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Usuario no existente en la base de datso remota", Toast.LENGTH_LONG).show();
                t.printStackTrace();
            }
        });


        builder.registerTypeAdapter(ProvinciaSerializable.class,new ProvinciaDeserializer());
        API.retrofit = null;
        serv = API.getAPI(builder).create(Service.class);
        Call<ProvinciaSerializable> dataProvincia = serv.getProvincia();
        dataProvincia.enqueue(new Callback<ProvinciaSerializable>() {
            @Override
            public void onResponse(Call<ProvinciaSerializable> call, Response<ProvinciaSerializable> response) {
                if(response.isSuccessful()){
                    ProvinciaSerializable persona_object = response.body();
                    for (int i = 0; i < persona_object.getProvincias().size(); i++) {
                        ProvinciaDao persona_dao = new ProvinciaDao();
                        persona_dao.guardar_Provincia(persona_object.getProvincias().get(i), MainActivity.this);
                    }
                }
            }

            @Override
            public void onFailure(Call<ProvinciaSerializable> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Usuario no existente en la base de datso remota", Toast.LENGTH_LONG).show();
                t.printStackTrace();
            }
        });

        builder.registerTypeAdapter(EquipoSerializable.class,new EquipoDeserializer());
        API.retrofit = null;
        serv = API.getAPI(builder).create(Service.class);
        Call<EquipoSerializable> dataequipo = serv.getEquipo();
        dataequipo.enqueue(new Callback<EquipoSerializable>() {
            @Override
            public void onResponse(Call<EquipoSerializable> call, Response<EquipoSerializable> response) {
                if(response.isSuccessful()){
                    EquipoSerializable persona_object = response.body();
                    for (int i = 0; i < persona_object.getEquipos().size(); i++) {
                        EquipoDao persona_dao = new EquipoDao();
                        persona_dao.guardar_Equipo(persona_object.getEquipos().get(i), MainActivity.this);
                    }
                }
            }

            @Override
            public void onFailure(Call<EquipoSerializable> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Usuario no existente en la base de datso remota", Toast.LENGTH_LONG).show();
                t.printStackTrace();
            }
        });
    }
}
