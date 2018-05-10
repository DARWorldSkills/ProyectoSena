package com.davidpopayan.sena.myapplication.Videojuegos;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.davidpopayan.sena.myapplication.Modelo.GestorBD;
import com.davidpopayan.sena.myapplication.R;

import java.util.ArrayList;
import java.util.List;

public class play extends AppCompatActivity {
    TextView info;
    TextView txtcampo1lunes,txtcampo2lunes,txtcampo3lunes,txtcampo4lunes,txtcampo5lunes,txtcampo6lunes;
    TextView txtcampo1martes,txtcampo2martes,txtcampo3martes,txtcampo4martes,txtcampo5martes,txtcampo6martes;
    TextView txtcampo1miercoles,txtcampo2miercoles,txtcampo3miercoles,txtcampo4miercoles,txtcampo5miercoles,txtcampo6miercoles;
    TextView txtcampo1jueves,txtcampo2jueves,txtcampo3jueves,txtcampo4jueves,txtcampo5jueves,txtcampo6jueves;
    TextView txtcampo1viernes,txtcampo2viernes,txtcampo3viernes,txtcampo4viernes,txtcampo5viernes,txtcampo6viernes;
    TextView txtcampo1sabado,txtcampo2sabado,txtcampo3sabado,txtcampo4sabado,txtcampo5sabado,txtcampo6sabado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);

        info = findViewById(R.id.envio);

        inicializarTabla();
        listartabla();


    }


    public void inicializarTabla(){
        txtcampo1lunes= findViewById(R.id.campo1lunes);
        txtcampo2lunes= findViewById(R.id.campo2lunes);
        txtcampo3lunes= findViewById(R.id.campo3lunes);
        txtcampo4lunes= findViewById(R.id.campo4lunes);
        txtcampo5lunes= findViewById(R.id.campo5lunes);
        txtcampo6lunes= findViewById(R.id.campo6lunes);

        txtcampo1martes= findViewById(R.id.campo1martes);
        txtcampo2martes= findViewById(R.id.campo2martes);
        txtcampo3martes= findViewById(R.id.campo3martes);
        txtcampo4martes= findViewById(R.id.campo4martes);
        txtcampo5martes= findViewById(R.id.campo5martes);
        txtcampo6martes= findViewById(R.id.campo6martes);

        txtcampo1miercoles= findViewById(R.id.campo1miercoles);
        txtcampo2miercoles= findViewById(R.id.campo2miercoles);
        txtcampo3miercoles= findViewById(R.id.campo3miercoles);
        txtcampo4miercoles= findViewById(R.id.campo4miercoles);
        txtcampo5miercoles= findViewById(R.id.campo5miercoles);
        txtcampo6miercoles= findViewById(R.id.campo6miercoles);

        txtcampo1jueves= findViewById(R.id.campo1jueves);
        txtcampo2jueves= findViewById(R.id.campo2jueves);
        txtcampo3jueves= findViewById(R.id.campo3jueves);
        txtcampo4jueves= findViewById(R.id.campo4jueves);
        txtcampo5jueves= findViewById(R.id.campo5jueves);
        txtcampo6jueves= findViewById(R.id.campo6jueves);

        txtcampo1viernes= findViewById(R.id.campo1viernes);
        txtcampo2viernes= findViewById(R.id.campo2viernes);
        txtcampo3viernes= findViewById(R.id.campo3viernes);
        txtcampo4viernes= findViewById(R.id.campo4viernes);
        txtcampo5viernes= findViewById(R.id.campo5viernes);
        txtcampo6viernes= findViewById(R.id.campo6viernes);

        txtcampo1sabado= findViewById(R.id.campo1sabado);
        txtcampo2sabado= findViewById(R.id.campo2sabado);
        txtcampo3sabado= findViewById(R.id.campo3sabado);
        txtcampo4sabado= findViewById(R.id.campo4sabado);
        txtcampo5sabado= findViewById(R.id.campo5sabado);
        txtcampo6sabado= findViewById(R.id.campo6sabado);


    }

    public void enviar(View view) {
        Intent intent = new Intent(play.this, infoplay.class);
        startActivity(intent);

    }

    public void listartabla(){
        GestorBD gestorBD = new GestorBD(this);
        SQLiteDatabase db = gestorBD.getWritableDatabase();

        //Llendano lunes
        txtcampo1lunes.setText(db.rawQuery("SELECT INSTRUCTOR FROM HORARIO WHERE JORNADA = 1 AND DIA = 'Lunes' AND HORA = '7-8' ;",null).toString());
        txtcampo2lunes.setText(db.rawQuery("SELECT INSTRUCTOR FROM HORARIO WHERE JORNADA = 1 AND DIA = 'Lunes' AND HORA = '8-9' ;",null).toString());
        txtcampo3lunes.setText(db.rawQuery("SELECT INSTRUCTOR FROM HORARIO WHERE JORNADA = 1 AND DIA = 'Lunes' AND HORA = '9-10' ;",null).toString());
        txtcampo4lunes.setText(db.rawQuery("SELECT INSTRUCTOR FROM HORARIO WHERE JORNADA = 1 AND DIA = 'Lunes' AND HORA = '10-11' ;",null).toString());
        txtcampo5lunes.setText(db.rawQuery("SELECT INSTRUCTOR FROM HORARIO WHERE JORNADA = 1 AND DIA = 'Lunes' AND HORA = '11-12' ;",null).toString());
        txtcampo6lunes.setText(db.rawQuery("SELECT INSTRUCTOR FROM HORARIO WHERE JORNADA = 1 AND DIA = 'Lunes' AND HORA = '12-13' ;",null).toString());

        txtcampo1martes.setText(db.rawQuery("SELECT INSTRUCTOR FROM HORARIO WHERE JORNADA = 1 AND DIA = 'Martes' AND HORA = '7-8' ;",null).toString());
        txtcampo2martes.setText(db.rawQuery("SELECT INSTRUCTOR FROM HORARIO WHERE JORNADA = 1 AND DIA = 'Martes' AND HORA = '8-9' ;",null).toString());
        txtcampo3martes.setText(db.rawQuery("SELECT INSTRUCTOR FROM HORARIO WHERE JORNADA = 1 AND DIA = 'Martes' AND HORA = '9-10' ;",null).toString());
        txtcampo4martes.setText(db.rawQuery("SELECT INSTRUCTOR FROM HORARIO WHERE JORNADA = 1 AND DIA = 'Martes' AND HORA = '10-11' ;",null).toString());
        txtcampo5martes.setText(db.rawQuery("SELECT INSTRUCTOR FROM HORARIO WHERE JORNADA = 1 AND DIA = 'Martes' AND HORA = '11-12' ;",null).toString());
        txtcampo6martes.setText(db.rawQuery("SELECT INSTRUCTOR FROM HORARIO WHERE JORNADA = 1 AND DIA = 'Martes' AND HORA = '12-13' ;",null).toString());

        txtcampo1miercoles.setText(db.rawQuery("SELECT INSTRUCTOR FROM HORARIO WHERE JORNADA = 1 AND DIA = 'Miercoles' AND HORA = '7-8' ;",null).toString());
        txtcampo2miercoles.setText(db.rawQuery("SELECT INSTRUCTOR FROM HORARIO WHERE JORNADA = 1 AND DIA = 'Miercoles' AND HORA = '8-9' ;",null).toString());
        txtcampo3miercoles.setText(db.rawQuery("SELECT INSTRUCTOR FROM HORARIO WHERE JORNADA = 1 AND DIA = 'Miercoles' AND HORA = '9-10' ;",null).toString());
        txtcampo4miercoles.setText(db.rawQuery("SELECT INSTRUCTOR FROM HORARIO WHERE JORNADA = 1 AND DIA = 'Miercoles' AND HORA = '10-11' ;",null).toString());
        txtcampo5miercoles.setText(db.rawQuery("SELECT INSTRUCTOR FROM HORARIO WHERE JORNADA = 1 AND DIA = 'Miercoles' AND HORA = '11-12' ;",null).toString());
        txtcampo6miercoles.setText(db.rawQuery("SELECT INSTRUCTOR FROM HORARIO WHERE JORNADA = 1 AND DIA = 'Miercoles' AND HORA = '12-13' ;",null).toString());

        txtcampo1jueves.setText(db.rawQuery("SELECT INSTRUCTOR FROM HORARIO WHERE JORNADA = 1 AND DIA = 'Jueves' AND HORA = '7-8' ;",null).toString());
        txtcampo2jueves.setText(db.rawQuery("SELECT INSTRUCTOR FROM HORARIO WHERE JORNADA = 1 AND DIA = 'Jueves' AND HORA = '8-9' ;",null).toString());
        txtcampo3jueves.setText(db.rawQuery("SELECT INSTRUCTOR FROM HORARIO WHERE JORNADA = 1 AND DIA = 'Jueves' AND HORA = '9-10' ;",null).toString());
        txtcampo4jueves.setText(db.rawQuery("SELECT INSTRUCTOR FROM HORARIO WHERE JORNADA = 1 AND DIA = 'Jueves' AND HORA = '10-11' ;",null).toString());
        txtcampo5jueves.setText(db.rawQuery("SELECT INSTRUCTOR FROM HORARIO WHERE JORNADA = 1 AND DIA = 'Jueves' AND HORA = '11-12' ;",null).toString());
        txtcampo6jueves.setText(db.rawQuery("SELECT INSTRUCTOR FROM HORARIO WHERE JORNADA = 1 AND DIA = 'Jueves' AND HORA = '12-13' ;",null).toString());

        txtcampo1viernes.setText(db.rawQuery("SELECT INSTRUCTOR FROM HORARIO WHERE JORNADA = 1 AND DIA = 'Viernes' AND HORA = '7-8' ;",null).toString());
        txtcampo2viernes.setText(db.rawQuery("SELECT INSTRUCTOR FROM HORARIO WHERE JORNADA = 1 AND DIA = 'Viernes' AND HORA = '8-9' ;",null).toString());
        txtcampo3viernes.setText(db.rawQuery("SELECT INSTRUCTOR FROM HORARIO WHERE JORNADA = 1 AND DIA = 'Viernes' AND HORA = '9-10' ;",null).toString());
        txtcampo4viernes.setText(db.rawQuery("SELECT INSTRUCTOR FROM HORARIO WHERE JORNADA = 1 AND DIA = 'Viernes' AND HORA = '10-11' ;",null).toString());
        txtcampo5viernes.setText(db.rawQuery("SELECT INSTRUCTOR FROM HORARIO WHERE JORNADA = 1 AND DIA = 'Viernes' AND HORA = '11-12' ;",null).toString());
        txtcampo6viernes.setText(db.rawQuery("SELECT INSTRUCTOR FROM HORARIO WHERE JORNADA = 1 AND DIA = 'Viernes' AND HORA = '12-13' ;",null).toString());

        txtcampo1sabado.setText(db.rawQuery("SELECT INSTRUCTOR FROM HORARIO WHERE JORNADA = 1 AND DIA = 'Sábado' AND HORA = '7-8' ;",null).toString());
        txtcampo2sabado.setText(db.rawQuery("SELECT INSTRUCTOR FROM HORARIO WHERE JORNADA = 1 AND DIA = 'Sábado' AND HORA = '8-9' ;",null).toString());
        txtcampo3sabado.setText(db.rawQuery("SELECT INSTRUCTOR FROM HORARIO WHERE JORNADA = 1 AND DIA = 'Sábado' AND HORA = '9-10' ;",null).toString());
        txtcampo4sabado.setText(db.rawQuery("SELECT INSTRUCTOR FROM HORARIO WHERE JORNADA = 1 AND DIA = 'Sábado' AND HORA = '10-11' ;",null).toString());
        txtcampo5sabado.setText(db.rawQuery("SELECT INSTRUCTOR FROM HORARIO WHERE JORNADA = 1 AND DIA = 'Sábado' AND HORA = '11-12' ;",null).toString());
        txtcampo6sabado.setText(db.rawQuery("SELECT INSTRUCTOR FROM HORARIO WHERE JORNADA = 1 AND DIA = 'Sábado' AND HORA = '12-13' ;",null).toString());


    }

    public void back(View view) {
        finish();
    }
}
