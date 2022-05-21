package com.example.greenhouseappnew.model;

import java.util.Date;

public class LogResponse {

    private int id;
    private double co2;
    private double temperature;
    private double humidity;
    private Date timeStamp;

    public LogClass getLog() {
        return new LogClass(id, co2, temperature, humidity, timeStamp);
    }

}
