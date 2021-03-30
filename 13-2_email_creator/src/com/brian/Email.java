package com.brian;


public class Email{

    private String name, email;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        name = name.strip();
        name = name.toLowerCase();
        name = name.substring(0, 1).toUpperCase() + name.substring(1);
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        email = email.strip();
        email = email.toLowerCase();
        this.email = email;
    }
}