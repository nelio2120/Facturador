package com.example.facturador.Activity.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.facturador.Activity.Adapter.UsuarioAdapter;
import com.example.facturador.Activity.DAO.UsuarioDao;
import com.example.facturador.Activity.Model.Usuarios;
import com.example.facturador.R;
import com.example.facturador.SincronizacionActivity;

import java.util.ArrayList;
import java.util.List;

public class Listar_activity_Usuario extends AppCompatActivity {
    ListView lista;
    UsuarioAdapter adapter;
    List<Usuarios> lista_usuarios;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar__usuario);

        lista = (ListView)findViewById(R.id.listview_usuarios);
        lista_usuarios = new ArrayList<>();
        UsuarioDao crud = new UsuarioDao();
        lista_usuarios = crud.listar_usuario(Listar_activity_Usuario.this);
        adapter = new UsuarioAdapter(Listar_activity_Usuario.this,lista_usuarios);
        lista.setAdapter(adapter);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Usuarios obj = lista_usuarios.get(position);
                Intent intent = new Intent(Listar_activity_Usuario.this,UpdateUsuarioActivity.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("usuarios",obj);
                intent.putExtras(bundle);
                startActivity(intent);
                finish();

            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_main,menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item){
        switch (item.getItemId()){
            case R.id.crear_user_item:
                Intent intent3 = new Intent(Listar_activity_Usuario.this,Crear_Usuario_Acticity.class);
                startActivity(intent3);
                finish();
                return true;

            case R.id.sincronizar_item:
                Intent intent2 = new Intent(Listar_activity_Usuario.this, SincronizacionActivity.class);
                startActivity(intent2);
                finish();
                return true;
            case R.id.asignar_item:
                Intent item4 = new Intent(Listar_activity_Usuario.this, Listar_Detalle_equipo.class);
                startActivity(item4);
                finish();
                return true;

            default:
                return super.onOptionsItemSelected(item);

        }

    }

}
