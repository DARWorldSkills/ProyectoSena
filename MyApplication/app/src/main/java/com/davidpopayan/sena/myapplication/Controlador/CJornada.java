package com.davidpopayan.sena.myapplication.Controlador;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;


import com.davidpopayan.sena.myapplication.Modelo.GestorDB;
import com.davidpopayan.sena.myapplication.Modelo.Jornada;
import com.davidpopayan.sena.myapplication.R;

import java.util.ArrayList;
import java.util.List;

import fr.ganfra.materialspinner.MaterialSpinner;

public class CJornada extends AppCompatActivity {
    MaterialSpinner spNombre, spHora;
    EditText txtico;
    Button btndelete, btnupdate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cjornada);
        inizialite();
        listarNombre();
        listarHora();
        btnupdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updatejornada(v);
            }
        });

        btndelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deletejornada(v);
            }
        });

    }

    private void deletejornada(View v) {

    }

    private void updatejornada(View v) {
        GestorDB gestorDB = new GestorDB(this);
        SQLiteDatabase db = gestorDB.getWritableDatabase();
        ContentValues values = new ContentValues();
        try {
            Jornada jornada = new Jornada();
            jornada.setName(spNombre.getSelectedItem().toString());

            jornada.setHorario(spHora.getSelectedItem().toString());
            jornada.setIcono(txtico.getText().toString());

            String[] parameters = {jornada.getName()};;
            values.put("ICONO",jornada.getIcono());

            db.update("JORNADA",values,"NOMBRE=?",parameters);

            Snackbar.make(v, "Se ha actualizado a "+jornada.getName(), Snackbar.LENGTH_SHORT).show();

        }catch (Exception e){
            Snackbar.make(v, "Faltan campos por ingresar", Snackbar.LENGTH_SHORT).show();
        }
    }

    public void inizialite(){
        spNombre = findViewById(R.id.spinnerNCJ);
        spHora = findViewById(R.id.spinnerHCJ);
        txtico = findViewById(R.id.txticoCJ);
        btnupdate = findViewById(R.id.btnactualizarCJ);
        btndelete = findViewById(R.id.btneliminarCJ);
    }

    public List<String> consultaNombre(){
        GestorDB gestorDB = new GestorDB(this);
        SQLiteDatabase db = gestorDB.getWritableDatabase();
        List<String> results = new ArrayList<>();
        Cursor cursor = db.rawQuery("SELECT * FROM JORNADA",null);
        if (cursor.moveToFirst()){
            do {
                Jornada jornada = new Jornada();
                jornada.setName(cursor.getString(1));

                results.add(jornada.getName());
            }while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return results;
    }

    public void listarNombre(){
        List<String> listanombre = consultaNombre();
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item,listanombre);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spNombre.setAdapter(adapter);

    }

    public void listarHora(){
        List<String> lista = new ArrayList<>();
        lista.add("7-13");
        lista.add("13-19");
        lista.add("19-23");
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, lista);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spHora.setAdapter(adapter);

    }


}
