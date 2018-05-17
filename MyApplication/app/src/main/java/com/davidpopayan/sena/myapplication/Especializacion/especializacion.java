package com.davidpopayan.sena.myapplication.Especializacion;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.davidpopayan.sena.myapplication.Controlador.MainActivity;
import com.davidpopayan.sena.myapplication.Modelo.GestorDB;
import com.davidpopayan.sena.myapplication.R;

public class especializacion extends AppCompatActivity {
    TextView txtprograma,txtinstructor,txtficha;
    TextView txtcampo16lunes,txtcampo17lunes,txtcampo18lunes,txtcampo19lunes,txtcampo20lunes;
    TextView txtcampo16martes,txtcampo17martes,txtcampo18martes,txtcampo19martes,txtcampo20martes;
    TextView txtcampo16miercoles,txtcampo17miercoles,txtcampo18miercoles,txtcampo19miercoles,txtcampo20miercoles;
    TextView txtcampo16jueves,txtcampo17jueves,txtcampo18jueves,txtcampo19jueves,txtcampo20jueves;
    TextView txtcampo16viernes,txtcampo17viernes,txtcampo18viernes,txtcampo19viernes,txtcampo20viernes;
    TextView txtcampo16sabado,txtcampo17sabado,txtcampo18sabado,txtcampo19sabado,txtcampo20sabado;
    String fichaN="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_especializacion);
        txtprograma= findViewById(R.id.txtProgramaT);
        txtinstructor= findViewById(R.id.txtInstructorT);
        txtficha= findViewById(R.id.txtNumFichaT);
        inicializartabla();
        listartabla();
        inputFichaD();
    }

    public void inputFichaD(){
        fichaN= MainActivity.fichaN;
        GestorDB gestorDB = new GestorDB(this);
        SQLiteDatabase db = gestorDB.getReadableDatabase();
        if (!fichaN.equals("")) {
            Cursor cursor = db.rawQuery("SELECT * FROM FICHA WHERE NFICHA = '" + fichaN + "' ;", null);
            if (cursor.moveToFirst()){
                do {
                    txtficha.setText(cursor.getString(0));
                    txtinstructor.setText(cursor.getString(1));
                    txtprograma.setText(cursor.getString(2));

                }while (cursor.moveToNext());
            }
            cursor.close();

        }
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
        GestorDB gestorBD = new GestorDB(this);
        SQLiteDatabase db = gestorBD.getWritableDatabase();

        String[] dias = {getString(R.string.lunes), getString(R.string.martes), getString(R.string.miercoles), getString(R.string.jueves), getString(R.string.viernes), getString(R.string.sabado)};
        String[] horas = {getString(R.string.trececatorce), getString(R.string.catorcequince), getString(R.string.quincedieciseis), getString(R.string.dieciseisdiecisiete), getString(R.string.diecisietedieciocho), getString(R.string.docetrece)};
        TextView[] campos = {txtcampo16lunes, txtcampo17lunes, txtcampo18lunes, txtcampo19lunes, txtcampo20lunes,
                txtcampo16martes, txtcampo17martes, txtcampo18martes, txtcampo19martes, txtcampo20martes,
                txtcampo16miercoles, txtcampo17miercoles, txtcampo18miercoles, txtcampo19miercoles, txtcampo20miercoles,
                txtcampo16jueves, txtcampo17jueves, txtcampo18jueves, txtcampo19jueves, txtcampo20jueves,
                txtcampo16viernes, txtcampo17viernes, txtcampo18viernes, txtcampo19viernes, txtcampo20viernes,
                txtcampo16sabado, txtcampo17sabado, txtcampo18sabado, txtcampo19sabado, txtcampo20sabado};
        int tmp = 0;
        int pa=0;
        Cursor cursortmp;
        Cursor cursorcampos;
        for (int i = 0; i < dias.length; i++) {
            for (int j = 0; j < horas.length; j++) {

                cursortmp=(db.rawQuery("SELECT INSTRUCTOR FROM HORARIO WHERE JORNADA = 3 AND DIA = '"+dias[i]+"' AND HORA = '"+horas[j]+"' ;", null));
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
