package com.davidpopayan.sena.myapplication.Controlador;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.davidpopayan.sena.myapplication.Animacion.Caja;
import com.davidpopayan.sena.myapplication.Especializacion.especializacion;
import com.davidpopayan.sena.myapplication.R;
import com.davidpopayan.sena.myapplication.Videojuegos.play;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    Button btn1,btn2,btn3;
    Thread reloj;
    TextView textViewReloj,textViewDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1 = findViewById(R.id.hola);
        btn2 = findViewById(R.id.hola2);
        btn3 = findViewById(R.id.hola3);
        textViewReloj = findViewById(R.id.txtHora);
        textViewDate = findViewById(R.id.txtDate);


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

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, play.class);
                startActivity(intent);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Caja.class);
                startActivity(intent);
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, especializacion.class);
                startActivity(intent);
            }
        });
    }
}
