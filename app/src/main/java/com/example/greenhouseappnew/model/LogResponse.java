package com.example.greenhouseappnew.model;

public class LogResponse {

    private String taskName;
    private String type;

    public Log getLog() {
        return new Log(taskName, type);
    }

}
