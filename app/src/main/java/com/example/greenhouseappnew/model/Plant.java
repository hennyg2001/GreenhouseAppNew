package com.example.greenhouseappnew.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.ArrayList;
@Entity
public class Plant {

    @PrimaryKey(autoGenerate = true)
    private int idGreenhouse;
    private String description;
    private String name;
    private String scientificName;

    private ArrayList<LogClass> logClasses;

    public Plant() {
        // Default constructor required for calls to DataSnapShot.getValue(User.class)
    }

    public Plant(String name, String scientificName, String description, int idGreenhouse) {
        this.name = name;
        this.scientificName = scientificName;
        this.description = description;
        this.logClasses = logClasses;
        this.idGreenhouse= idGreenhouse;
    }

    public void setIdGreenhouse(int idGreenhouse) {
        this.idGreenhouse = idGreenhouse;
    }

    public int getIdGreenhouse() {
        return idGreenhouse;
    }

    public String getName() {
        return name;
    }

    public String getScientificName() {
        return scientificName;
    }

    public String getDescription() { return description; }

    public ArrayList<LogClass> getPlantLogs() {
        return logClasses;
    }

}
