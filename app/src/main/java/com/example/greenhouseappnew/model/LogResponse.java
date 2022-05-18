package com.example.sep4_greenhouseapp.model;

public class LogResponse {

    private String taskName;
    private String type;

    public Log getLog() {
        return new Log(taskName, type);
    }

}
