package com.example.greenhouseappnew.model;

import java.util.ArrayList;

public class GreenhouseResponse {

    private int idGreenhouse; //ok
    private String Name; //ok
    private String Location; //ok
    private String Description; //ok
    private Double Area; //ok   / to instantiate and getmethod
    private Double PreferredCo2; // ok  / to instantiate...
    private Double PreferredTemperature; // ok / to do///
    private Double PreferredHumidity; //ok
    private ArrayList<Plant> plants;

    public Greenhouse getGreenhouse() {
        return new Greenhouse(Name,  Location,  Description,  Area,  PreferredCo2,  PreferredTemperature,  PreferredHumidity);
    }

}
