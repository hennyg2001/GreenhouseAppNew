package com.example.greenhouseappnew.model;

public class LogResponse {

    private String taskName;
    private String type;

    public LogClass getLog() {
        return new LogClass(taskName, type);
    }

}
