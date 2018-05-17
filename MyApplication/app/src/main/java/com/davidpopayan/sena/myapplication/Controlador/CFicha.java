package com.davidpopayan.sena.myapplication.Controlador;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;

import com.davidpopayan.sena.myapplication.Modelo.Ficha;
import com.davidpopayan.sena.myapplication.Modelo.GestorDB;
import com.davidpopayan.sena.myapplication.Modelo.Instructor;
import com.davidpopayan.sena.myapplication.Modelo.Programa;
import com.davidpopayan.sena.myapplication.R;

import java.util.ArrayList;
import java.util.List;

import fr.ganfra.materialspinner.MaterialSpinner;

public class CFicha extends AppCompatActivity {
    MaterialSpinner spNFicha,spInstructorL, spPrograma;
    Button btnupdate, btndelete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cficha);
        inizialite();
        listarNficha();
        listarInstructor();
        listarPrograma();
        btnupdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateFicha(v);

            }
        });
        btndelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteFicha(v);
            }
        });
    }

    private void updateFicha(View v) {
        GestorDB gestorDB = new GestorDB(this);
        SQLiteDatabase db = gestorDB.getWritableDatabase();

        try{
            ContentValues values = new ContentValues();
            Ficha ficha = new Ficha();
            ficha.setnFicha(spNFicha.getSelectedItem().toString());
            Cursor cursorInstructor;
            Cursor cursorPrograma;
            try{
                cursorInstructor = db.rawQuery("SELECT IDINSTRUCTOR FROM INSTRUCTOR WHERE NOMBRE ="+spInstructorL.getSelectedItem().toString(),null);
                if (cursorInstructor.moveToFirst()) {
                    do {
                        ficha.setInstructorL(cursorInstructor.getInt(0));
                    }while (cursorInstructor.moveToNext());
                }
            }catch (Exception e){

            }

            try{
                cursorPrograma = db.rawQuery("SELECT IDPROGRAMA FROM PROGRAMA WHERE NOMBRE ="+spPrograma.getSelectedItem().toString(),null);
                if (cursorPrograma.moveToFirst()) {
                    do {
                        ficha.setPrograma(cursorPrograma.getInt(0));
                    }while (cursorPrograma.moveToNext());
                }
            }catch (Exception e){

            }

            try{
                Cursor cursorIntructor = db.rawQuery("SELECT IDINSTRUCTOR FROM INSTRUCTOR WHERE NOMBRE ="+spInstructorL.getSelectedItem().toString(),null);
                ficha.setInstructorL(cursorIntructor.getInt(0));
            }catch (Exception e){

            }

            values.put("INSTRUCTORL",ficha.getInstructorL());
            values.put("PROGRAMA",ficha.getPrograma());
            String [] parameters = {ficha.getnFicha()};
            db.update("FICHA",values,"WHERE NFICHA=?",parameters);
            Snackbar.make(v,"Se ha actualizado correctamente",Snackbar.LENGTH_SHORT).show();

        }catch (Exception e){
            Snackbar.make(v,"No se ha seleccionado ningun campo",Snackbar.LENGTH_SHORT).show();
        }



    }

    private void deleteFicha(View v) {
        GestorDB gestorDB = new GestorDB(this);
        SQLiteDatabase db = gestorDB.getWritableDatabase();
        try{
            String[] parameters ={spNFicha.getSelectedItem().toString()};
            db.delete("FICHA","NFICHA =?",parameters);
            Snackbar.make(v,"Se ha eliminado correctamente",Snackbar.LENGTH_SHORT).show();

        }catch (Exception e){
            Snackbar.make(v,"No ha seleccionado la ficha a eliminar",Snackbar.LENGTH_SHORT).show();
        }
    }


    public void inizialite(){
        spNFicha = findViewById(R.id.spinnerCFNumero);
        spInstructorL = findViewById(R.id.spinnerCFInstructor);
        spPrograma = findViewById(R.id.spinnerCFPrograma);
        btnupdate = findViewById(R.id.btnactualizarCF);
        btndelete = findViewById(R.id.btneliminarCF);
    }

    public void listarNficha(){
        ArrayAdapter adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item,consultaNFicha());
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spNFicha.setAdapter(adapter);
    }

    public List<String> consultaNFicha(){
        GestorDB gestorDB = new GestorDB(this);
        SQLiteDatabase db = gestorDB.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT NFICHA FROM FICHA;",null);
        List<String> results = new ArrayList<>();
        Ficha ficha;
        if (cursor.moveToFirst()){
            do {
                ficha= new Ficha();
                ficha.setnFicha(cursor.getString(0));
                results.add(ficha.getnFicha());

            }while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return results;

    }

    public void listarInstructor(){
        ArrayAdapter adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item,consultaInstructor());
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spInstructorL.setAdapter(adapter);
    }

    public List<String> consultaInstructor(){
        GestorDB gestorDB = new GestorDB(this);
        SQLiteDatabase db = gestorDB.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT NOMBRE FROM INSTRUCTOR;",null);
        List<String> results = new ArrayList<>();
        Instructor instructor;
        if (cursor.moveToFirst()){
            do {
                instructor= new Instructor();
                instructor.setName(cursor.getString(0));
                results.add(instructor.getName());

            }while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return results;

    }

    public void listarPrograma(){
        ArrayAdapter adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item,consultaPrograma());
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spPrograma.setAdapter(adapter);
    }

    public List<String> consultaPrograma(){
        GestorDB gestorDB = new GestorDB(this);
        SQLiteDatabase db = gestorDB.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT NOMBRE FROM PROGRAMA;",null);
        List<String> results = new ArrayList<>();
        Programa programa;
        if (cursor.moveToFirst()){
            do {
                programa= new Programa();
                programa.setName(cursor.getString(0));
                results.add(programa.getName());

            }while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return results;

    }


}
