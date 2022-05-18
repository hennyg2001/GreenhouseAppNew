package com.example.greenhouseappnew.model;

public class GreenhouseResponse {

    private String name;
    private String location;
    private String description;

    public Greenhouse getGreenhouse() {
        return new Greenhouse(name, location, description);
    }

}
