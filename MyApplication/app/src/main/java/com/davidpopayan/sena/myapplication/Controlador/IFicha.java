package com.davidpopayan.sena.myapplication.Controlador;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.davidpopayan.sena.myapplication.Modelo.Ficha;
import com.davidpopayan.sena.myapplication.Modelo.GestorDB;
import com.davidpopayan.sena.myapplication.R;
import com.google.android.gms.maps.model.SquareCap;

import fr.ganfra.materialspinner.MaterialSpinner;

public class IFicha extends AppCompatActivity {
    EditText txtNumeroFicha;
    MaterialSpinner spInstructorL,spPrograma, spUser;
    Button btnsave;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ificha);
        inizialite();
        btnsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputFicha(v);
            }
        });
    }

    private void inputFicha(View v) {
        GestorDB gestorDB = new GestorDB(this);
        SQLiteDatabase db = gestorDB.getWritableDatabase();
        Ficha ficha;
        try {
            ficha = new Ficha();
            ficha.setnFicha(txtNumeroFicha.getText().toString());
            Cursor cursorInstructor = db.rawQuery("SELECT IDINSTRUCTOR FROM INSTRUCTOR WHERE NOMBRE= '"+spInstructorL+"' ;",null);
                if (cursorInstructor.moveToFirst()){
                    do {

                        ficha.setInstructorL(cursorInstructor.getInt(0));

                    }while (cursorInstructor.moveToNext());
                }

            Cursor cursorPrograma = db.rawQuery("SELECT IDPROGRAMA FROM PROGRAMA WHERE NOMBRE= '"+spPrograma+"' ;",null);
            if (cursorPrograma.moveToFirst()){
                do {

                    ficha.setPrograma(cursorPrograma.getInt(0));

                }while (cursorInstructor.moveToNext());
            }



        }catch (Exception e){
            Snackbar.make(v,"Faltan campos por seleccionar",Snackbar.LENGTH_SHORT).show();
        }

    }

    private void inizialite() {
        txtNumeroFicha = findViewById(R.id.txtNFicha);
        spInstructorL = findViewById(R.id.spinnerIFInstructorL);
        spPrograma = findViewById(R.id.spinnerIFPrograma);
        btnsave = findViewById(R.id.btnguardarIF);
    }


}
