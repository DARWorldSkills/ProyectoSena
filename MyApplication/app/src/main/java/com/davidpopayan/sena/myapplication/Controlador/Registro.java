package com.davidpopayan.sena.myapplication.Controlador;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.davidpopayan.sena.myapplication.Modelo.User;
import com.davidpopayan.sena.myapplication.R;

public class Registro extends AppCompatActivity implements View.OnClickListener{

    Button btnusuario,btninstructor,btnficha,btnprograma,btnhorario;
    Button btncaeusuario,btncaeinstructor,btncaebtnficha,btncaeprograma,btncaehorario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        inizicialite();
        btnusuario.setOnClickListener(this);
        btninstructor.setOnClickListener(this);
        btnficha.setOnClickListener(this);
        btnprograma.setOnClickListener(this);
        btnhorario.setOnClickListener(this);
        btncaeusuario.setOnClickListener(this);
        btncaeinstructor.setOnClickListener(this);
        btncaebtnficha.setOnClickListener(this);
        btncaeprograma.setOnClickListener(this);
        btncaehorario.setOnClickListener(this);
    }

    public void inizicialite(){
        btnusuario= findViewById(R.id.btnuserR);
        btninstructor= findViewById(R.id.btninstructorR);
        btnficha= findViewById(R.id.btnfichaR);
        btnprograma= findViewById(R.id.btnprogramaR);
        btnhorario= findViewById(R.id.btnhorarioR);
        btncaeusuario= findViewById(R.id.btnuserR2);
        btncaeinstructor= findViewById(R.id.btninstructorR2);
        btncaebtnficha= findViewById(R.id.btnfichaR2);
        btncaeprograma= findViewById(R.id.btnprogramaR2);
        btncaehorario= findViewById(R.id.btnhorarioR2);
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()){
            case R.id.btnuserR:
                intent= new Intent(Registro.this, IUser.class);
                startActivity(intent);
                break;

            case R.id.btninstructorR:
                intent= new Intent(Registro.this, IInstructor.class);
                startActivity(intent);
                break;

            case R.id.btnfichaR:
                intent= new Intent(Registro.this,IFicha.class);
                startActivity(intent);
                break;

            case R.id.btnprogramaR:
                intent= new Intent(Registro.this, IPrograma.class);
                startActivity(intent);
                break;

            case R.id.btnhorarioR:
                intent= new Intent(Registro.this, IHorario.class);
                startActivity(intent);
                break;

            case R.id.btnuserR2:
                intent= new Intent(Registro.this, CUser.class);
                startActivity(intent);
                break;

            case R.id.btninstructorR2:
                intent= new Intent(Registro.this, CInstructor.class);
                startActivity(intent);
                break;

            case R.id.btnfichaR2:
                intent= new Intent(Registro.this,CFicha.class);
                startActivity(intent);
                break;

            case R.id.btnprogramaR2:

                intent= new Intent(Registro.this, CPrograma.class);
                startActivity(intent);
                break;

            case R.id.btnhorarioR2:
                intent= new Intent(Registro.this, CHorario.class);
                startActivity(intent);
                break;




        }

    }
}
