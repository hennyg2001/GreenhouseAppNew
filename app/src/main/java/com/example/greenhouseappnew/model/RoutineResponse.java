package com.example.greenhouseappnew.model;

public class RoutineResponse {

    private String taskName;
    private String day;
    private int frequency;

    public Routine getRoutine() {
        return new Routine(taskName, day, frequency);
    }

}
