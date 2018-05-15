package com.davidpopayan.sena.myapplication.Videojuegos;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.davidpopayan.sena.myapplication.Modelo.GestorDB;
import com.davidpopayan.sena.myapplication.R;

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

    public void listartabla() {
        GestorDB gestorBD = new GestorDB(this);
        SQLiteDatabase db = gestorBD.getWritableDatabase();

        String[] dias = {getString(R.string.lunes), getString(R.string.martes), getString(R.string.miercoles), getString(R.string.jueves), getString(R.string.viernes), getString(R.string.sabado)};
        String[] horas = {getString(R.string.sieteocho), getString(R.string.ochonueve), getString(R.string.nuevediez), getString(R.string.diezonce), getString(R.string.oncedoce), getString(R.string.docetrece)};
        TextView[] campos = {txtcampo1lunes, txtcampo2lunes, txtcampo3lunes, txtcampo4lunes, txtcampo5lunes, txtcampo6lunes,
                txtcampo1martes, txtcampo2martes, txtcampo3martes, txtcampo4martes, txtcampo5martes, txtcampo6martes,
                txtcampo1miercoles, txtcampo2miercoles, txtcampo3miercoles, txtcampo4miercoles, txtcampo5miercoles, txtcampo6miercoles,
                txtcampo1jueves, txtcampo2jueves, txtcampo3jueves, txtcampo4jueves, txtcampo5jueves, txtcampo6jueves,
                txtcampo1viernes, txtcampo2viernes, txtcampo3viernes, txtcampo4viernes, txtcampo5viernes, txtcampo6viernes,
                txtcampo1sabado, txtcampo2sabado, txtcampo3sabado, txtcampo4sabado, txtcampo5sabado, txtcampo6sabado};
        int tmp = 0;
        int pa=0;
        Cursor cursortmp;
        Cursor cursorcampos;
        for (int i = 0; i < dias.length; i++) {
            for (int j = 0; j < horas.length; j++) {

                        cursortmp=(db.rawQuery("SELECT INSTRUCTOR FROM HORARIO WHERE JORNADA = 1 AND DIA = '"+dias[i]+"' AND HORA = '"+horas[j]+"' ;", null));
                        if (cursortmp.moveToFirst()) {
                            //Recorremos el cursor hasta que no haya más registros
                            do {
                                tmp=(cursortmp.getInt(0));
                                cursorcampos=(db.rawQuery("SELECT NOMBRE FROM INSTRUCTOR WHERE IDINSTRUCTOR = " + tmp + ";", null));
                                if (cursorcampos.moveToFirst()) {
                                    //Recorremos el cursor hasta que no haya más registros
                                    do {
                                        campos[pa].setText(cursorcampos.getString(0));
                                    } while(cursorcampos.moveToNext());

                                    cursorcampos.close();
                                }
                            } while(cursortmp.moveToNext());
                        }


                        cursortmp.close();

                        pa=pa+1;
                    }

            }


        db.close();




    }


    public void back(View view) {
        finish();
    }
}
