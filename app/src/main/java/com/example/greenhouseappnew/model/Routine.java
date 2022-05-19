package com.example.greenhouseappnew.model;

public class Routine {

    private int id;
    private String taskName;
    private String day;
    private int frequency;

    public Routine(String taskName, String day, int frequency) {
        this.taskName = taskName;
        this.day = day;
        this.frequency = frequency;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getTaskName() {
        return taskName;
    }

    public String getDay() {
        return day;
    }

    public int getFrequency() {
        return frequency;
    }
}
