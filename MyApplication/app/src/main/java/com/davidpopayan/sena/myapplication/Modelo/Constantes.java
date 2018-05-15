package com.davidpopayan.sena.myapplication.Modelo;

import java.util.ArrayList;
import java.util.List;

public class Constantes {
    public static final String DATABASE="Creativa.db";
    public static final int VERSION=1;
    public static final String scriptCreateTablesUser="CREATE TABLE USER (USERNAME TEXT PRIMARY KEY, CLAVE TEXT, ROL TEXT);";
    public static final String scriptCreateTablesPrograma="CREATE TABLE PROGRAMA (IDPROGRAMA INTEGER PRIMARY KEY AUTOINCREMENT, NOMBRE TEXT, DESCRIPCION TEXT, VIDEO TEXT, ICONO TEXT);";
    public static final String scriptCreateTablesInstructor="CREATE TABLE INSTRUCTOR (IDINSTRUCTOR INTEGER PRIMARY KEY AUTOINCREMENT, NOMBRE TEXT, TELEFONO TEXT, CORREO TEXT);";
    public static final String scriptCreateTablesJornada="CREATE TABLE JORNADA (IDJORNADA INTEGER PRIMARY KEY AUTOINCREMENT, NOMBRE TEXT, HORARIO TEXT, ICONO TEXT);";
    public static final String scriptCreateTablesHorario="CREATE TABLE HORARIO (IDHORARIO INTEGER PRIMARY KEY AUTOINCREMENT, DIA TEXT, HORA TEXT, INSTRUCTOR INTEGER, JORNADA INTEGER, PROGRAMA INTEGER, \n" +
            "\tFOREIGN KEY (INSTRUCTOR) REFERENCES INSTRUCTOR(IDINSTRUCTOR),\n" +
            "\tFOREIGN KEY (JORNADA) REFERENCES JORNADA(IDJORNADA),\n" +
            "\tFOREIGN KEY (PROGRAMA) REFERENCES PROGRAMA(IDPROGRAMA));";


}
