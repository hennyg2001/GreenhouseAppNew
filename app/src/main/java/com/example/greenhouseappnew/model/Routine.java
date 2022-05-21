package com.example.greenhouseappnew.model;

public class Routine {

    private int idRoutine;
    private String task;
    private String day;
    private int idPlant;

    public Routine(String task, String day, int idPlant) {
        this.task = task;
        this.day = day;
        this.idPlant = idPlant;
    }

    public void setIdRoutine(int idRoutine) {
        this.idRoutine = idRoutine;
    }

    public int getIdRoutine() {
        return idRoutine;
    }

    public String getTask() {
        return task;
    }

    public String getDay() {
        return day;
    }

    public int getIdPlant() {
        return idPlant;
    }
}
