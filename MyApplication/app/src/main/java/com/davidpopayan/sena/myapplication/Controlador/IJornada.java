package com.davidpopayan.sena.myapplication.Controlador;

import android.content.ContentValues;
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

public class IJornada extends AppCompatActivity {
    MaterialSpinner spinnerJornada, spinnerHorario;
    List<String> listaJornada= new ArrayList<>();
    List<String> listaHorario= new ArrayList<>();
    ArrayAdapter<String> adapterJornada;
    ArrayAdapter<String> adapterHorario;
    EditText icono;
    Button btnsave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ijornada);
        inicialite();
        inputlistaJ();
        inputlistaH();

        btnsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputJornada(v);

            }
        });
    }

    private void inputJornada(View v) {
        GestorDB gestorDB = new GestorDB(this);
        SQLiteDatabase db = gestorDB.getWritableDatabase();
        try {
            Jornada newJornada= new Jornada();
            newJornada.setName(spinnerJornada.getSelectedItem().toString());
            newJornada.setHorario(spinnerHorario.getSelectedItem().toString());
            newJornada.setIcono(icono.getText().toString());
            ContentValues values= new ContentValues();
            values.put("NOMBRE",newJornada.getName());
            values.put("HORARIO",newJornada.getHorario());
            values.put("ICONO",newJornada.getIcono());
            db.insert("JORNADA",null,values);
            Snackbar.make(v,"Se ha registrado satisfactoriamente", Snackbar.LENGTH_SHORT).show();
            cleanm();

        }catch (Exception e){
            Snackbar.make(v, "Faltan campos por completar", Snackbar.LENGTH_SHORT).show();
        }
        db.close();


    }

    private void cleanm() {
        icono.setText("");
    }

    public void inicialite(){
        spinnerJornada = findViewById(R.id.spinnerNIJ);
        spinnerHorario = findViewById(R.id.spinnerHIJ);
        icono = findViewById(R.id.txturlicoIJ);
        btnsave = findViewById(R.id.btnguardarIJ);
    }

    public void inputlistaJ(){
        listaJornada.add("Mañana");
        listaJornada.add("Tarde");
        listaJornada.add("Noche");
        adapterJornada = new ArrayAdapter<>(this,android.R.layout.simple_spinner_dropdown_item, listaJornada);
        adapterJornada.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerJornada.setAdapter(adapterJornada);


    }

    public void inputlistaH(){
        listaHorario.add("7-13");
        listaHorario.add("13-19");
        listaHorario.add("19-0");

        adapterHorario = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item,listaHorario);
        adapterHorario.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerHorario.setAdapter(adapterHorario);

    }


}
