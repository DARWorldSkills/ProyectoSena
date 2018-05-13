package com.davidpopayan.sena.myapplication.Controlador;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.davidpopayan.sena.myapplication.Animacion.Caja;
import com.davidpopayan.sena.myapplication.Especializacion.especializacion;
import com.davidpopayan.sena.myapplication.Login.LoginActivity;
import com.davidpopayan.sena.myapplication.Modelo.GestorDB;
import com.davidpopayan.sena.myapplication.Modelo.User;
import com.davidpopayan.sena.myapplication.R;
import com.davidpopayan.sena.myapplication.Videojuegos.play;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Button btn1,btn2,btn3,btnlogin,btnregistro;
    Thread reloj;
    TextView textViewReloj,textViewDate;
    int respuesta=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        createSU();
        btn1 = findViewById(R.id.hola);
        btn2 = findViewById(R.id.hola2);
        btn3 = findViewById(R.id.hola3);
        btnlogin = findViewById(R.id.btnloginA);
        btnregistro = findViewById(R.id.btnregistroA);
        textViewReloj = findViewById(R.id.txtHora);
        textViewDate = findViewById(R.id.txtDate);
        btnregistro.setVisibility(View.INVISIBLE);
        btnlogin.setOnClickListener(this);
        btnregistro.setOnClickListener(this);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);



        reloj = new Thread(new Runnable() {
            @Override
            public void run() {

                while(true) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Date date= new Date();

                            SimpleDateFormat dateForma = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
                            SimpleDateFormat dateFormat = new SimpleDateFormat("hh:mm:ss a", Locale.getDefault());
                            textViewReloj.setText(dateFormat.format(date));
                            textViewDate.setText(dateForma.format(date));
                        }
                    });


                }
            }
        });
        reloj.start();


    }

    private void createSU() {
        GestorDB gestorDB = new GestorDB(this);
        SQLiteDatabase db = gestorDB.getWritableDatabase();
        ContentValues contentValues= new ContentValues();
        try {
            User newuser = new User();
            newuser.setName("root1");
            newuser.setPassword("root1234");
            newuser.setRol("Administrador");

            contentValues.put("USERNAME",newuser.getName());
            contentValues.put("CLAVE",newuser.getPassword());
            contentValues.put("ROL",newuser.getRol());
            db.insert("USER",null,contentValues);
        }catch (Exception e){
            Toast.makeText(this, "Bienvenido", Toast.LENGTH_SHORT).show();

        }

        db.close();

    }

    @Override
    protected void onStart() {
        super.onStart();
        respuesta=LoginActivity.respuesta;
        if (respuesta==1){
            btnlogin.setText(getString(R.string.logout));
            btnregistro.setVisibility(View.VISIBLE);
            LoginActivity.respuesta=0;


        }
    }

    @Override
    protected void onResume() {
        super.onResume();



    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()){
            case R.id.hola:
                intent = new Intent(MainActivity.this, play.class);
                startActivity(intent);
                break;
            case R.id.hola2:
                intent = new Intent(MainActivity.this, Caja.class);
                startActivity(intent);
                break;
            case R.id.hola3:
                intent = new Intent(MainActivity.this, especializacion.class);
                startActivity(intent);
                break;
            case R.id.btnloginA:
                if (btnlogin.getText().equals(getString(R.string.login))){
                    intent = new Intent(MainActivity.this, LoginActivity.class);
                    startActivity(intent);

                }

                if (btnlogin.getText().equals(getString(R.string.logout))){
                    btnlogin.setText(getString(R.string.login));
                    btnregistro.setVisibility(View.INVISIBLE);
                    Snackbar.make(v,"Ha cerrado sesión",Snackbar.LENGTH_SHORT).show();
                }
                break;
            case R.id.btnregistroA:
                intent = new Intent(MainActivity.this, Registro.class);
                startActivity(intent);
                break;




        }



    }




}
