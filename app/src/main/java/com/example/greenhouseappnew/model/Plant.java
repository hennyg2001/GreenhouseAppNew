package com.example.greenhouseappnew.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
@Entity(tableName = "plant_table")
public class Plant {

    @PrimaryKey(autoGenerate = true)
    @NotNull
    @ColumnInfo(name = "id")
    private int id;

    @ColumnInfo(name = "name")
    private String name;

    @ColumnInfo(name = "description")
    private String description;

    @ColumnInfo(name = "type")
    private String type;

    @ColumnInfo(name = "scientificName")
    private String scientificName;

    @ColumnInfo(name = "greenhouseId")
    private int id_Greenhouse;

    public Plant(String name, String type, String description, int id_Greenhouse) {
        this.id = id;
        this.description = description;
        this.name = name;
        this.type = type;
        this.scientificName = scientificName;
        this.id_Greenhouse = id_Greenhouse;
    }

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
