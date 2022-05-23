package com.example.greenhouseappnew.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.ArrayList;
@Entity
public class Greenhouse {


    //ok related to the tables in the database
    @PrimaryKey(autoGenerate = true)
    private int idGreenhouse; //ok
    private String Name; //ok
    private String Location; //ok
    private String Description; //ok
    private Double Area; //ok   / to instantiate and getmethod
    private Double PreferredCo2; // ok  / to instantiate...
    private Double PreferredTemperature; // ok / to do///
    private Double PreferredHumidity; //ok
    private ArrayList<Plant> plants;

    public Greenhouse() {
        // Default constructor required for calls to DataSnapShot.getValue(User.class)
    }

    public Greenhouse(int idGreenhouse, String Name, String Location, String Description, Double Area, Double PreferredCo2, Double PreferredTemperature, Double PreferredHumidity) {
        this.idGreenhouse = idGreenhouse;
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

    public Double getPreferredHumidity() { return PreferredHumidity;}

    public Double getPreferredTemperature() { return PreferredTemperature; }

    public ArrayList<Plant> getPlants() {
        return plants;
    }

}
