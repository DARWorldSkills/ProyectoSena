package com.davidpopayan.sena.myapplication.Especializacion;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.davidpopayan.sena.myapplication.R;

public class especializacion extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_especializacion);
    }

    public void enviar3(View view) {
        Intent intent = new Intent(especializacion.this, infoespeci.class);
        startActivity(intent);
    }

    public void back(View view) {
        finish();
    }
}
