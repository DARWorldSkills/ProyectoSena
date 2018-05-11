package com.davidpopayan.sena.myapplication.Controlador;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;


import com.davidpopayan.sena.myapplication.Modelo.GestorDB;
import com.davidpopayan.sena.myapplication.Modelo.User;
import com.davidpopayan.sena.myapplication.R;

import java.util.ArrayList;
import java.util.List;

import fr.ganfra.materialspinner.MaterialSpinner;

public class CUser extends AppCompatActivity {
    EditText txtpass;
    MaterialSpinner spinnerUser,spinnerRol;
    Button btndelete, btnupdate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cuser);
        inizialite();
        listarUsers();
        listarRol();
        btnupdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateUser(v);
            }
        });
        btndelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteUser(v);
            }
        });
    }

    private void deleteUser(View v) {
        GestorDB gestorDB = new GestorDB(this);
        SQLiteDatabase db = gestorDB.getWritableDatabase();
        try{
            User user = new User();
            user.setName(spinnerUser.getSelectedItem().toString());

            String[] parameters = {user.getName()};
            db.delete("HORARIO","INSTRUCTOR =?",parameters);
            db.delete("USER","NOMBRE =?",parameters);

            Snackbar.make(v, "Se ha eliminado satisfactoriamente", Snackbar.LENGTH_SHORT).show();
        }catch (Exception e){
            Snackbar.make(v, "No ha seleccionado al usuario que desea eliminar", Snackbar.LENGTH_SHORT).show();
        }

    }

    private void updateUser(View v) {
        GestorDB gestorDB = new GestorDB(this);
        SQLiteDatabase db = gestorDB.getWritableDatabase();
        ContentValues values = new ContentValues();
        try{
            User user = new User();

            user.setName(spinnerUser.getSelectedItem().toString());
            user.setPassword(txtpass.getText().toString());
            user.setRol(spinnerRol.getSelectedItem().toString());

            String[] parameters = {user.getName()};
            values.put("CLAVE",user.getPassword());
            values.put("ROL",user.getRol());

            db.update("USER",values,"NOMRBE =?",parameters);
            Snackbar.make(v, "Se ha actualizado a "+user.getName(), Snackbar.LENGTH_SHORT).show();

            cleanm();

        }catch (Exception e){
            Snackbar.make(v, "Faltan campos por llenar", Snackbar.LENGTH_SHORT).show();
        }

    }

    private void cleanm() {
        txtpass.setText("");
    }


    public void inizialite(){
        spinnerUser= findViewById(R.id.spinnerCU);
        txtpass = findViewById(R.id.txtpassCU);
        spinnerRol = findViewById(R.id.spinnerCR);
        btndelete = findViewById(R.id.btneliminarU);
        btnupdate = findViewById(R.id.btnactualizarU);

    }

    public void listarUsers(){
        List<String> listau = consularBD();
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,android.R.layout.simple_spinner_dropdown_item,listau);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerUser.setAdapter(adapter);

    }

    public void listarRol() {
        List<String> listItems = new ArrayList<>();
        listItems.add("Administrador");
        listItems.add("Instructor");
        ArrayAdapter<String> adapter= new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, listItems);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerRol.setAdapter(adapter);
        spinnerRol.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


    }

    public List<String> consularBD(){
        GestorDB gestorDB = new GestorDB(this);
        SQLiteDatabase db = gestorDB.getWritableDatabase();
        List<String> results = new ArrayList<>();
        Cursor cursor = db.rawQuery("SELECT * FROM USER",null);
        if (cursor.moveToFirst()){
            do {
                User user  = new User();
                user.setName(spinnerUser.getSelectedItem().toString());

                results.add(user.getName());

            }while (cursor.moveToNext());
            cursor.close();
        }

        return results;


    }





}
