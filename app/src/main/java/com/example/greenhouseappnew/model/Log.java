package com.example.greenhouseappnew.model;

public class Log {

    private int id;
    private String name;
    private String type;

    public Log(String name, String type) {

        this.name = name;
        this.type = type;

    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

}
