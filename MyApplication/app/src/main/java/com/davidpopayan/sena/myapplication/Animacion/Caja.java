
package com.davidpopayan.sena.myapplication.Animacion;


import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

import com.davidpopayan.sena.myapplication.Fragmentos.FragmentViewPlay;
import com.davidpopayan.sena.myapplication.R;

public class Caja extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_caja);


    }

    public void enviar4(View view) {
        Intent intent = new Intent(Caja.this, Infocaja.class);
        startActivity(intent);

    }

    public void back(View view) {
        finish();
    }
}
