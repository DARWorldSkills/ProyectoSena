
package com.davidpopayan.sena.myapplication.Animacion;


import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.davidpopayan.sena.myapplication.Fragmentos.FragmentViewPlay;
import com.davidpopayan.sena.myapplication.Modelo.GestorBD;
import com.davidpopayan.sena.myapplication.R;

public class Caja extends AppCompatActivity {
    TextView txtcampo9lunes,txtcampo10lunes,txtcampo11lunes,txtcampo12lunes,txtcampo13lunes,txtcampo14lunes;
    TextView txtcampo9martes,txtcampo10martes,txtcampo11martes,txtcampo12martes,txtcampo13martes,txtcampo14martes;
    TextView txtcampo9miercoles,txtcampo10miercoles,txtcampo11miercoles,txtcampo12miercoles,txtcampo13miercoles,txtcampo14miercoles;
    TextView txtcampo9jueves,txtcampo10jueves,txtcampo11jueves,txtcampo12jueves,txtcampo13jueves,txtcampo14jueves;
    TextView txtcampo9viernes,txtcampo10viernes,txtcampo11viernes,txtcampo12viernes,txtcampo13viernes,txtcampo14viernes;
    TextView txtcampo9sabado,txtcampo10sabado,txtcampo11sabado,txtcampo12sabado,txtcampo13sabado,txtcampo14sabado;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_caja);
        inicializartabla();
        llenarTabla();


    }

    public void inicializartabla(){
        txtcampo9lunes= findViewById(R.id.campo9lunes);
        txtcampo10lunes= findViewById(R.id.campo10lunes);
        txtcampo11lunes= findViewById(R.id.campo11lunes);
        txtcampo12lunes= findViewById(R.id.campo12lunes);
        txtcampo13lunes= findViewById(R.id.campo13lunes);
        txtcampo14lunes= findViewById(R.id.campo14lunes);

        txtcampo9martes= findViewById(R.id.campo9martes);
        txtcampo10martes= findViewById(R.id.campo10martes);
        txtcampo11martes= findViewById(R.id.campo11martes);
        txtcampo12martes= findViewById(R.id.campo12martes);
        txtcampo13martes= findViewById(R.id.campo13martes);
        txtcampo14martes= findViewById(R.id.campo14martes);

        txtcampo9miercoles= findViewById(R.id.campo9miercoles);
        txtcampo10miercoles= findViewById(R.id.campo10miercoles);
        txtcampo11miercoles= findViewById(R.id.campo11miercoles);
        txtcampo12miercoles= findViewById(R.id.campo12miercoles);
        txtcampo13miercoles= findViewById(R.id.campo13miercoles);
        txtcampo14miercoles= findViewById(R.id.campo14miercoles);

        txtcampo9jueves= findViewById(R.id.campo9jueves);
        txtcampo10jueves= findViewById(R.id.campo10jueves);
        txtcampo11jueves= findViewById(R.id.campo11jueves);
        txtcampo12jueves= findViewById(R.id.campo12jueves);
        txtcampo13jueves= findViewById(R.id.campo13jueves);
        txtcampo14jueves= findViewById(R.id.campo14jueves);

        txtcampo9viernes= findViewById(R.id.campo9viernes);
        txtcampo10viernes= findViewById(R.id.campo10viernes);
        txtcampo11viernes= findViewById(R.id.campo11viernes);
        txtcampo12viernes= findViewById(R.id.campo12viernes);
        txtcampo13viernes= findViewById(R.id.campo13viernes);
        txtcampo14viernes= findViewById(R.id.campo14viernes);

        txtcampo9sabado= findViewById(R.id.campo9sabado);
        txtcampo10sabado= findViewById(R.id.campo10sabado);
        txtcampo11sabado= findViewById(R.id.campo11sabado);
        txtcampo12sabado= findViewById(R.id.campo12sabado);
        txtcampo13sabado= findViewById(R.id.campo13sabado);
        txtcampo14sabado= findViewById(R.id.campo14sabado);



    }

    public void llenarTabla(){
        GestorBD gestorBD = new GestorBD(this);
        SQLiteDatabase db = gestorBD.getReadableDatabase();

        txtcampo9lunes.setText(db.rawQuery("SELECT INSTRUCTOR FROM HORARIO WHERE JORNADA = 2 AND DIA = 'Lunes' AND HORA = '13-14' ;",null).toString());
        txtcampo10lunes.setText(db.rawQuery("SELECT INSTRUCTOR FROM HORARIO WHERE JORNADA = 2 AND DIA = 'Lunes' AND HORA = '14-15' ;",null).toString());
        txtcampo11lunes.setText(db.rawQuery("SELECT INSTRUCTOR FROM HORARIO WHERE JORNADA = 2 AND DIA = 'Lunes' AND HORA = '15-16' ;",null).toString());
        txtcampo12lunes.setText(db.rawQuery("SELECT INSTRUCTOR FROM HORARIO WHERE JORNADA = 2 AND DIA = 'Lunes' AND HORA = '16-17' ;",null).toString());
        txtcampo13lunes.setText(db.rawQuery("SELECT INSTRUCTOR FROM HORARIO WHERE JORNADA = 2 AND DIA = 'Lunes' AND HORA = '17-18' ;",null).toString());
        txtcampo14lunes.setText(db.rawQuery("SELECT INSTRUCTOR FROM HORARIO WHERE JORNADA = 2 AND DIA = 'Lunes' AND HORA = '18-19' ;",null).toString());

        txtcampo9martes.setText(db.rawQuery("SELECT INSTRUCTOR FROM HORARIO WHERE JORNADA = 2 AND DIA = 'Martes' AND HORA = '13-14' ;",null).toString());
        txtcampo10martes.setText(db.rawQuery("SELECT INSTRUCTOR FROM HORARIO WHERE JORNADA = 2 AND DIA = 'Martes' AND HORA = '14-15' ;",null).toString());
        txtcampo11martes.setText(db.rawQuery("SELECT INSTRUCTOR FROM HORARIO WHERE JORNADA = 2 AND DIA = 'Martes' AND HORA = '15-16' ;",null).toString());
        txtcampo12martes.setText(db.rawQuery("SELECT INSTRUCTOR FROM HORARIO WHERE JORNADA = 2 AND DIA = 'Martes' AND HORA = '16-17' ;",null).toString());
        txtcampo13martes.setText(db.rawQuery("SELECT INSTRUCTOR FROM HORARIO WHERE JORNADA = 2 AND DIA = 'Martes' AND HORA = '17-18' ;",null).toString());
        txtcampo14martes.setText(db.rawQuery("SELECT INSTRUCTOR FROM HORARIO WHERE JORNADA = 2 AND DIA = 'Martes' AND HORA = '18-19' ;",null).toString());

        txtcampo9miercoles.setText(db.rawQuery("SELECT INSTRUCTOR FROM HORARIO WHERE JORNADA = 2 AND DIA = 'Miercoles' AND HORA = '13-14' ;",null).toString());
        txtcampo10miercoles.setText(db.rawQuery("SELECT INSTRUCTOR FROM HORARIO WHERE JORNADA = 2 AND DIA = 'Miercoles' AND HORA = '14-15' ;",null).toString());
        txtcampo11miercoles.setText(db.rawQuery("SELECT INSTRUCTOR FROM HORARIO WHERE JORNADA = 2 AND DIA = 'Miercoles' AND HORA = '15-16' ;",null).toString());
        txtcampo12miercoles.setText(db.rawQuery("SELECT INSTRUCTOR FROM HORARIO WHERE JORNADA = 2 AND DIA = 'Miercoles' AND HORA = '16-17' ;",null).toString());
        txtcampo13miercoles.setText(db.rawQuery("SELECT INSTRUCTOR FROM HORARIO WHERE JORNADA = 2 AND DIA = 'Miercoles' AND HORA = '17-18' ;",null).toString());
        txtcampo14miercoles.setText(db.rawQuery("SELECT INSTRUCTOR FROM HORARIO WHERE JORNADA = 2 AND DIA = 'Miercoles' AND HORA = '18-19' ;",null).toString());

        txtcampo9jueves.setText(db.rawQuery("SELECT INSTRUCTOR FROM HORARIO WHERE JORNADA = 2 AND DIA = 'Jueves' AND HORA = '13-14' ;",null).toString());
        txtcampo10jueves.setText(db.rawQuery("SELECT INSTRUCTOR FROM HORARIO WHERE JORNADA = 2 AND DIA = 'Jueves' AND HORA = '14-15' ;",null).toString());
        txtcampo11jueves.setText(db.rawQuery("SELECT INSTRUCTOR FROM HORARIO WHERE JORNADA = 2 AND DIA = 'Jueves' AND HORA = '15-16' ;",null).toString());
        txtcampo12jueves.setText(db.rawQuery("SELECT INSTRUCTOR FROM HORARIO WHERE JORNADA = 2 AND DIA = 'Jueves' AND HORA = '16-17' ;",null).toString());
        txtcampo13jueves.setText(db.rawQuery("SELECT INSTRUCTOR FROM HORARIO WHERE JORNADA = 2 AND DIA = 'Jueves' AND HORA = '17-18' ;",null).toString());
        txtcampo14jueves.setText(db.rawQuery("SELECT INSTRUCTOR FROM HORARIO WHERE JORNADA = 2 AND DIA = 'Jueves' AND HORA = '18-19' ;",null).toString());

        txtcampo9viernes.setText(db.rawQuery("SELECT INSTRUCTOR FROM HORARIO WHERE JORNADA = 2 AND DIA = 'Viernes' AND HORA = '14-15' ;",null).toString());
        txtcampo11viernes.setText(db.rawQuery("SELECT INSTRUCTOR FROM HORARIO WHERE JORNADA = 2 AND DIA = 'Viernes' AND HORA = '15-16' ;",null).toString());
        txtcampo12viernes.setText(db.rawQuery("SELECT INSTRUCTOR FROM HORARIO WHERE JORNADA = 2 AND DIA = 'Viernes' AND HORA = '16-17' ;",null).toString());
        txtcampo13viernes.setText(db.rawQuery("SELECT INSTRUCTOR FROM HORARIO WHERE JORNADA = 2 AND DIA = 'Viernes' AND HORA = '17-18' ;",null).toString());
        txtcampo14viernes.setText(db.rawQuery("SELECT INSTRUCTOR FROM HORARIO WHERE JORNADA = 2 AND DIA = 'Viernes' AND HORA = '18-19' ;",null).toString());



        txtcampo9sabado.setText(db.rawQuery("SELECT INSTRUCTOR FROM HORARIO WHERE JORNADA = 2 AND DIA = 'Sábado' AND HORA = '13-14' ;",null).toString());
        txtcampo10sabado.setText(db.rawQuery("SELECT INSTRUCTOR FROM HORARIO WHERE JORNADA = 2 AND DIA = 'Sábado' AND HORA = '14-15' ;",null).toString());
        txtcampo11sabado.setText(db.rawQuery("SELECT INSTRUCTOR FROM HORARIO WHERE JORNADA = 2 AND DIA = 'Sábado' AND HORA = '15-16' ;",null).toString());
        txtcampo12sabado.setText(db.rawQuery("SELECT INSTRUCTOR FROM HORARIO WHERE JORNADA = 2 AND DIA = 'Sábado' AND HORA = '16-17' ;",null).toString());
        txtcampo13sabado.setText(db.rawQuery("SELECT INSTRUCTOR FROM HORARIO WHERE JORNADA = 2 AND DIA = 'Sábado' AND HORA = '17-18' ;",null).toString());
        txtcampo14sabado.setText(db.rawQuery("SELECT INSTRUCTOR FROM HORARIO WHERE JORNADA = 2 AND DIA = 'Sábado' AND HORA = '18-19' ;",null).toString());
    }




    public void enviar4(View view) {
        Intent intent = new Intent(Caja.this, Infocaja.class);
        startActivity(intent);

    }

    public void back(View view) {
        finish();
    }
}
