package com.example.greenhouseappnew.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
@Entity(tableName = "greenhouse_table")
public class Greenhouse {


    //ok related to the tables in the database
    @PrimaryKey(autoGenerate = true)
    @NotNull
    @ColumnInfo(name = "id")
    private int id; //ok

    @ColumnInfo(name = "name")
    private String name; //ok

    @ColumnInfo(name = "email")
    private String userEmail;

    @ColumnInfo(name = "location")
    private String location; //ok

    @ColumnInfo(name = "description")
    private String description; //ok

    @ColumnInfo(name = "area")
    private Double area; //ok   / to instantiate and get method

    @ColumnInfo(name = "co2")
    private Double co2Preferred; // ok  / to instantiate...

    @ColumnInfo(name = "temp")
    private Double temperaturePreferred; // ok / to do///

    @ColumnInfo(name = "humidity")
    private Double humidityPreferred; //ok

    private boolean actuatorSet;



    public Greenhouse() {
        // Default constructor required for calls to DataSnapShot.getValue(User.class)
    }

    public Greenhouse(int id, String Name, String Location, String Description, Double Area, Double PreferredCo2, Double PreferredTemperature, Double PreferredHumidity, String UserEmail) {
        this.id = id;
        this.name = Name;
        this.location = Location;
        this.userEmail = UserEmail;
        this.description = Description;
        this.area = Area;
        this.co2Preferred= PreferredCo2;
        this.temperaturePreferred= PreferredTemperature;
        this.humidityPreferred= PreferredHumidity;
    }

    public Greenhouse(String Name, String Location, String Description, Double Area, Double PreferredCo2, Double PreferredTemperature, Double PreferredHumidity, String UserEmail) {
        this.id = id;
        this.name = Name;
        this.location = Location;
        this.userEmail = UserEmail;
        this.description = Description;
        this.area = Area;
        this.co2Preferred= PreferredCo2;
        this.temperaturePreferred= PreferredTemperature;
        this.humidityPreferred= PreferredHumidity;
    }

    public Greenhouse(String Name, String Location, String Description, Double Area, Double PreferredCo2, Double PreferredTemperature, Double PreferredHumidity) {
        this.name = Name;
        this.location = Location;
        this.description = Description;
        this.area = Area;
        this.co2Preferred= PreferredCo2;
        this.temperaturePreferred= PreferredTemperature;
        this.humidityPreferred= PreferredHumidity;
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

    public boolean isActuatorSet() {
        return actuatorSet;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setArea(Double area) {
        this.area = area;
    }

    public void setCo2Preferred(Double co2Preferred) {
        this.co2Preferred = co2Preferred;
    }

    public void setTemperaturePreferred(Double temperaturePreferred) {
        this.temperaturePreferred = temperaturePreferred;
    }

    public void setHumidityPreferred(Double humidityPreferred) {
        this.humidityPreferred = humidityPreferred;
    }

    public void setActuatorSet(boolean actuatorSet) {
        this.actuatorSet = actuatorSet;
    }
}
