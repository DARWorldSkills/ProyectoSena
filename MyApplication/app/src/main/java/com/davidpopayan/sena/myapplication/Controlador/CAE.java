package com.davidpopayan.sena.myapplication.Controlador;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import com.davidpopayan.sena.myapplication.R;

public class CAE extends AppCompatActivity implements View.OnClickListener{
    Button btnUser, btnPrograma, btnJornada, btnInstructor, btnHorario;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cae);
        inizialite();


    }

    private void inizialite() {
        btnUser = findViewById(R.id.btnUserCAE);
        btnPrograma = findViewById(R.id.btnProgramaCAE);
        btnJornada = findViewById(R.id.btnJornadaCAE);
        btnInstructor = findViewById(R.id.btnInstructorCAE);
        btnHorario = findViewById(R.id.btnHorariosCAE);
    }


    @Override
    public void onClick(View v) {
        Intent intent =new Intent();
        switch (v.getId()){
            case(R.id.btnUserCAE):
                intent= new Intent(CAE.this,CUser.class);
                startActivity(intent);
                break;
            case(R.id.btnProgramaCAE):
                intent= new Intent(CAE.this,CPrograma.class);
                startActivity(intent);
                break;
            case(R.id.btnJornadaCAE):
                intent= new Intent(CAE.this,CJornada.class);
                startActivity(intent);
                break;
            case(R.id.btnInstructorCAE):
                intent= new Intent(CAE.this,CInstructor.class);
                startActivity(intent);
                break;
            case(R.id.btnHorariosCAE):
                intent= new Intent(CAE.this,CHorario.class);
                startActivity(intent);
                break;
        }
    }
}
