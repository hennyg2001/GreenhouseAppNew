package com.example.greenhouseappnew.model;

import androidx.room.ColumnInfo;

import java.util.List;

public class GreenhouseListResponse {

    private int id; //ok

    private String name; //ok

    private String userEmail;

    private String location; //ok

    private String description; //ok

    private Double area; //ok   / to instantiate and get method

    private Double co2Preferred; // ok  / to instantiate...

    private Double temperaturePreferred; // ok / to do///

    private Double humidityPreferred;

    private List<Greenhouse> response;

    public List<Greenhouse> getResponse() {
        return response;
    }
}
