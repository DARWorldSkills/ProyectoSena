package com.davidpopayan.sena.myapplication.Modelo;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class GestorBD extends SQLiteOpenHelper{
    public GestorBD(Context context) {
        super(context, Constantes.DATABASE, null, Constantes.VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Constantes.scriptCreateTablesUser);
        db.execSQL(Constantes.scriptCreateTablesPrograma);
        db.execSQL(Constantes.scriptCreateTablesInstructor);
        db.execSQL(Constantes.scriptCreateTablesJornada);
        db.execSQL(Constantes.scriptCreateTablesHorario);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
