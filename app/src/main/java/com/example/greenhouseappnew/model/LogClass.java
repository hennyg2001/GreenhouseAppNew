package com.example.greenhouseappnew.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Date;

@Entity
public class LogClass {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private double co2;
    private double temperature;
    private double humidity;
    private Date timeStamp;

    public LogClass(int id, double co2, double temperature, double humidity, Date timeStamp)
    {
        this.id = id;
        this.co2 = co2;
        this.temperature = temperature;
        this.humidity = humidity;
        this.timeStamp = timeStamp;
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

    public Date getTimeStamp() {
        return timeStamp;
    }
}
