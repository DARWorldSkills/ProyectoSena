package com.davidpopayan.sena.myapplication.Modelo;

public class Ficha {
    private String nFicha;
    private int instructorL;
    private int programa;

    public Ficha() {
    }

    public String getnFicha() {
        return nFicha;
    }

    public void setnFicha(String nFicha) {
        this.nFicha = nFicha;
    }

    public int getInstructorL() {
        return instructorL;
    }

    public void setInstructorL(int instructorL) {
        this.instructorL = instructorL;
    }

    public int getPrograma() {
        return programa;
    }

    public void setPrograma(int programa) {
        this.programa = programa;
    }
}
