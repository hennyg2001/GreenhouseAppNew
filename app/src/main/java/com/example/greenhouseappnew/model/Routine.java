package com.example.greenhouseappnew.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Routine {

    @PrimaryKey (autoGenerate = true)
    private int idRoutine;
    private String task;
    private String day;
    private int id_Plant;

    public Routine(String task, String day, int id_Plant) {
        this.task = task;
        this.day = day;
        this.id_Plant = id_Plant;
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
        return id_Plant;
    }
}
