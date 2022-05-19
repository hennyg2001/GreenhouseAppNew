package com.example.greenhouseappnew.model;

import java.util.ArrayList;

public class Plant {

    private int id;
    private String name;
    private String type;
    private String description;
    private ArrayList<LogClass> logClasses;

    public Plant() {
        // Default constructor required for calls to DataSnapShot.getValue(User.class)
    }

    public Plant(String name, String type, String description) {
        this.name = name;
        this.type = type;
        this.description = description;
        this.logClasses = logClasses;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getDescription() { return description; }

    public ArrayList<LogClass> getPlantLogs() {
        return logClasses;
    }

}
