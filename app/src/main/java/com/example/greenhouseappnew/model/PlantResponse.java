package com.example.sep4_greenhouseapp.model;

public class PlantResponse {

    private String name;
    private String type;
    private String description;

    public Plant getPlant() {

        return new Plant(name, type, description);

    }

}
