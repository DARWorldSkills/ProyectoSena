package com.davidpopayan.sena.myapplication.Especializacion;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.davidpopayan.sena.myapplication.Modelo.GestorBD;
import com.davidpopayan.sena.myapplication.R;

public class especializacion extends AppCompatActivity {
    TextView txtcampo16lunes,txtcampo17lunes,txtcampo18lunes,txtcampo19lunes,txtcampo20lunes;
    TextView txtcampo16martes,txtcampo17martes,txtcampo18martes,txtcampo19martes,txtcampo20martes;
    TextView txtcampo16miercoles,txtcampo17miercoles,txtcampo18miercoles,txtcampo19miercoles,txtcampo20miercoles;
    TextView txtcampo16jueves,txtcampo17jueves,txtcampo18jueves,txtcampo19jueves,txtcampo20jueves;
    TextView txtcampo16viernes,txtcampo17viernes,txtcampo18viernes,txtcampo19viernes,txtcampo20viernes;
    TextView txtcampo16sabado,txtcampo17sabado,txtcampo18sabado,txtcampo19sabado,txtcampo20sabado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_especializacion);
        inicializartabla();
        listartabla();
    }

    public void enviar3(View view) {
        Intent intent = new Intent(especializacion.this, infoespeci.class);
        startActivity(intent);

    }

    public void inicializartabla(){
        txtcampo16lunes= findViewById(R.id.campo16lunes);
        txtcampo17lunes= findViewById(R.id.campo17lunes);
        txtcampo18lunes= findViewById(R.id.campo18lunes);
        txtcampo19lunes= findViewById(R.id.campo19lunes);
        txtcampo20lunes= findViewById(R.id.campo20lunes);

        txtcampo16martes= findViewById(R.id.campo16martes);
        txtcampo17martes= findViewById(R.id.campo17martes);
        txtcampo18martes= findViewById(R.id.campo18martes);
        txtcampo19martes= findViewById(R.id.campo19martes);
        txtcampo20martes= findViewById(R.id.campo20martes);

        txtcampo16miercoles= findViewById(R.id.campo16miercoles);
        txtcampo17miercoles= findViewById(R.id.campo17miercoles);
        txtcampo18miercoles= findViewById(R.id.campo18miercoles);
        txtcampo19miercoles= findViewById(R.id.campo19miercoles);
        txtcampo20miercoles= findViewById(R.id.campo20miercoles);

        txtcampo16jueves= findViewById(R.id.campo16jueves);
        txtcampo17jueves= findViewById(R.id.campo17jueves);
        txtcampo18jueves= findViewById(R.id.campo18jueves);
        txtcampo19jueves= findViewById(R.id.campo19jueves);
        txtcampo20jueves= findViewById(R.id.campo20jueves);

        txtcampo16viernes= findViewById(R.id.campo16viernes);
        txtcampo17viernes= findViewById(R.id.campo17viernes);
        txtcampo18viernes= findViewById(R.id.campo18viernes);
        txtcampo19viernes= findViewById(R.id.campo19viernes);
        txtcampo20viernes= findViewById(R.id.campo20viernes);

        txtcampo16sabado= findViewById(R.id.campo16sabado);
        txtcampo17sabado= findViewById(R.id.campo17sabado);
        txtcampo18sabado= findViewById(R.id.campo18sabado);
        txtcampo19sabado= findViewById(R.id.campo19sabado);
        txtcampo20sabado= findViewById(R.id.campo20sabado);

    }

    public void listartabla(){
        GestorBD gestorBD = new GestorBD(this);
        SQLiteDatabase db = gestorBD.getReadableDatabase();

        txtcampo16lunes.setText(db.rawQuery("SELECT INSTRUCTOR FROM HORARIO WHERE JORNADA = 2 AND DIA = 'Lunes' AND HORA = '19-20' ;",null).toString());
        txtcampo17lunes.setText(db.rawQuery("SELECT INSTRUCTOR FROM HORARIO WHERE JORNADA = 2 AND DIA = 'Lunes' AND HORA = '20-21' ;",null).toString());
        txtcampo18lunes.setText(db.rawQuery("SELECT INSTRUCTOR FROM HORARIO WHERE JORNADA = 2 AND DIA = 'Lunes' AND HORA = '21-22' ;",null).toString());
        txtcampo19lunes.setText(db.rawQuery("SELECT INSTRUCTOR FROM HORARIO WHERE JORNADA = 2 AND DIA = 'Lunes' AND HORA = '22-23' ;",null).toString());
        txtcampo20lunes.setText(db.rawQuery("SELECT INSTRUCTOR FROM HORARIO WHERE JORNADA = 2 AND DIA = 'Lunes' AND HORA = '23-0' ;",null).toString());

        txtcampo16martes.setText(db.rawQuery("SELECT INSTRUCTOR FROM HORARIO WHERE JORNADA = 2 AND DIA = 'Martes' AND HORA = '19-20' ;",null).toString());
        txtcampo17martes.setText(db.rawQuery("SELECT INSTRUCTOR FROM HORARIO WHERE JORNADA = 2 AND DIA = 'Martes' AND HORA = '20-21' ;",null).toString());
        txtcampo18martes.setText(db.rawQuery("SELECT INSTRUCTOR FROM HORARIO WHERE JORNADA = 2 AND DIA = 'Martes' AND HORA = '21-22' ;",null).toString());
        txtcampo19martes.setText(db.rawQuery("SELECT INSTRUCTOR FROM HORARIO WHERE JORNADA = 2 AND DIA = 'Martes' AND HORA = '22-23' ;",null).toString());
        txtcampo20martes.setText(db.rawQuery("SELECT INSTRUCTOR FROM HORARIO WHERE JORNADA = 2 AND DIA = 'Martes' AND HORA = '23-0' ;",null).toString());

        txtcampo16miercoles.setText(db.rawQuery("SELECT INSTRUCTOR FROM HORARIO WHERE JORNADA = 2 AND DIA = 'Miercoles' AND HORA = '19-20' ;",null).toString());
        txtcampo17miercoles.setText(db.rawQuery("SELECT INSTRUCTOR FROM HORARIO WHERE JORNADA = 2 AND DIA = 'Miercoles' AND HORA = '20-21' ;",null).toString());
        txtcampo18miercoles.setText(db.rawQuery("SELECT INSTRUCTOR FROM HORARIO WHERE JORNADA = 2 AND DIA = 'Miercoles' AND HORA = '21-22' ;",null).toString());
        txtcampo19miercoles.setText(db.rawQuery("SELECT INSTRUCTOR FROM HORARIO WHERE JORNADA = 2 AND DIA = 'Miercoles' AND HORA = '22-23' ;",null).toString());
        txtcampo20miercoles.setText(db.rawQuery("SELECT INSTRUCTOR FROM HORARIO WHERE JORNADA = 2 AND DIA = 'Miercoles' AND HORA = '23-0' ;",null).toString());

        txtcampo16jueves.setText(db.rawQuery("SELECT INSTRUCTOR FROM HORARIO WHERE JORNADA = 2 AND DIA = 'Jueves' AND HORA = '19-20' ;",null).toString());
        txtcampo17jueves.setText(db.rawQuery("SELECT INSTRUCTOR FROM HORARIO WHERE JORNADA = 2 AND DIA = 'Jueves' AND HORA = '20-21' ;",null).toString());
        txtcampo18jueves.setText(db.rawQuery("SELECT INSTRUCTOR FROM HORARIO WHERE JORNADA = 2 AND DIA = 'Jueves' AND HORA = '21-22' ;",null).toString());
        txtcampo19jueves.setText(db.rawQuery("SELECT INSTRUCTOR FROM HORARIO WHERE JORNADA = 2 AND DIA = 'Jueves' AND HORA = '22-23' ;",null).toString());
        txtcampo20jueves.setText(db.rawQuery("SELECT INSTRUCTOR FROM HORARIO WHERE JORNADA = 2 AND DIA = 'Jueves' AND HORA = '23-0' ;",null).toString());

        txtcampo16viernes.setText(db.rawQuery("SELECT INSTRUCTOR FROM HORARIO WHERE JORNADA = 2 AND DIA = 'Viernes' AND HORA = '19-20' ;",null).toString());
        txtcampo17viernes.setText(db.rawQuery("SELECT INSTRUCTOR FROM HORARIO WHERE JORNADA = 2 AND DIA = 'Viernes' AND HORA = '20-21' ;",null).toString());
        txtcampo18viernes.setText(db.rawQuery("SELECT INSTRUCTOR FROM HORARIO WHERE JORNADA = 2 AND DIA = 'Viernes' AND HORA = '21-22' ;",null).toString());
        txtcampo19viernes.setText(db.rawQuery("SELECT INSTRUCTOR FROM HORARIO WHERE JORNADA = 2 AND DIA = 'Viernes' AND HORA = '22-23' ;",null).toString());
        txtcampo20viernes.setText(db.rawQuery("SELECT INSTRUCTOR FROM HORARIO WHERE JORNADA = 2 AND DIA = 'Viernes' AND HORA = '23-0' ;",null).toString());

        txtcampo16sabado.setText(db.rawQuery("SELECT INSTRUCTOR FROM HORARIO WHERE JORNADA = 2 AND DIA = 'Sábado' AND HORA = '19-20' ;",null).toString());
        txtcampo17sabado.setText(db.rawQuery("SELECT INSTRUCTOR FROM HORARIO WHERE JORNADA = 2 AND DIA = 'Sábado' AND HORA = '20-21' ;",null).toString());
        txtcampo18sabado.setText(db.rawQuery("SELECT INSTRUCTOR FROM HORARIO WHERE JORNADA = 2 AND DIA = 'Sábado' AND HORA = '21-22' ;",null).toString());
        txtcampo19sabado.setText(db.rawQuery("SELECT INSTRUCTOR FROM HORARIO WHERE JORNADA = 2 AND DIA = 'Sábado' AND HORA = '22-23' ;",null).toString());
        txtcampo20sabado.setText(db.rawQuery("SELECT INSTRUCTOR FROM HORARIO WHERE JORNADA = 2 AND DIA = 'Sábado' AND HORA = '23-0' ;",null).toString());


    }




    public void back(View view) {
        finish();
    }
}
