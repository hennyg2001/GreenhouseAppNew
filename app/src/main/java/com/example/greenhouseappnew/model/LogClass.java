package com.example.greenhouseappnew.model;

import java.time.LocalDateTime;

public class LogClass {

    private int idLog;
    //private String name;
    //private String type;
    private double co2;
    private double temperature;
    private double humidity;
    private LocalDateTime dateTime;
    private String idGreenhouse;


    public LogClass(int idLog, double co2,double temperature, double humidity, LocalDateTime dateTime, String idGreenhouse) {

        this.idLog = idLog;
        this.co2 = co2;
        this.temperature= temperature;
        this.humidity= humidity;
        this.dateTime= dateTime;
        this.idGreenhouse= idGreenhouse;


    }

    public void setIdLog(int idLog) {
        this.idLog = idLog;
    }

    public int getIdLog() {
        return idLog;
    }

    public String getIdLog() {
        return idLog;
    }

    public String getCo2() {
        return co2;
    }

    public double getTemperature() { return temperature; }

    public double getHumidity() { return humidity; }

    public LocalDateTime getDateTime() { return dateTime; }

    public String getIdGreenhouse() { return idGreenhouse; }
}
