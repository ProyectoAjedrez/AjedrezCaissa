package com.telefonica.first.tableroprueba;


import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;


public class AdaptadorEjercicios extends ArrayAdapter {

    Ejercicio [] ejercicios;

    public AdaptadorEjercicios(Context context, int textViewResourceId, Ejercicio [] ejercicios) {
        super(context, textViewResourceId, ejercicios);
      this.ejercicios = ejercicios;
    }

    @Override
    public int getCount() {
        return super.getCount();
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    private void cargarFondo(TextView textView,int color){

        int sdk = android.os.Build.VERSION.SDK_INT;
        if(sdk < android.os.Build.VERSION_CODES.JELLY_BEAN) {
            textView.setBackgroundDrawable(getContext().getResources().getDrawable(color));
        } else {
            textView.setBackground(getContext().getResources().getDrawable(color));
        }
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View v = convertView;
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        v = inflater.inflate(R.layout.elementos_ejercicio, null);
        TextView textView = (TextView) v.findViewById(R.id.nivel);
        textView.setText(String.valueOf(ejercicios[position].getNivel()));
        switch (ejercicios[position].getEstado()){
            case "sin-empezar":
                cargarFondo(textView,R.drawable.sinempezar);
                break;
            case "empezada":
                cargarFondo(textView,R.drawable.empezado);
            break;
            case "terminada":
                cargarFondo(textView,R.drawable.terminado);
                break;

            default:
                break;
        }
        return v;

    }

}