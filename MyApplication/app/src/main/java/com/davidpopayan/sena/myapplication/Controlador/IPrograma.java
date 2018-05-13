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
import com.davidpopayan.sena.myapplication.Modelo.Programa;
import com.davidpopayan.sena.myapplication.R;


public class IPrograma extends AppCompatActivity {
    EditText txtname, txtdes,txtvid, txtico;
    Button btnsave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iprograma);
        initialize();
        btnsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputPrograma(v);
            }
        });
    }

    private void initialize() {
        txtname = findViewById(R.id.txtprogramaIP);
        txtdes = findViewById(R.id.txtdesIP);
        txtvid = findViewById(R.id.txturlvIP);
        txtico = findViewById(R.id.txturlicoIP);
        btnsave = findViewById(R.id.btnguardarIP);
    }

    public void inputPrograma(View v){
        GestorDB gestorDB = new GestorDB(this);
        SQLiteDatabase db = gestorDB.getWritableDatabase();
        try {
            Programa newPrograma= new Programa();
            newPrograma.setName(txtname.getText().toString());
            newPrograma.setDescription(txtdes.getText().toString());
            newPrograma.setIcono(txtvid.getText().toString());
            newPrograma.setVideo(txtico.getText().toString());
            ContentValues values = new ContentValues();
            values.put("NOMBRE", newPrograma.getName());
            values.put("DESCRIPCION", newPrograma.getDescription());
            values.put("ICONO", newPrograma.getIcono());
            values.put("VIDEO", newPrograma.getVideo());
            db.insert("PROGRAMA", null,values);
            Snackbar.make(v,"Se ha agregado correctamente", Snackbar.LENGTH_SHORT).show();
            cleanm();

        }catch (Exception e){
            Snackbar.make(v,"Faltan campos", Snackbar.LENGTH_SHORT).show();
        }
        db.close();


    }

    private void cleanm() {
        txtdes.setText("");
        txtico.setText("");
        txtname.setText("");
        txtvid.setText("");
    }


}
