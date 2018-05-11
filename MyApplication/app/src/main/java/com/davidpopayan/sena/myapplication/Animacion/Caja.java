
package com.davidpopayan.sena.myapplication.Animacion;


import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.davidpopayan.sena.myapplication.Modelo.GestorDB;
import com.davidpopayan.sena.myapplication.R;

public class Caja extends AppCompatActivity {
    TextView txtcampo9lunes,txtcampo10lunes,txtcampo11lunes,txtcampo12lunes,txtcampo13lunes,txtcampo14lunes;
    TextView txtcampo9martes,txtcampo10martes,txtcampo11martes,txtcampo12martes,txtcampo13martes,txtcampo14martes;
    TextView txtcampo9miercoles,txtcampo10miercoles,txtcampo11miercoles,txtcampo12miercoles,txtcampo13miercoles,txtcampo14miercoles;
    TextView txtcampo9jueves,txtcampo10jueves,txtcampo11jueves,txtcampo12jueves,txtcampo13jueves,txtcampo14jueves;
    TextView txtcampo9viernes,txtcampo10viernes,txtcampo11viernes,txtcampo12viernes,txtcampo13viernes,txtcampo14viernes;
    TextView txtcampo9sabado,txtcampo10sabado,txtcampo11sabado,txtcampo12sabado,txtcampo13sabado,txtcampo14sabado;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_caja);
        inicializartabla();
        llenarTabla();


    }

    public void inicializartabla(){
        txtcampo9lunes= findViewById(R.id.campo9lunes);
        txtcampo10lunes= findViewById(R.id.campo10lunes);
        txtcampo11lunes= findViewById(R.id.campo11lunes);
        txtcampo12lunes= findViewById(R.id.campo12lunes);
        txtcampo13lunes= findViewById(R.id.campo13lunes);
        txtcampo14lunes= findViewById(R.id.campo14lunes);

        txtcampo9martes= findViewById(R.id.campo9martes);
        txtcampo10martes= findViewById(R.id.campo10martes);
        txtcampo11martes= findViewById(R.id.campo11martes);
        txtcampo12martes= findViewById(R.id.campo12martes);
        txtcampo13martes= findViewById(R.id.campo13martes);
        txtcampo14martes= findViewById(R.id.campo14martes);

        txtcampo9miercoles= findViewById(R.id.campo9miercoles);
        txtcampo10miercoles= findViewById(R.id.campo10miercoles);
        txtcampo11miercoles= findViewById(R.id.campo11miercoles);
        txtcampo12miercoles= findViewById(R.id.campo12miercoles);
        txtcampo13miercoles= findViewById(R.id.campo13miercoles);
        txtcampo14miercoles= findViewById(R.id.campo14miercoles);

        txtcampo9jueves= findViewById(R.id.campo9jueves);
        txtcampo10jueves= findViewById(R.id.campo10jueves);
        txtcampo11jueves= findViewById(R.id.campo11jueves);
        txtcampo12jueves= findViewById(R.id.campo12jueves);
        txtcampo13jueves= findViewById(R.id.campo13jueves);
        txtcampo14jueves= findViewById(R.id.campo14jueves);

        txtcampo9viernes= findViewById(R.id.campo9viernes);
        txtcampo10viernes= findViewById(R.id.campo10viernes);
        txtcampo11viernes= findViewById(R.id.campo11viernes);
        txtcampo12viernes= findViewById(R.id.campo12viernes);
        txtcampo13viernes= findViewById(R.id.campo13viernes);
        txtcampo14viernes= findViewById(R.id.campo14viernes);

        txtcampo9sabado= findViewById(R.id.campo9sabado);
        txtcampo10sabado= findViewById(R.id.campo10sabado);
        txtcampo11sabado= findViewById(R.id.campo11sabado);
        txtcampo12sabado= findViewById(R.id.campo12sabado);
        txtcampo13sabado= findViewById(R.id.campo13sabado);
        txtcampo14sabado= findViewById(R.id.campo14sabado);



    }

    public void llenarTabla(){
        GestorDB gestorBD = new GestorDB(this);
        SQLiteDatabase db = gestorBD.getReadableDatabase();

        //Llendano lunes

        int tmp;
        try {
            tmp = (db.rawQuery("SELECT INSTRUCTOR FROM HORARIO WHERE JORNADA = 1 AND DIA = 'Lunes' AND HORA = '13-14' ;", null).getInt(0));
        }catch (Exception e){
            tmp=0;
        }
        txtcampo9lunes.setText(db.rawQuery("SELECT NOMBRE FROM INSTRUCTOR WHERE IDINSTRUCTOR = "+tmp+";",null).getString(0));
        try{tmp=(db.rawQuery("SELECT INSTRUCTOR FROM HORARIO WHERE JORNADA = 1 AND DIA = 'Lunes' AND HORA = '14-15' ;",null).getInt(0));}
        catch (Exception e){
            tmp=0;
        }
        txtcampo10lunes.setText(db.rawQuery("SELECT NOMBRE FROM INSTRUCTOR WHERE IDINSTRUCTOR = "+tmp+";",null).getString(0));
        try{
            tmp=(db.rawQuery("SELECT INSTRUCTOR FROM HORARIO WHERE JORNADA = 1 AND DIA = 'Lunes' AND HORA = '15-16' ;",null).getInt(0));
        }catch (Exception e){
            tmp=0;
        }
        txtcampo11lunes.setText(db.rawQuery("SELECT NOMBRE FROM INSTRUCTOR WHERE IDINSTRUCTOR = " + tmp + ";", null).getString(0));
        try {
            tmp=(db.rawQuery("SELECT INSTRUCTOR FROM HORARIO WHERE JORNADA = 1 AND DIA = 'Lunes' AND HORA = '16-17' ;",null).getInt(0));
        }
        catch (Exception e){
            tmp=0;
        }

        txtcampo12lunes.setText(db.rawQuery("SELECT NOMBRE FROM INSTRUCTOR WHERE IDINSTRUCTOR = "+tmp+";",null).getString(0));

        try{
            tmp=(db.rawQuery("SELECT INSTRUCTOR FROM HORARIO WHERE JORNADA = 1 AND DIA = 'Lunes' AND HORA = '17-18' ;",null).getInt(0));
        }catch (Exception e){
            tmp=0;
        }

        txtcampo13lunes.setText(db.rawQuery("SELECT NOMBRE FROM INSTRUCTOR WHERE IDINSTRUCTOR = "+tmp+";",null).getString(0));

        try{
            tmp=(db.rawQuery("SELECT INSTRUCTOR FROM HORARIO WHERE JORNADA = 1 AND DIA = 'Lunes' AND HORA = '18-19' ;",null).getInt(0));
        }catch (Exception e){
            tmp=0;
        }

        txtcampo14lunes.setText(db.rawQuery("SELECT NOMBRE FROM INSTRUCTOR WHERE IDINSTRUCTOR = "+tmp+";",null).getString(0));

        int tmp1, tmp2, tmp3, tmp4, tmp5, tmp6;
        try {
            tmp1=(db.rawQuery("SELECT INSTRUCTOR FROM HORARIO WHERE JORNADA = 1 AND DIA = 'Martes' AND HORA = '13-14' ;",null).getInt(0));
        }catch (Exception e){
            tmp1=0;
        }
        try {
            tmp2=(db.rawQuery("SELECT INSTRUCTOR FROM HORARIO WHERE JORNADA = 1 AND DIA = 'Martes' AND HORA = '14-15' ;",null).getInt(0));
        }catch (Exception e){
            tmp2=0;
        }

        try {
            tmp3=(db.rawQuery("SELECT INSTRUCTOR FROM HORARIO WHERE JORNADA = 1 AND DIA = 'Martes' AND HORA = '15-16' ;",null).getInt(0));
        }catch (Exception e){
            tmp3=0;
        }

        try{
            tmp4=(db.rawQuery("SELECT INSTRUCTOR FROM HORARIO WHERE JORNADA = 1 AND DIA = 'Martes' AND HORA = '16-17' ;",null).getInt(0));
        }catch (Exception e){
            tmp4=0;
        }

        try{
            tmp5=(db.rawQuery("SELECT INSTRUCTOR FROM HORARIO WHERE JORNADA = 1 AND DIA = 'Martes' AND HORA = '17-18' ;",null).getInt(0));

        }catch (Exception e){
            tmp5=0;
        }
        try {
            tmp6=(db.rawQuery("SELECT INSTRUCTOR FROM HORARIO WHERE JORNADA = 1 AND DIA = 'Martes' AND HORA = '18-19' ;",null).getInt(0));
        }catch (Exception e){
            tmp6=0;
        }


        txtcampo9martes.setText(db.rawQuery("SELECT NOMBRE FROM INSTRUCTOR WHERE IDINSTRUCTOR = "+tmp1+";",null).getString(0));
        txtcampo10martes.setText(db.rawQuery("SELECT NOMBRE FROM INSTRUCTOR WHERE IDINSTRUCTOR = "+tmp2+";",null).getString(0));
        txtcampo11martes.setText(db.rawQuery("SELECT NOMBRE FROM INSTRUCTOR WHERE IDINSTRUCTOR = "+tmp3+";",null).getString(0));
        txtcampo12martes.setText(db.rawQuery("SELECT NOMBRE FROM INSTRUCTOR WHERE IDINSTRUCTOR = "+tmp4+";",null).getString(0));
        txtcampo13martes.setText(db.rawQuery("SELECT NOMBRE FROM INSTRUCTOR WHERE IDINSTRUCTOR = "+tmp5+";",null).getString(0));
        txtcampo14martes.setText(db.rawQuery("SELECT NOMBRE FROM INSTRUCTOR WHERE IDINSTRUCTOR = "+tmp6+";",null).getString(0));

        try {

            tmp=(db.rawQuery("SELECT INSTRUCTOR FROM HORARIO WHERE JORNADA = 1 AND DIA = 'Miercoles' AND HORA = '13-14' ;",null).getInt(0));
        }
        catch (Exception e){
            tmp=0;
        }

        txtcampo9miercoles.setText(db.rawQuery("SELECT NOMBRE FROM INSTRUCTOR WHERE IDINSTRUCTOR = "+tmp+";",null).getString(0));
        try {
            tmp = (db.rawQuery("SELECT INSTRUCTOR FROM HORARIO WHERE JORNADA = 1 AND DIA = 'Miercoles' AND HORA = '14-15' ;", null).getInt(0));
        }catch (Exception e){
            tmp=0;
        }
        txtcampo10miercoles.setText(db.rawQuery("SELECT NOMBRE FROM INSTRUCTOR WHERE IDINSTRUCTOR = "+tmp+";",null).getString(0));
        try {
            tmp=(db.rawQuery("SELECT INSTRUCTOR FROM HORARIO WHERE JORNADA = 1 AND DIA = 'Miercoles' AND HORA = '15-16' ;",null).getInt(0));
        }catch (Exception e){
            tmp=0;
        }

        txtcampo11miercoles.setText(db.rawQuery("SELECT NOMBRE FROM INSTRUCTOR WHERE IDINSTRUCTOR = "+tmp+";",null).getString(0));
        try {
            tmp=(db.rawQuery("SELECT INSTRUCTOR FROM HORARIO WHERE JORNADA = 1 AND DIA = 'Miercoles' AND HORA = '16-17' ;",null).getInt(0));
        }catch (Exception e){
            tmp=0;
        }
        txtcampo12miercoles.setText(db.rawQuery("SELECT NOMBRE FROM INSTRUCTOR WHERE IDINSTRUCTOR = "+tmp+";",null).getString(0));

        try {

            tmp=(db.rawQuery("SELECT INSTRUCTOR FROM HORARIO WHERE JORNADA = 1 AND DIA = 'Miercoles' AND HORA = '17-18' ;",null).getInt(0));
        }catch (Exception e){
            tmp=0;
        }

        txtcampo13miercoles.setText(db.rawQuery("SELECT NOMBRE FROM INSTRUCTOR WHERE IDINSTRUCTOR = "+tmp+";",null).getString(0));
        try {
            tmp=(db.rawQuery("SELECT INSTRUCTOR FROM HORARIO WHERE JORNADA = 1 AND DIA = 'Miercoles' AND HORA = '18-19' ;",null).getInt(0));
        }catch (Exception e){
            tmp=0;
        }

        txtcampo14miercoles.setText(db.rawQuery("SELECT NOMBRE FROM INSTRUCTOR WHERE IDINSTRUCTOR = "+tmp+";",null).getString(0));
        try{
            tmp=(db.rawQuery("SELECT INSTRUCTOR FROM HORARIO WHERE JORNADA = 1 AND DIA = 'Jueves' AND HORA = '13-14' ;",null).getInt(0));

        }catch (Exception e){
            tmp=0;
        }
        txtcampo9jueves.setText(db.rawQuery("SELECT NOMBRE FROM INSTRUCTOR WHERE IDINSTRUCTOR = "+tmp+";",null).getString(0));
        try{
            tmp=(db.rawQuery("SELECT INSTRUCTOR FROM HORARIO WHERE JORNADA = 1 AND DIA = 'Jueves' AND HORA = '14-15' ;",null).getInt(0));

        }catch (Exception e){
            tmp=0;
        }
        txtcampo10jueves.setText(db.rawQuery("SELECT NOMBRE FROM INSTRUCTOR WHERE IDINSTRUCTOR = "+tmp+";",null).getString(0));
        try{
            tmp=(db.rawQuery("SELECT INSTRUCTOR FROM HORARIO WHERE JORNADA = 1 AND DIA = 'Jueves' AND HORA = '15-16' ;",null).getInt(0));

        }catch (Exception e){
            tmp=0;
        }
        txtcampo11jueves.setText(db.rawQuery("SELECT NOMBRE FROM INSTRUCTOR WHERE IDINSTRUCTOR = "+tmp+";",null).getString(0));
        try{
            tmp=(db.rawQuery("SELECT INSTRUCTOR FROM HORARIO WHERE JORNADA = 1 AND DIA = 'Jueves' AND HORA = '16-17' ;",null).getInt(0));

        }catch (Exception e){
            tmp=0;
        }
        txtcampo12jueves.setText(db.rawQuery("SELECT NOMBRE FROM INSTRUCTOR WHERE IDINSTRUCTOR = "+tmp+";",null).getString(0));
        try{

            tmp=(db.rawQuery("SELECT INSTRUCTOR FROM HORARIO WHERE JORNADA = 1 AND DIA = 'Jueves' AND HORA = '17-18' ;",null).getInt(0));
        }catch (Exception e){
            tmp=0;
        }
        txtcampo13jueves.setText(db.rawQuery("SELECT NOMBRE FROM INSTRUCTOR WHERE IDINSTRUCTOR = "+tmp+";",null).getString(0));
        try{
            tmp=(db.rawQuery("SELECT INSTRUCTOR FROM HORARIO WHERE JORNADA = 1 AND DIA = 'Jueves' AND HORA = '18-19' ;",null).getInt(0));

        }catch (Exception e){
            tmp=0;
        }
        txtcampo14jueves.setText(db.rawQuery("SELECT NOMBRE FROM INSTRUCTOR WHERE IDINSTRUCTOR = "+tmp+";",null).getString(0));


        try{
            tmp=(db.rawQuery("SELECT INSTRUCTOR FROM HORARIO WHERE JORNADA = 1 AND DIA = 'Viernes' AND HORA = '13-14' ;",null).getInt(0));

        }catch (Exception e){
            tmp=0;
        }
        txtcampo9viernes.setText(db.rawQuery("SELECT NOMBRE FROM INSTRUCTOR WHERE IDINSTRUCTOR = "+tmp+";",null).getString(0));
        try{
            tmp=(db.rawQuery("SELECT INSTRUCTOR FROM HORARIO WHERE JORNADA = 1 AND DIA = 'Viernes' AND HORA = '14-15' ;",null).getInt(0));

        }catch (Exception e){
            tmp=0;
        }
        txtcampo10viernes.setText(db.rawQuery("SELECT NOMBRE FROM INSTRUCTOR WHERE IDINSTRUCTOR = "+tmp+";",null).getString(0));
        try{

            tmp=(db.rawQuery("SELECT INSTRUCTOR FROM HORARIO WHERE JORNADA = 1 AND DIA = 'Viernes' AND HORA = '15-16' ;",null).getInt(0));
        }catch (Exception e){
            tmp=0;
        }
        txtcampo11viernes.setText(db.rawQuery("SELECT NOMBRE FROM INSTRUCTOR WHERE IDINSTRUCTOR = "+tmp+";",null).getString(0));
        try{

            tmp=(db.rawQuery("SELECT INSTRUCTOR FROM HORARIO WHERE JORNADA = 1 AND DIA = 'Viernes' AND HORA = '16-17' ;",null).getInt(0));
        }catch (Exception e){
            tmp=0;
        }
        txtcampo12viernes.setText(db.rawQuery("SELECT NOMBRE FROM INSTRUCTOR WHERE IDINSTRUCTOR = "+tmp+";",null).getString(0));
        try{

            tmp=(db.rawQuery("SELECT INSTRUCTOR FROM HORARIO WHERE JORNADA = 1 AND DIA = 'Viernes' AND HORA = '17-18' ;",null).getInt(0));
        }catch (Exception e){
            tmp=0;
        }
        txtcampo13viernes.setText(db.rawQuery("SELECT NOMBRE FROM INSTRUCTOR WHERE IDINSTRUCTOR = "+tmp+";",null).getString(0));
        try{
            tmp=(db.rawQuery("SELECT INSTRUCTOR FROM HORARIO WHERE JORNADA = 1 AND DIA = 'Viernes' AND HORA = '18-19' ;",null).getInt(0));

        }catch (Exception e){
            tmp=0;
        }
        txtcampo14viernes.setText(db.rawQuery("SELECT NOMBRE FROM INSTRUCTOR WHERE IDINSTRUCTOR = "+tmp+";",null).getString(0));

        try{

            tmp=(db.rawQuery("SELECT INSTRUCTOR FROM HORARIO WHERE JORNADA = 1 AND DIA = 'Sábado' AND HORA = '13-14' ;",null).getInt(0));
        }catch (Exception e){
            tmp=0;
        }
        txtcampo9sabado.setText(db.rawQuery("SELECT NOMBRE FROM INSTRUCTOR WHERE IDINSTRUCTOR = "+tmp+";",null).getString(0));
        try{

            tmp=(db.rawQuery("SELECT INSTRUCTOR FROM HORARIO WHERE JORNADA = 1 AND DIA = 'Sábado' AND HORA = '14-15' ;",null).getInt(0));
        }catch (Exception e){
            tmp=0;
        }
        txtcampo10sabado.setText(db.rawQuery("SELECT NOMBRE FROM INSTRUCTOR WHERE IDINSTRUCTOR = "+tmp+";",null).getString(0));
        try{
            tmp=(db.rawQuery("SELECT INSTRUCTOR FROM HORARIO WHERE JORNADA = 1 AND DIA = 'Sábado' AND HORA = '15-16' ;",null).getInt(0));

        }catch (Exception e){
            tmp=0;
        }
        txtcampo11sabado.setText(db.rawQuery("SELECT NOMBRE FROM INSTRUCTOR WHERE IDINSTRUCTOR = "+tmp+";",null).getString(0));
        try{
            tmp=(db.rawQuery("SELECT INSTRUCTOR FROM HORARIO WHERE JORNADA = 1 AND DIA = 'Sábado' AND HORA = '16-17' ;",null).getInt(0));

        }catch (Exception e){
            tmp=0;
        }
        txtcampo12sabado.setText(db.rawQuery("SELECT NOMBRE FROM INSTRUCTOR WHERE IDINSTRUCTOR = "+tmp+";",null).getString(0));
        try{
            tmp=(db.rawQuery("SELECT INSTRUCTOR FROM HORARIO WHERE JORNADA = 1 AND DIA = 'Sábado' AND HORA = '17-18' ;",null).getInt(0));

        }catch (Exception e){
            tmp=0;
        }
        txtcampo13sabado.setText(db.rawQuery("SELECT NOMBRE FROM INSTRUCTOR WHERE IDINSTRUCTOR = "+tmp+";",null).getString(0));
        try{

            tmp=(db.rawQuery("SELECT INSTRUCTOR FROM HORARIO WHERE JORNADA = 1 AND DIA = 'Sábado' AND HORA = '18-19' ;",null).getInt(0));
        }catch (Exception e){
            tmp=0;
        }
        txtcampo14sabado.setText(db.rawQuery("SELECT NOMBRE FROM INSTRUCTOR WHERE IDINSTRUCTOR = "+tmp+";",null).getString(0));

    }




    public void enviar4(View view) {
        Intent intent = new Intent(Caja.this, Infocaja.class);
        startActivity(intent);

    }

    public void back(View view) {
        finish();
    }
}
