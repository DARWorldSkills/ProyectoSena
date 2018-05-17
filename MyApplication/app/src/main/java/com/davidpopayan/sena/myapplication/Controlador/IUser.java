package com.davidpopayan.sena.myapplication.Controlador;

import android.content.ContentValues;
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

public class IUser extends AppCompatActivity {
    EditText txtusername, txtpass;
    MaterialSpinner spinner;
    Button btnsave;
    List<String> listItems= new ArrayList<>();
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iuser);
        inicializate();
        listRol();
        btnsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputUser(v);
            }
        });

    }

    public void inicializate(){
        txtusername = findViewById(R.id.txtusernameIU);
        txtpass = findViewById(R.id.txtpassIU);
        spinner = findViewById(R.id.spinnerRolIU);
        btnsave = findViewById(R.id.btnguardarIU);
    }

    public void inputUser(View v){
        GestorDB gestorDB = new GestorDB(this);
        SQLiteDatabase db = gestorDB.getWritableDatabase();
        ContentValues contentValues= new ContentValues();
        try {
            User newuser = new User();
            newuser.setName(txtusername.getText().toString());
            newuser.setPassword(txtpass.getText().toString());
            newuser.setRol(spinner.getSelectedItem().toString());

            contentValues.put("USERNAME",newuser.getName());
            contentValues.put("CLAVE",newuser.getPassword());
            contentValues.put("ROL",newuser.getRol());
            db.insert("USER",null,contentValues);
            Snackbar.make(v,"Se ha guardado correctamente", Snackbar.LENGTH_SHORT).show();
            cleanm();
        }catch (Exception e){
            Snackbar.make(v,"Faltan Datos", Snackbar.LENGTH_SHORT).show();

        }

        db.close();


    }

    private void cleanm() {
        txtusername.setText("");
        txtpass.setText("");
    }

    public void listRol(){
        listItems.add("Administrador");
        listItems.add("Instructor");
        adapter= new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, listItems);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


    }

}
