package com.example.greenhouseappnew.model;

public class User {

    private String username;
    private String email;
    private String password;

    public User() {
        // Default constructor required for calls to DataSnapShot.getValue(User.class)
    }

    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

}
