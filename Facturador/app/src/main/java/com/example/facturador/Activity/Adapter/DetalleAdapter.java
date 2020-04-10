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
import com.example.facturador.Activity.Model.DetalleEquipo;
import com.example.facturador.Activity.Model.Usuarios;
import com.example.facturador.R;

import java.util.List;

public class DetalleAdapter extends BaseAdapter {
    Context context;
    List<DetalleEquipo> listauser;

    public DetalleAdapter(Context context, List<DetalleEquipo> listauser) {
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
        View v = View.inflate(context, R.layout.layout_detalle_item,null);
        TextView usuario = (TextView) v.findViewById(R.id.equipo_item);
        TextView idrol = (TextView) v.findViewById(R.id.comercio_item);
        DbMedianet admin = new DbMedianet(context,"medianet",null,1);
        SQLiteDatabase db = admin.getWritableDatabase();
        Cursor cursor = db.rawQuery("select modelo from equipo where idequipo="+listauser.get(position).getIdequipo(),null);
        if(cursor.moveToFirst()){
            Log.e("ERROR","ERROR EN LA CONSUKTA "+cursor.getInt(0));
            usuario.setText(String.valueOf(cursor.getString(0)));
            cursor = db.rawQuery("select nombre_comercial from comercio where idcomercio="+listauser.get(position).getIdcomercio(),null);
            if (cursor.moveToFirst()){
                idrol.setText(String.valueOf(cursor.getString(0)));
            }else{
                Log.e("ERROR","ERROR EN LA CONSUKTA");
            }
        }else{
            Log.e("ERROR","ERROR EN LA CONSUKTA");
        }
        return v;
    }
}
