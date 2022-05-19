package com.example.greenhouseappnew.model;

import java.util.ArrayList;

public class Greenhouse {

    private int Id;
    private String Name;
    private String Location;
    private String Description;
    private ArrayList<Plant> plants;

    public Greenhouse() {
        // Default constructor required for calls to DataSnapShot.getValue(User.class)
    }

    public Greenhouse(String Name, String Location, String Description) {
        this.Name = Name;
        this.Location = Location;
        this.Description = Description;
        this.plants = new ArrayList<>();
    }

    public void setId(int id) {
        this.Id = Id;
    }

    public int getId() {
        return Id;
    }

    public String getName() {
        return Name;
    }

    public String getLocation() {
        return Location;
    }

    public String getDescription() { return Description; }

    public ArrayList<Plant> getPlants() {
        return plants;
    }

}
