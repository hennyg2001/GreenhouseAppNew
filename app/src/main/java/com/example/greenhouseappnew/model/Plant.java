package com.example.greenhouseappnew.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.ArrayList;
@Entity
public class Plant {

    @PrimaryKey(autoGenerate = true)
    private int id;
    private String description;
    private String name;
    private String type;
    private String scientificName;
    private int id_Greenhouse;

    public Plant(int id, String description, String name, String type, String scientificName, int id_Greenhouse) {
        this.id = id;
        this.description = description;
        this.name = name;
        this.type = type;
        this.scientificName = scientificName;
        this.id_Greenhouse = id_Greenhouse;
    }

    public Plant() {
        // Default constructor required for calls to DataSnapShot.getValue(User.class)
    }

    public int getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public int getIdGreenhouse() {
        return id_Greenhouse;
    }

    public String getName() {
        return name;
    }

    public String getScientificName() {
        return scientificName;
    }

    public String getDescription() { return description; }

    public int getId_Greenhouse() {
        return id_Greenhouse;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setScientificName(String scientificName) {
        this.scientificName = scientificName;
    }

    public void setId_Greenhouse(int id_Greenhouse) {
        this.id_Greenhouse = id_Greenhouse;
    }
}
