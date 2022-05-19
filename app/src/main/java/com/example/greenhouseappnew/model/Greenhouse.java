package com.example.greenhouseappnew.model;

import java.util.ArrayList;

public class Greenhouse {

    private int id;
    private String name;
    private String location;
    private String description;
    private ArrayList<Plant> plants;

    public Greenhouse() {
        // Default constructor required for calls to DataSnapShot.getValue(User.class)
    }

    public Greenhouse(String name, String location, String description) {
        this.name = name;
        this.location = location;
        this.description = description;
        this.plants = new ArrayList<>();
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

    public String getLocation() {
        return location;
    }

    public String getDescription() { return description; }

    public ArrayList<Plant> getPlants() {
        return plants;
    }

}
