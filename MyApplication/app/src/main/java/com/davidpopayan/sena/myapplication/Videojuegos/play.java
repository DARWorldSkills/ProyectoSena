package com.davidpopayan.sena.myapplication.Videojuegos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.davidpopayan.sena.myapplication.R;

public class play extends AppCompatActivity {
    TextView info;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);

        info = findViewById(R.id.envio);


    }

    public void enviar(View view) {
        Intent intent = new Intent(play.this, infoplay.class);
        startActivity(intent);

    }

    public void back(View view) {
        finish();
    }
}
