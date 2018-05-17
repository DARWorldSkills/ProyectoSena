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

import com.davidpopayan.sena.myapplication.Modelo.GestorDB;
import com.davidpopayan.sena.myapplication.Modelo.Horario;
import com.davidpopayan.sena.myapplication.Modelo.Instructor;
import com.davidpopayan.sena.myapplication.Modelo.Programa;
import com.davidpopayan.sena.myapplication.Modelo.User;
import com.davidpopayan.sena.myapplication.R;

import java.util.ArrayList;
import java.util.List;

import fr.ganfra.materialspinner.MaterialSpinner;

public class IHorario extends AppCompatActivity {
    MaterialSpinner spDia, spHora, spInstructor, spPrograma,spUsuario;
    Button btnsave;
    List<String> listDia= new ArrayList<>();
    List<String> listHora= new ArrayList<>();
    List<String> listInstructor= new ArrayList<>();
    List<String> listPrograma= new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ihorario);
        initialize();
        listarDia();
        listarHora();
        listarInstructor();
        listarPrograma();
        listarUser();
        btnsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputHorario(v);
            }
        });
    }

    private void inputHorario(View v) {
        GestorDB gestorDB = new GestorDB(this);
        SQLiteDatabase db = gestorDB.getWritableDatabase();
        try {
            ContentValues values = new ContentValues();
            Horario horario = new Horario();

            horario.setDia(spDia.getSelectedItem().toString());
            horario.setHora(spHora.getSelectedItem().toString());

            Cursor cursorprograma =db.rawQuery("SELECT IDPROGRAMA FROM PROGRAMA WHERE NOMBRE ='"+spPrograma.getSelectedItem().toString()+"';",null);
            if (cursorprograma.moveToFirst()){
                do {
                    horario.setPrograma(cursorprograma.getInt(0));
                }while (cursorprograma.moveToNext());
            }


            Cursor cursorinstructor =db.rawQuery("SELECT IDINSTRUCTOR FROM INSTRUCTOR WHERE NOMBRE ='"+spInstructor.getSelectedItem().toString()+"';",null);
            if (cursorinstructor.moveToFirst()){
                do {
                    horario.setInstructor(cursorinstructor.getInt(0));
                }while (cursorinstructor.moveToNext());
            }

            cursorinstructor.close();

            horario.setUser(spUsuario.getSelectedItem().toString());

            cursorprograma.close();
            values.put("DIA",horario.getDia());
            values.put("HORA",horario.getHora());
            values.put("INSTRUCTOR",horario.getInstructor());
            values.put("PROGRAMA",horario.getPrograma());
            values.put("USER",horario.getUser());


            db.insert("HORARIO",null,values);
            Snackbar.make(v,"Se ha registrado satisfactoriamente", Snackbar.LENGTH_SHORT).show();



        }catch (Exception e){
            Snackbar.make(v,"Faltan campos por seleccionar", Snackbar.LENGTH_SHORT).show();
        }
        db.close();


    }

    public void initialize(){
        spDia = findViewById(R.id.spinnerDIH);
        spHora = findViewById(R.id.spinnerHHI);
        spInstructor = findViewById(R.id.spinnerIHI);
        spPrograma = findViewById(R.id.spinnerPHI);
        spUsuario = findViewById(R.id.spinnerHIJ);
        btnsave = findViewById(R.id.btnguardarHI);
    }

    public void listarDia(){
        listDia.add("Lunes");
        listDia.add("Martes");
        listDia.add("Miercoles");
        listDia.add("Jueves");
        listDia.add("Viernes");
        listDia.add("Sábado");
        ArrayAdapter adapter= new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, listDia);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spDia.setAdapter(adapter);

    }

    public void listarHora(){
        listHora.add("7-8");
        listHora.add("8-9");
        listHora.add("9-10");
        listHora.add("10-11");
        listHora.add("11-12");
        listHora.add("12-13");
        listHora.add("13-14");
        listHora.add("14-15");
        listHora.add("15-16");
        listHora.add("16-17");
        listHora.add("17-18");
        listHora.add("18-19");
        listHora.add("19-20");
        listHora.add("20-21");
        listHora.add("21-22");
        listHora.add("22-23");
        listHora.add("23-0");
        ArrayAdapter adapter= new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, listHora);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spHora.setAdapter(adapter);

    }

    public void listarInstructor(){
        listInstructor=consultaInstructor();
        ArrayAdapter adapter= new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, listInstructor);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spInstructor.setAdapter(adapter);

    }


    public void listarPrograma(){
        listPrograma = consultaPrograma();
        ArrayAdapter adapter= new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, listPrograma);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spPrograma.setAdapter(adapter);

    }
    public void listarUser(){
        ArrayAdapter adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item,consultaUser());
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spUsuario.setAdapter(adapter);
    }

    private List<String> consultaUser() {
        GestorDB gestorDB = new GestorDB(this);
        SQLiteDatabase db = gestorDB.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT USERNAME FROM USER;",null);
        List<String> results = new ArrayList<>();
        User user;
        if (cursor.moveToFirst()){
            do {
                user = new User();
                user.setName(cursor.getString(0));
                results.add(user.getName());

            }while (cursor.moveToNext());
        }
        cursor.close();
        db.close();


        return results;


    }


    public List<String> consultaInstructor(){
        GestorDB gestorDB = new GestorDB(this);
        List<String> resultados= new ArrayList<>();
        SQLiteDatabase db = gestorDB.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM INSTRUCTOR", null);
        Instructor instructor1;
        if (cursor.moveToFirst()){
            do {

                instructor1 = new Instructor();
                instructor1.setName(cursor.getString(1));

                resultados.add(instructor1.getName());

            }while(cursor.moveToNext());
        }
        return resultados;
    }



    public List<String> consultaPrograma(){
        GestorDB gestorDB = new GestorDB(this);
        List<String> resultados= new ArrayList<>();
        SQLiteDatabase db = gestorDB.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM PROGRAMA", null);
        Programa tmp;
        if (cursor.moveToFirst()){
            do {

                tmp = new Programa();
                tmp.setName(cursor.getString(1));

                resultados.add(tmp.getName());

            }while(cursor.moveToNext());
        }
        return resultados;
    }


}
