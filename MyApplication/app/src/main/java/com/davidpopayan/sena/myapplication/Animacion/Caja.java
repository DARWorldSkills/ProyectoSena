
package com.davidpopayan.sena.myapplication.Animacion;


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

public class Caja extends AppCompatActivity {
    TextView txtprograma,txtinstructor,txtficha;
    TextView txtcampo9lunes,txtcampo10lunes,txtcampo11lunes,txtcampo12lunes,txtcampo13lunes,txtcampo14lunes;
    TextView txtcampo9martes,txtcampo10martes,txtcampo11martes,txtcampo12martes,txtcampo13martes,txtcampo14martes;
    TextView txtcampo9miercoles,txtcampo10miercoles,txtcampo11miercoles,txtcampo12miercoles,txtcampo13miercoles,txtcampo14miercoles;
    TextView txtcampo9jueves,txtcampo10jueves,txtcampo11jueves,txtcampo12jueves,txtcampo13jueves,txtcampo14jueves;
    TextView txtcampo9viernes,txtcampo10viernes,txtcampo11viernes,txtcampo12viernes,txtcampo13viernes,txtcampo14viernes;
    TextView txtcampo9sabado,txtcampo10sabado,txtcampo11sabado,txtcampo12sabado,txtcampo13sabado,txtcampo14sabado;
    String fichaT="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_caja);
        txtprograma= findViewById(R.id.txtProgramaT);
        txtinstructor= findViewById(R.id.txtInstructorT);
        txtficha= findViewById(R.id.txtNumFichaT);
        inicializartabla();
        llenarTabla();
        inputFichaD();

    }

    public void inputFichaD(){
        fichaT= MainActivity.fichaT;
        GestorDB gestorDB = new GestorDB(this);
        SQLiteDatabase db = gestorDB.getReadableDatabase();
        if (!fichaT.equals("")) {
            Cursor cursor = db.rawQuery("SELECT * FROM FICHA WHERE NFICHA = '" + fichaT + "' ;", null);
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
        GestorDB gestorBD = new GestorDB(this);
        SQLiteDatabase db = gestorBD.getWritableDatabase();

        String[] dias = {getString(R.string.lunes), getString(R.string.martes), getString(R.string.miercoles), getString(R.string.jueves), getString(R.string.viernes), getString(R.string.sabado)};
        String[] horas = {getString(R.string.trececatorce), getString(R.string.catorcequince), getString(R.string.quincedieciseis), getString(R.string.dieciseisdiecisiete), getString(R.string.diecisietedieciocho), getString(R.string.dieciochodiecinueve)};
        TextView[] campos = {txtcampo9lunes, txtcampo10lunes, txtcampo11lunes, txtcampo12lunes, txtcampo13lunes, txtcampo14lunes,
                txtcampo9martes, txtcampo10martes, txtcampo11martes, txtcampo12martes, txtcampo13martes, txtcampo14martes,
                txtcampo9miercoles, txtcampo10miercoles, txtcampo11miercoles, txtcampo12miercoles, txtcampo13miercoles, txtcampo14miercoles,
                txtcampo9jueves, txtcampo10jueves, txtcampo11jueves, txtcampo12jueves, txtcampo13jueves, txtcampo14jueves,
                txtcampo9viernes, txtcampo10viernes, txtcampo11viernes, txtcampo12viernes, txtcampo13viernes, txtcampo14viernes,
                txtcampo9sabado, txtcampo10sabado, txtcampo11sabado, txtcampo12sabado, txtcampo13sabado, txtcampo14sabado};
        int tmp = 0;
        int pa=0;
        Cursor cursortmp;
        Cursor cursorcampos;
        for (int i = 0; i < dias.length; i++) {
            for (int j = 0; j < horas.length; j++) {

                cursortmp=(db.rawQuery("SELECT INSTRUCTOR FROM HORARIO WHERE JORNADA = 2 AND DIA = '"+dias[i]+"' AND HORA = '"+horas[j]+"' ;", null));
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




    public void enviar4(View view) {
        Intent intent = new Intent(Caja.this, Infocaja.class);
        startActivity(intent);

    }

    public void back(View view) {
        finish();
    }
}
