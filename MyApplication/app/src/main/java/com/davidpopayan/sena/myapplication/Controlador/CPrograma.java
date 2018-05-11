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
import com.davidpopayan.sena.myapplication.Modelo.Programa;
import com.davidpopayan.sena.myapplication.R;

import java.util.ArrayList;
import java.util.List;

import fr.ganfra.materialspinner.MaterialSpinner;

public class CPrograma extends AppCompatActivity {
    MaterialSpinner spPrograma;
    EditText txtdes, txtvideo,txtico;
    Button btnupdate, btndelete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cprograma);
        inizialite();
        listarPrograma();
        btnupdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updatePrograma(v);
            }
        });
        btndelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deletePrograma(v);
            }
        });
    }

    private void deletePrograma(View v) {
        GestorDB gestorDB = new GestorDB(this);
        SQLiteDatabase db = gestorDB.getWritableDatabase();
        String[] parameters = {spPrograma.getSelectedItem().toString()};
        db.delete("PROGRAMA","NOMBRE =?",parameters);

    }

    private void updatePrograma(View v) {
        GestorDB gestorDB = new GestorDB(this);
        SQLiteDatabase db = gestorDB.getWritableDatabase();
        ContentValues values = new ContentValues();
        try {
            Programa programa = new Programa();
            programa.setName(spPrograma.getSelectedItem().toString());
            programa.setDescription(txtdes.getText().toString());
            programa.setVideo(txtvideo.getText().toString());
            programa.setIcono(txtico.getText().toString());

            String[] parameters = {programa.getName()};
            values.put("DESCRIPCION",programa.getDescription());
            values.put("VIDEO",programa.getVideo());
            values.put("ICONO",programa.getIcono());

            db.update("PROGRAMA",values,"NOMBRE=?",parameters);

            Snackbar.make(v, "Se ha actualizado a "+programa.getName(), Snackbar.LENGTH_SHORT).show();

        }catch (Exception e){
            Snackbar.make(v, "Faltan campos por ingresar", Snackbar.LENGTH_SHORT).show();
        }



    }

    public void inizialite(){
        spPrograma = findViewById(R.id.spinnerCU);
        txtdes = findViewById(R.id.txtdesCP);
        txtvideo = findViewById(R.id.txtvidCP);
        txtico = findViewById(R.id.txticoCP);
    }

    public void listarPrograma(){
        List<String> listaprograma = consultaPrograma();
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,android.R.layout.simple_spinner_dropdown_item, listaprograma);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spPrograma.setAdapter(adapter);


    }

    public List<String> consultaPrograma(){
        GestorDB gestorDB = new GestorDB(this);
        SQLiteDatabase db = gestorDB.getWritableDatabase();
        List<String> results = new ArrayList<>();
        Cursor cursor = db.rawQuery("SELECT * FROM PROGRAMA",null);
        if (cursor.moveToFirst()){
            do {
                Programa programa = new Programa();
                int tmp =cursor.getInt(0);
                programa.setName(cursor.getString(1));

                results.add(Integer.toString(tmp)+" "+programa.getName());

            }while (cursor.moveToNext());
        }

        cursor.close();
        db.close();
        return results;
    }


}