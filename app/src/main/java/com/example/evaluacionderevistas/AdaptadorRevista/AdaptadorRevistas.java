package com.example.evaluacionderevistas.AdaptadorRevista;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.evaluacionderevistas.R;
import com.example.evaluacionderevistas.Revista.Revista;

import java.util.ArrayList;


public class AdaptadorRevistas extends ArrayAdapter<Revista> {

    public AdaptadorRevistas(Context context, ArrayList<Revista> datos) {
        super(context, R.layout.lylistarevista, datos);
    }
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View item = inflater.inflate(R.layout.lylistarevista, null);
        TextView lblTitulo = (TextView)item.findViewById(R.id.lblNombre);
        lblTitulo.setText(getItem(position).getJournal_id());
        TextView lblSubtitulo = (TextView)item.findViewById(R.id.lblEmail);
        lblSubtitulo.setText(getItem(position).getName());
        TextView lblWeb = (TextView)item.findViewById(R.id.lblweb);
        lblWeb.setText(getItem(position).getAbbreviation());

        ImageView imageView = (ImageView) item.findViewById(R.id.imgUsr);
        Glide.with(this.getContext())
                .load(getItem(position).getPortada()).into(imageView);

        return(item);
    }

}
