package com.example.facturador.Activity.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.facturador.Activity.DAO.UsuarioDao;
import com.example.facturador.Activity.Model.Usuarios;
import com.example.facturador.R;
import com.example.facturador.SincronizacionActivity;

public class Crear_Usuario_Acticity extends AppCompatActivity {
    Button btn_registrar;
    EditText usuario,clave,confclave,rol,persona;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear__usuario);

        btn_registrar = (Button) findViewById(R.id.btn_guardar_usuario);
        usuario = (EditText) findViewById(R.id.editUsuario);
        clave = (EditText) findViewById(R.id.editClave);
        confclave = (EditText) findViewById(R.id.editConfClave);
        rol = (EditText) findViewById(R.id.edit_Rol);
        persona = (EditText) findViewById(R.id.editPersona);

        btn_registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Usuarios user = new Usuarios();
                user.setIdusuario(0);
                user.setUsuario(usuario.getText().toString());
                user.setClave(clave.getText().toString());
                user.setRol(Integer.valueOf(rol.getText().toString()));
                user.setPersona(Integer.valueOf(persona.getText().toString()));
                Log.e("PERSONA","EL VALOR DE PERSONA"+persona.getText().toString());
                UsuarioDao dao = new UsuarioDao();
                if(confclave.getText().toString().equals(clave.getText().toString())){
                    dao.guardar_Uuario(user,Crear_Usuario_Acticity.this);
                    Intent intent = new Intent(Crear_Usuario_Acticity.this, Listar_activity_Usuario.class);
                    startActivity(intent);
                    finish();
                }else{
                    Toast.makeText(Crear_Usuario_Acticity.this,"NO COINCIDEN",Toast.LENGTH_SHORT).show();
                }
            }
        });



    }
}
