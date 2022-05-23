package com.example.greenhouseappnew.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.ArrayList;
@Entity
public class Greenhouse {


    //ok related to the tables in the database
    @PrimaryKey(autoGenerate = true)
    private int id; //ok
    private String name; //ok
    private String userEmail;
    private String location; //ok
    private String description; //ok
    private Double area; //ok   / to instantiate and getmethod
    private Double co2Preferred; // ok  / to instantiate...
    private Double temperaturePreferred; // ok / to do///
    private Double humidityPreferred; //ok
    private boolean actuatorSet;



    public Greenhouse() {
        // Default constructor required for calls to DataSnapShot.getValue(User.class)
    }

    public Greenhouse(int id, String Name, String Location, String UserEmail, String Description, Double Area, Double PreferredCo2, Double PreferredTemperature, Double PreferredHumidity, boolean actuator) {
        this.id = id;
        this.name = Name;
        this.location = Location;
        this.userEmail = UserEmail;
        this.description = Description;
        this.area = Area;
        this.co2Preferred= PreferredCo2;
        this.temperaturePreferred= PreferredTemperature;
        this.humidityPreferred= PreferredHumidity;
        this.actuatorSet = actuator;
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

    public boolean isActivated() {
        return actuatorSet;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public String getLocation() {
        return location;
    }

    public String getDescription() { return description; }

    public Double getArea() { return area; }

    public Double getCo2Preferred() {
        return co2Preferred;
    }

    public Double getHumidityPreferred() {
        return humidityPreferred;
    }

    public Double getTemperaturePreferred() {
        return temperaturePreferred;
    }


}
