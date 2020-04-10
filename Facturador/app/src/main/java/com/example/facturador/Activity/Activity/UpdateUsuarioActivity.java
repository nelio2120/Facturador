package com.example.facturador.Activity.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.facturador.Activity.DAO.PersonaDao;
import com.example.facturador.Activity.DAO.RolDao;
import com.example.facturador.Activity.DAO.UsuarioDao;
import com.example.facturador.Activity.Database.DbMedianet;
import com.example.facturador.Activity.Model.Persona;
import com.example.facturador.Activity.Model.Rol;
import com.example.facturador.Activity.Model.Usuarios;
import com.example.facturador.R;
import com.example.facturador.SincronizacionActivity;

import java.util.ArrayList;
import java.util.List;

public class UpdateUsuarioActivity extends AppCompatActivity {
    Button btn_registrar,btn_eliminar;
    EditText usuario,clave,confclave;
    Spinner rol,persona;
    Usuarios obj_usuario;
    List<Persona> dataActividad;
    ArrayList<String> lstActividad;
    List<Rol> dataRol;
    ArrayList<String> listRol;
    TextView idpersona,idrol,rolactivity,personaActivity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_usuario);

        final Bundle bundle = getIntent().getExtras();
        obj_usuario = new Usuarios();

        if (bundle != null){
            obj_usuario = (Usuarios) bundle.getSerializable("usuarios");
        }

        btn_registrar = (Button) findViewById(R.id.btn_editar_usuario);
        usuario = (EditText) findViewById(R.id.editUsuario);
        clave = (EditText) findViewById(R.id.editClave);
        confclave = (EditText) findViewById(R.id.editConfClave);
        rol = (Spinner) findViewById(R.id.edit_Rol);
        persona = (Spinner) findViewById(R.id.editPersona);
        idpersona = (TextView)findViewById(R.id.etaidpersona);
        idrol = (TextView)findViewById(R.id.etaidrol);
        rolactivity = (TextView)findViewById(R.id.etActivityRol);
        personaActivity = (TextView)findViewById(R.id.etActivityPersona);


        usuario.setText(obj_usuario.getUsuario());
        clave.setText(obj_usuario.getClave());
        consultarPersonas();
        consultarRoles();
        ArrayAdapter<CharSequence> adaptador = new ArrayAdapter(UpdateUsuarioActivity.this,android.R.layout.simple_spinner_item,lstActividad);
        ArrayAdapter<CharSequence> adaptadorAct = new ArrayAdapter(UpdateUsuarioActivity.this,android.R.layout.simple_spinner_item,listRol);
        rol.setAdapter(adaptadorAct);
        persona.setAdapter(adaptador);

























        rol.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position!=0){
                    idrol.setText(String.valueOf(dataRol.get(position-1).getIdrol()));
                    rolactivity.setText(String.valueOf("Nombre: "+dataRol.get(position-1).getNombre()));
                }else{
                    idrol.setText("");
                    rolactivity.setText("");
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        persona.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position!=0){
                    idpersona.setText(String.valueOf(dataActividad.get(position-1).getIdpersona()));
                    personaActivity.setText(String.valueOf("Nombre: "+dataActividad.get(position-1).getNombre()));
                }else{
                    idpersona.setText("");
                    personaActivity.setText("");
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        btn_eliminar = (Button)findViewById(R.id.btn_editar_usuario);
        btn_eliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id = obj_usuario.getIdusuario();
                UsuarioDao dao = new UsuarioDao();
                dao.Eliminar_usuario(id,UpdateUsuarioActivity.this);
                Intent intent = new Intent(UpdateUsuarioActivity.this, Listar_activity_Usuario.class);
                startActivity(intent);
                finish();
            }
        });

        btn_registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Usuarios user = new Usuarios();
                user.setIdusuario(obj_usuario.getIdusuario());
                user.setUsuario(usuario.getText().toString());
                user.setClave(clave.getText().toString());
                user.setRol(Integer.valueOf(idrol.getText().toString()));
                user.setPersona(Integer.valueOf(idpersona.getText().toString()));
                UsuarioDao dao = new UsuarioDao();
                if(confclave.getText().toString().equals(clave.getText().toString())){
                    dao.editar_usuario(user,UpdateUsuarioActivity.this);
                    Intent intent = new Intent(UpdateUsuarioActivity.this, Listar_activity_Usuario.class);
                    startActivity(intent);
                    finish();
                }else{
                    Toast.makeText(UpdateUsuarioActivity.this,"NO COINCIDEN",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


    private void consultarPersonas(){
        DbMedianet con = new DbMedianet(UpdateUsuarioActivity.this,"medianet",null,1);
        SQLiteDatabase db = con.getWritableDatabase();

        dataActividad = new ArrayList<Persona>();
        PersonaDao dao = new PersonaDao();
        dataActividad = dao.listar_persona(UpdateUsuarioActivity.this);
        Log.e("Persona: ","esta es el listado de roles "+dataActividad.get(1).getNombre());
        obtenerListaActividad();
    }
    private void consultarRoles(){
        DbMedianet con = new DbMedianet(UpdateUsuarioActivity.this,"medianet",null,1);
        SQLiteDatabase db = con.getWritableDatabase();
        dataRol = new ArrayList<Rol>();
        RolDao dao = new RolDao(UpdateUsuarioActivity.this);
        dataRol = dao.listar_todo();
        Log.e("ROLES: ","esta es el listado de roles "+dataRol.get(1).getNombre());
        obtenerListaRol();
    }
    public void obtenerListaActividad(){
        lstActividad = new ArrayList<String>();
        lstActividad.add("Seleccione");
        for (int i = 0; i<dataActividad.size();i++ ){
            lstActividad.add("Persona: " +dataActividad.get(i).getNombre()+ " Apellidoa:"+dataActividad.get(i).getApellido());
        }
    }
    public void obtenerListaRol(){
        listRol = new ArrayList<String>();
        listRol.add("Seleccione");
        for (int i = 0; i<dataRol.size();i++ ){
            listRol.add("Nombre: " +dataRol.get(i).getNombre());
        }
    }

}
