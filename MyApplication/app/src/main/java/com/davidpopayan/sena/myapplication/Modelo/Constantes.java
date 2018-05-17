package com.davidpopayan.sena.myapplication.Modelo;

import java.util.ArrayList;
import java.util.List;

public class Constantes {
    public static final String DATABASE="Creativa.db";
    public static final int VERSION=1;
    public static final String scriptCreateTablesUser="CREATE TABLE USER (USERNAME TEXT PRIMARY KEY, CLAVE TEXT, ROL TEXT);";
    public static final String scriptCreateTablesPrograma="CREATE TABLE PROGRAMA (IDPROGRAMA INTEGER PRIMARY KEY AUTOINCREMENT, NOMBRE TEXT, DESCRIPCION TEXT, VIDEO TEXT, ICONO TEXT);";
    public static final String scriptCreateTablesInstructor="CREATE TABLE INSTRUCTOR (IDINSTRUCTOR INTEGER PRIMARY KEY AUTOINCREMENT, NOMBRE TEXT, DESCRIPCION TEXT, TELEFONO TEXT, CORREO TEXT, USER TEXT, \n" +
            "FOREIGN KEY (USER) REFERENCES USER(USERNAME));";

    public static final String scriptCreateTablesFicha="CREATE TABLE FICHA (NFICHA TEXT PRIMARY KEY, INSTRUCTORL INTEGER, PROGRAMA INTEGER, \n" +
            "FOREIGN KEY (INSTRUCTORL) REFERENCES INSTRUCTOR(IDINSTRUCTOR),\n" +
            "FOREIGN KEY (PROGRAMA) REFERENCES PROGRAMA(IDPROGRAMA));";

    public static final String scriptCreateTablesHorario="CREATE TABLE HORARIO (IDHORARIO INTEGER PRIMARY KEY,DIA TEXT, HORA TEXT,INSTRUCTOR INTEGER, FICHA INTEGER,\n" +
            "FOREIGN KEY (INSTRUCTOR) REFERENCES INSTRUCTOR (IDINSTRUCTOR),\n" +
            "FOREIGN KEY (FICHA) REFERENCES FICHA (IDFICHA));";

}
