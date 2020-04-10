package com.example.facturador.Activity.Activity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.icu.text.StringSearch;
import android.os.Bundle;

import com.example.facturador.Activity.DAO.ComercioDao;
import com.example.facturador.Activity.DAO.DetalleEquipoDao;
import com.example.facturador.Activity.DAO.EquipoDao;
import com.example.facturador.Activity.Database.DbMedianet;
import com.example.facturador.Activity.Model.Comercio;
import com.example.facturador.Activity.Model.DetalleEquipo;
import com.example.facturador.Activity.Model.Equipo;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.facturador.R;

import java.util.ArrayList;

public class activity_asignacion extends AppCompatActivity {
    ArrayList<String> comerciol;
    ArrayList<Comercio> comercio;
    ArrayList<String> equipol;
    ArrayList<Equipo> equipo;

    Button btn_asignar,btn_Cancelar;
    Spinner editComercio,editequipo;
    TextView tcomercio,tequipo,etActivityComercio,etActivityEquipo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asignacion);

        consultarComercio();
        consultarEquipo();

        editComercio =(Spinner)findViewById(R.id.editComercio);
        editequipo =(Spinner)findViewById(R.id.editequipo);
        btn_asignar =(Button)findViewById(R.id.btn_asignar);
        btn_Cancelar =(Button)findViewById(R.id.btn_Cancelar);
        tcomercio= (TextView)findViewById(R.id.tcomercio) ;
        tequipo= (TextView)findViewById(R.id.tequipo) ;
        etActivityComercio = (TextView)findViewById(R.id.etActivityComercio) ;
        etActivityEquipo = (TextView)findViewById(R.id.etActivityEquipo) ;
        ArrayAdapter<CharSequence> adaptador = new ArrayAdapter(activity_asignacion.this,android.R.layout.simple_spinner_item,comerciol);
        ArrayAdapter<CharSequence> adaptadorAct = new ArrayAdapter(activity_asignacion.this,android.R.layout.simple_spinner_item,equipol);
        editComercio.setAdapter(adaptadorAct);
        editequipo.setAdapter(adaptador);



        btn_asignar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DetalleEquipo detalle = new DetalleEquipo();
                detalle.setIdcomercio(Integer.valueOf(tcomercio.getText().toString()));
                detalle.setIdequipo(Integer.valueOf(tequipo.getText().toString()));
                DetalleEquipoDao dao = new DetalleEquipoDao();
                dao.guardar_DetalleEquipo(detalle,activity_asignacion.this);
                Toast.makeText(activity_asignacion.this,"BUENAS TARDES MEDIANET",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(activity_asignacion.this,Listar_activity_Usuario.class);
                startActivity(intent);
                finish();
            }
        });

       editComercio.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
           @Override
           public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
               if(position!=0){
                   tcomercio.setText(String.valueOf(comercio.get(position-1).getIdcomercio()));
                   etActivityComercio.setText(String.valueOf(comercio.get(position-1).getNombre_comercial()));
               }else  {
                   tcomercio.setText("");
                   etActivityComercio.setText("");
               }
           }
           @Override
           public void onNothingSelected(AdapterView<?> parent) {

           }
       });


        editequipo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position!=0){
                    tequipo.setText(String.valueOf(equipo.get(position-1).getIdequipo()));
                    etActivityEquipo.setText(String.valueOf(equipo.get(position-1).getSerie()));
                }else  {
                    tequipo.setText("");
                    etActivityEquipo.setText("");
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private void consultarComercio(){
        DbMedianet con = new DbMedianet(activity_asignacion.this,"medianet",null,1);
        SQLiteDatabase db = con.getWritableDatabase();
        comercio = new ArrayList<Comercio>();
        ComercioDao dao = new ComercioDao();
        comercio = dao.listar_COMERCIO(activity_asignacion.this);
        Log.e("COMERCIO: ","esta es el listado de COMERCIOS "+comercio.get(1).getIdcomercio());
        obtenerlistaComercio();
    }
    private void obtenerlistaComercio() {

        comerciol = new ArrayList<String>();
        comerciol.add("Seleccione");
        for (int i = 0; i<comercio.size();i++ ){
            comerciol.add("Nombre: "+comercio.get(i).getNombre_comercial());
        }
    }
    private void consultarEquipo(){
        DbMedianet con = new DbMedianet(activity_asignacion.this,"medianet",null,1);
        SQLiteDatabase db = con.getWritableDatabase();
        equipo = new ArrayList<Equipo>();
        EquipoDao dao = new EquipoDao();
        equipo = dao.listar_EQUIPO(activity_asignacion.this);
        Log.e("EQUIPO: ","esta es el listado de EQUIPOS "+equipo.get(1).getIdequipo());
        obtenerlistaEquipo();
    }
    private void obtenerlistaEquipo() {

        equipol = new ArrayList<String>();
        equipol.add("Seleccione");
        for (int i = 0; i<equipo.size();i++ ){
            equipol.add("Nombre: "+equipo.get(i).getSerie());
        }
    }
}
