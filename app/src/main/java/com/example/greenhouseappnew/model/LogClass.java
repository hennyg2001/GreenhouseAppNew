package com.example.greenhouseappnew.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.time.LocalDateTime;
import java.util.Date;

@Entity (tableName = "Logs")
public class LogClass {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private double co2;
    private double temperature;
    private double humidity;
    private LocalDateTime dateTime;
    private int id_Greenhouse;

    public LogClass(int id, double co2, double temperature, double humidity, LocalDateTime dateTime)
    {
        this.id = id;
        this.co2 = co2;
        this.temperature = temperature;
        this.humidity = humidity;
        this.dateTime = dateTime;
    }

    public int getId() {
        return id;
    }

    public double getCo2() {
        return co2;
    }

    public double getTemperature() {
        return temperature;
    }

    public double getHumidity() {
        return humidity;
    }

    public LocalDateTime getTimeStamp() {
        return dateTime;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public int getId_Greenhouse() {
        return id_Greenhouse;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public void setId_Greenhouse(int id_Greenhouse) {
        this.id_Greenhouse = id_Greenhouse;
    }
}
