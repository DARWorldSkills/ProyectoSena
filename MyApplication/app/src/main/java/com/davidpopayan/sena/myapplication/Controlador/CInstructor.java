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
import com.davidpopayan.sena.myapplication.Modelo.Instructor;
import com.davidpopayan.sena.myapplication.R;

import java.util.ArrayList;
import java.util.List;

import fr.ganfra.materialspinner.MaterialSpinner;

public class CInstructor extends AppCompatActivity {

    MaterialSpinner spinstructor;
    EditText txtphone, txtemail;
    Button btnupdate, btndelete;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cinstructor);
        inizaialite();
        btnupdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateInstructor(v);
            }
        });

        btndelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteInstructor(v);
            }
        });

        listarInstructor();
    }

    private void deleteInstructor(View v) {
        GestorDB gestorDB = new GestorDB(this);
        SQLiteDatabase db = gestorDB.getWritableDatabase();

        try{
            Instructor instructor = new Instructor();
            instructor.setName(spinstructor.getSelectedItem().toString());
            String [] parameters = {instructor.getName()};
            db.delete("INSTRUCTOR","NOMBRE=?",parameters);

            Snackbar.make(v,"Se ha eliminado a: "+instructor.getName(),Snackbar.LENGTH_SHORT).show();
        }catch (Exception e){
            Snackbar.make(v,"No se ha seleccionado a un instructor",Snackbar.LENGTH_SHORT).show();
        }
    }

    private void updateInstructor(View v) {
        GestorDB gestorDB = new GestorDB(this);
        SQLiteDatabase db = gestorDB.getWritableDatabase();
        try{
            Instructor instructor = new Instructor();
            instructor.setName(spinstructor.getSelectedItem().toString());
            instructor.setPhone(txtphone.getText().toString());
            instructor.setEmail(txtemail.getText().toString());
            String[] parameters= {instructor.getName()};
            ContentValues values = new ContentValues();
            values.put("TELEFONO",instructor.getPhone());
            values.put("CORREO",instructor.getEmail());

            db.update("INSTRUCTOR",values,"NOMBRE=?",parameters);
            Snackbar.make(v,"Se ha actualizado satisfactoriamente",Snackbar.LENGTH_SHORT).show();
            cleanm();

        }catch (Exception e){

            Snackbar.make(v,"Faltan campos por llenar",Snackbar.LENGTH_SHORT).show();
        }
        db.close();


    }

    private void cleanm() {
        txtphone.setText("");
        txtemail.setText("");
    }

    public void inizaialite(){
        spinstructor= findViewById(R.id.spinstructorCI);
        txtemail = findViewById(R.id.txtemailCI);
        txtphone = findViewById(R.id.txtphoneCI);

    }

    public void listarInstructor(){
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,android.R.layout.simple_spinner_dropdown_item,consultaInstructor());
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinstructor.setAdapter(adapter);

    }

    public List<String> consultaInstructor(){
        GestorDB gestorDB = new GestorDB(this);
        SQLiteDatabase db = gestorDB.getReadableDatabase();
        List<String> resultados = new ArrayList<>();
        Cursor cursor = db.rawQuery("SELECT * FROM INSTRUCTOR",null);
        try{
            if (cursor.moveToFirst()){
                do {
                    Instructor instructor = new Instructor();
                    instructor.setName(cursor.getString(1));

                    resultados.add(instructor.getName());

                }while (cursor.moveToNext());
            }

        }catch (Exception e){
        }
        cursor.close();
        db.close();
        return  resultados;

    }





}
