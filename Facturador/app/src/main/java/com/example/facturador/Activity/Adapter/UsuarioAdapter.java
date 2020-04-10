package com.example.facturador.Activity.Adapter;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.facturador.Activity.Database.DbMedianet;
import com.example.facturador.Activity.Model.Usuarios;
import com.example.facturador.R;

import java.util.List;

public class UsuarioAdapter extends BaseAdapter {
    Context context;
    List<Usuarios> listauser;


    public UsuarioAdapter(Context context, List<Usuarios> listauser) {
        this.context = context;
        this.listauser = listauser;
    }

    @Override
    public int getCount() {
        return listauser.size();
    }

    @Override
    public Object getItem(int position) {
        return listauser.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = View.inflate(context, R.layout.layout_imten_usuarios,null);
        TextView usuario = (TextView) v.findViewById(R.id.cedula_usu_item);

        TextView idpersona = (TextView) v.findViewById(R.id.apellido_usu_item);
        DbMedianet admin = new DbMedianet(context,"medianet",null,1);
        SQLiteDatabase db = admin.getWritableDatabase();
        Cursor row = db.rawQuery("Select * from persona where idpersona="+listauser.get(position).getPersona(),null);
        usuario.setText(listauser.get(position).getUsuario().toString());
        if (row.moveToFirst())
        {
            idpersona.setText(String.valueOf(row.getString(1)));
        }else{
            Log.e("ERROR","ERROR EN LA CONSUKTA usuario");
        }


        return v;
    }
}
