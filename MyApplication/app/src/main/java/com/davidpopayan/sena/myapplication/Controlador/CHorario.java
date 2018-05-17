package com.davidpopayan.sena.myapplication.Controlador;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.opengl.GLException;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Toast;

import com.davidpopayan.sena.myapplication.Modelo.GestorDB;
import com.davidpopayan.sena.myapplication.Modelo.Horario;
import com.davidpopayan.sena.myapplication.Modelo.Instructor;
import com.davidpopayan.sena.myapplication.Modelo.Programa;
import com.davidpopayan.sena.myapplication.Modelo.User;
import com.davidpopayan.sena.myapplication.R;

import java.util.ArrayList;
import java.util.List;

import fr.ganfra.materialspinner.MaterialSpinner;


public class CHorario extends AppCompatActivity {
    MaterialSpinner spdiahora, spinstructor,spprograma,spuser;
    Button btnupdate, btndelete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chorario);
        inizialite();
        listarDiaHora();
        listarInstructor();
        listarPrograma();
        listarUser();
        btnupdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateHorario(v);
            }
        });

        btndelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteHorario(v);
            }
        });
    }

    private void deleteHorario(View v) {
        GestorDB gestorDB = new GestorDB(this);
        SQLiteDatabase db = gestorDB.getWritableDatabase();
        try {
            int tmp;
            String[] parte = spdiahora.getSelectedItem().toString().split("°");
            tmp = Integer.parseInt(parte[0]);
            Toast.makeText(this, Integer.toString(tmp), Toast.LENGTH_SHORT).show();
            String[] parameters = {Integer.toString(tmp)};
            db.delete("HORARIO", "IDHORARIO =?", parameters);
            Snackbar.make(v, "Se ha eliminado correctamete", Snackbar.LENGTH_SHORT).show();
        }catch (Exception e){
            Snackbar.make(v, "No se ha seleccionado el horario", Snackbar.LENGTH_SHORT).show();
        }

    }

    private void updateHorario(View v) {
        GestorDB gestorDB = new GestorDB(this);
        SQLiteDatabase db = gestorDB.getWritableDatabase();
        try {
            int tmp;
            String [] parte= spdiahora.getSelectedItem().toString().split("°");
            tmp= Integer.parseInt(parte[0]);
            String[] parameters = {Integer.toString(tmp)};
            Horario horario = new Horario();
            Cursor cursorprograma =db.rawQuery("SELECT IDPROGRAMA FROM PROGRAMA WHERE NOMBRE ='"+spprograma.getSelectedItem().toString()+"';",null);
            if (cursorprograma.moveToFirst()){
                do {
                    horario.setPrograma(cursorprograma.getInt(0));
                }while (cursorprograma.moveToNext());
            }


            Cursor cursorinstructor =db.rawQuery("SELECT IDINSTRUCTOR FROM INSTRUCTOR WHERE NOMBRE ='"+spinstructor.getSelectedItem().toString()+"';",null);
            if (cursorinstructor.moveToFirst()){
                do {
                    horario.setInstructor(cursorinstructor.getInt(0));
                }while (cursorinstructor.moveToNext());
            }

            horario.setUser(spuser.getSelectedItem().toString());

            cursorinstructor.close();
            cursorprograma.close();
            ContentValues values = new ContentValues();
            values.put("INSTRUCTOR",horario.getInstructor());
            values.put("PROGRAMA",horario.getPrograma());
            values.put("USER",horario.getUser());
            db.update("HORARIO",values,"IDHORARIO=?",parameters);
            Snackbar.make(v, "Se ha actualizado satisfactoriamente", Snackbar.LENGTH_SHORT).show();
        }catch (Exception e){
            Snackbar.make(v, "No se pudo actualizar", Snackbar.LENGTH_SHORT).show();
        }
        gestorDB.close();
        db.close();

    }

    public void inizialite(){
        spdiahora = findViewById(R.id.spdiahoraH);
        spinstructor = findViewById(R.id.spinstructorCH);
        spprograma = findViewById(R.id.spprogramaCH);
        spuser = findViewById(R.id.spuserCH);
        btnupdate = findViewById(R.id.btnactualizarCH);
        btndelete = findViewById(R.id.btneliminarCH);
    }



    public List<String> consultaInstructor(){
        GestorDB gestorDB = new GestorDB(this);
        SQLiteDatabase db = gestorDB.getReadableDatabase();
        List<String> results = new ArrayList<>();
        Cursor cursor = db.rawQuery("SELECT * FROM INSTRUCTOR",null);
        if (cursor.moveToFirst()){
            do {
                Instructor instructor = new Instructor();
                instructor.setName(cursor.getString(1));

                results.add(instructor.getName());
            }while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return results;

    }



    public List<String> consultaPrograma(){
        GestorDB gestorDB = new GestorDB(this);
        SQLiteDatabase db = gestorDB.getReadableDatabase();
        List<String> results = new ArrayList<>();
        Cursor cursor = db.rawQuery("SELECT * FROM PROGRAMA",null);
        if (cursor.moveToFirst()){
            do {
                Programa programa = new Programa();
                programa.setName(cursor.getString(1));

                results.add(programa.getName());
            }while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return results;

    }

    public List<String> consultaUser(){
        GestorDB gestorDB = new GestorDB(this);
        SQLiteDatabase db = gestorDB.getWritableDatabase();
        List<String> results = new ArrayList<>();
        Cursor cursor = db.rawQuery("SELECT USERNAME FROM USER", null);
        if (cursor.moveToFirst()){
            do {
                User user = new User();
                user.setName(cursor.getString(0));

                results.add(user.getName());

            }while (cursor.moveToNext());
        }

        cursor.close();
        gestorDB.close();
        return results;
     }



    public void listarDiaHora(){
        List<String> lista = new ArrayList<>();

        GestorDB gestorDB = new GestorDB(this);
        SQLiteDatabase db = gestorDB.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM HORARIO",null);
        if (cursor.moveToFirst()){
            do {
                Horario horario = new Horario();
                int tmp=cursor.getInt(0);
                horario.setDia(cursor.getString(1));
                horario.setHora(cursor.getString(2));
                lista.add(Integer.toString(tmp)+"° "+horario.getDia()+" "+horario.getHora());

            }while (cursor.moveToNext());
        }

        ArrayAdapter<String> adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item,lista);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spdiahora.setAdapter(adapter);

    }

    public void listarInstructor(){
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item,consultaInstructor());
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinstructor.setAdapter(adapter);

    }


    public void listarPrograma(){
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item,consultaPrograma());
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spprograma.setAdapter(adapter);
    }

    public void listarUser(){
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item,consultaPrograma());
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spuser.setAdapter(adapter);

    }


}
