package com.example.greenhouseappnew.model;

import java.util.ArrayList;

public class Greenhouse {


    //ok related to the tables in the database
    private int idGreenhouse; //ok
    private String Name; //ok
    private String Location; //ok
    private String Description; //ok
    private Double Area; //ok   / to instantiate and getmothod
    private Double PreferredCo2; // ok  / to instantiate...
    private Double PreferredTemperature; // ok / to do///
    private Double PreferredHumidity; //ok
    private ArrayList<Plant> plants;

    public Greenhouse() {
        // Default constructor required for calls to DataSnapShot.getValue(User.class)
    }

    public Greenhouse(String Name, String Location, String Description, Double Area, Double PreferredCo2, Double PreferredTemperature, Double PreferredHumidity) {
        this.Name = Name;
        this.Location = Location;
        this.Description = Description;
        this.Area= Area;
        this.PreferredCo2= PreferredCo2;
        this.PreferredTemperature= PreferredTemperature;
        this.PreferredHumidity= PreferredHumidity;
        this.plants = new ArrayList<>();
    }

    public void setIdGreenhouse(int idGreenhouse) {
        this.idGreenhouse = this.idGreenhouse;
    }

    public int getIdGreenhouse() {
        return idGreenhouse;
    }

    public String getName() {
        return Name;
    }

    public String getLocation() {
        return Location;
    }

    public String getDescription() { return Description; }

    public Double getArea() { return Area; }

    public Double getPreferredCo2() { return PreferredCo2; }

    public Double getPreferredHumidity { return PreferredHumidity;}

    public Double getPreferredTemperature() { return PreferredTemperature; }

    public ArrayList<Plant> getPlants() {
        return plants;
    }

}
