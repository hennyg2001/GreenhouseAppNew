package com.example.greenhouseappnew.model;

import androidx.room.ColumnInfo;

import java.util.List;

public class PlantListResponse {
    private int id;

    private String name;

    private String description;

    private String type;

    private String scientificName;

    private int id_Greenhouse;

    public Plant getResponse() {
        return new Plant(id, description, name, type, scientificName, id_Greenhouse);
    }

    public String toString()
    {
        return "Name: " + name + "Scientific name: " + scientificName;
    }
}
