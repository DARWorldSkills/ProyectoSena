package com.davidpopayan.sena.myapplication.Controlador;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.davidpopayan.sena.myapplication.Modelo.GestorDB;
import com.davidpopayan.sena.myapplication.Modelo.Instructor;
import com.davidpopayan.sena.myapplication.R;


public class IInstructor extends AppCompatActivity {
    EditText txtnombre, txttelefono, txtcorreo;
    Button btnsave;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iinstructor);
        inicializar();
        btnsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputInstructor(v);
            }
        });
    }

    private void inicializar() {
        txtnombre= findViewById(R.id.txtnameII);
        txttelefono= findViewById(R.id.txtemailII);
        txtcorreo= findViewById(R.id.txtphoneII);
        btnsave= findViewById(R.id.btnguardarII);

    }

    public void inputInstructor(View v) {
        Snackbar.make(v, "Se ha registrado completamente", Snackbar.LENGTH_SHORT);
        GestorDB gestorDB = new GestorDB(this);
        SQLiteDatabase db = gestorDB.getWritableDatabase();
        try{
            Instructor newInstructor= new Instructor();
            newInstructor.setName(txtnombre.getText().toString());
            newInstructor.setPhone(txttelefono.getText().toString());
            newInstructor.setEmail(txtcorreo.getText().toString());
            ContentValues values = new ContentValues();
            values.put("NOMBRE",newInstructor.getName());
            values.put("TELEFONO",newInstructor.getPhone());
            values.put("CORREO",newInstructor.getEmail());
            db.insert("INSTRUCTOR",null,values);
            Snackbar.make(v, "Se ha registrado satisfactoriamente", Snackbar.LENGTH_SHORT).show();
            cleanm();


        }catch (Exception e){
            Snackbar.make(v, "Faltan campos por llenar", Snackbar.LENGTH_SHORT);
        }

        db.close();



    }

    public void cleanm(){
        txtnombre.setText("");
        txttelefono.setText("");
        txtcorreo.setText("");
    }


}
