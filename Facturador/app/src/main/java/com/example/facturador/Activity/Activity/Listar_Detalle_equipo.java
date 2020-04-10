package com.example.facturador.Activity.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ListView;

import com.example.facturador.Activity.Adapter.DetalleAdapter;
import com.example.facturador.Activity.Adapter.UsuarioAdapter;
import com.example.facturador.Activity.DAO.DetalleEquipoDao;
import com.example.facturador.Activity.Model.DetalleEquipo;
import com.example.facturador.Activity.Model.Usuarios;
import com.example.facturador.R;
import com.example.facturador.SincronizacionActivity;

import java.util.ArrayList;
import java.util.List;

public class Listar_Detalle_equipo extends AppCompatActivity {
    ListView lista;
    DetalleAdapter adapter;
    ArrayList<DetalleEquipo> lista_detalle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar__detalle_equipo);

        lista = (ListView)findViewById(R.id.listview_detalle);
        lista_detalle = new ArrayList<>();
        DetalleEquipoDao dao = new DetalleEquipoDao();
        lista_detalle = dao.listar_DETALLE(Listar_Detalle_equipo.this);
        adapter = new DetalleAdapter(Listar_Detalle_equipo.this,lista_detalle);
        lista.setAdapter(adapter);



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
                Intent intent3 = new Intent(Listar_Detalle_equipo.this,Crear_Usuario_Acticity.class);
                startActivity(intent3);
                finish();
                return true;

            case R.id.sincronizar_item:
                Intent intent2 = new Intent(Listar_Detalle_equipo.this, SincronizacionActivity.class);
                startActivity(intent2);
                finish();
                return true;
            case R.id.asignar_item:
                Intent item4 = new Intent(Listar_Detalle_equipo.this, activity_asignacion.class);
                startActivity(item4);
                finish();
                return true;

            default:
                return super.onOptionsItemSelected(item);

        }

    }
}
