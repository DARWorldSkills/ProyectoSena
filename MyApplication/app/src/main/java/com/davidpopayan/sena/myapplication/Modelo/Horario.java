package com.davidpopayan.sena.myapplication.Modelo;

public class Horario {
    private String dia;
    private String hora;
    private int instructor;
    private int programa;
    private String user;

    public Horario() {
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public int getInstructor() {
        return instructor;
    }

    public void setInstructor(int instructor) {
        this.instructor = instructor;
    }

    public int getPrograma() {
        return programa;
    }

    public void setPrograma(int programa) {
        this.programa = programa;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
}
