package com.example.greenhouseappnew.model;

import java.util.ArrayList;

public class GreenhouseResponse {

    private int idGreenhouse; //ok
    private String name; //ok
    private String location; //ok
    private String userMail;
    private String description; //ok
    private Double area; //ok   / to instantiate and getmethod
    private Double co2Preferred; // ok  / to instantiate...
    private Double temperaturePreferred; // ok / to do///
    private Double humidityPreferred; //ok
    private boolean actuatorSet;

    public Greenhouse getGreenhouse() {
        return new Greenhouse(idGreenhouse, name,  location, userMail,  description,  area,  co2Preferred,  temperaturePreferred,  humidityPreferred, actuatorSet);
    }

    public String toString()
    {
        return "Name: " + name + " description: " + description;
    }
}
