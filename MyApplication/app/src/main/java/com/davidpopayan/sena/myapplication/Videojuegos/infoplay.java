package com.davidpopayan.sena.myapplication.Videojuegos;

import android.support.constraint.ConstraintLayout;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

import com.davidpopayan.sena.myapplication.Fragmentos.FragmentTextPlay;
import com.davidpopayan.sena.myapplication.Fragmentos.FragmentViewPlay;
import com.davidpopayan.sena.myapplication.R;

public class infoplay extends AppCompatActivity {
    Button btnVideo;
    FrameLayout contenedor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_infoplay);

        btnVideo = findViewById(R.id.btnVideo);

        Fragment fragment = new FragmentTextPlay();
        getSupportFragmentManager().beginTransaction().replace(R.id.contenedor,fragment).commit();

        btnVideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = new FragmentViewPlay();
                getSupportFragmentManager().beginTransaction().replace(R.id.contenedor,fragment).commit();
            }
        });
    }

    public void back(View view) {
        finish();
    }
}
