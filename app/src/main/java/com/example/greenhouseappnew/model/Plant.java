package com.example.greenhouseappnew.model;

import java.util.ArrayList;

public class Plant {

    private String description;
    private String name;
    private String scientificName;
    private int idGreenhouse;

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
