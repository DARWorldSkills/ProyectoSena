package com.davidpopayan.sena.myapplication.Controlador;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;

import com.davidpopayan.sena.myapplication.R;

import java.util.Timer;
import java.util.TimerTask;

public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        TimerTask splash= new TimerTask() {
            @Override
            public void run() {
                Intent intent = new Intent(Splash.this, Menu.class);
                startActivity(intent);
            }
        };

        Timer timer = new Timer();
        timer.schedule(splash, 1000);
    }
}
