package com.brian;

public class Contact {
    private String firstName;
    private String lastName;
    private String email;
    private String phone;

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName() {
        setFirstName(Console.getString("Enter first name: "));
        return firstName;

    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastName() {
        setLastName(Console.getString("Enter last name:  "));
        return lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        setEmail(Console.getString("Enter email:      "));
        return email;
    }


    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPhone() {
        setPhone(Console.getString("Enter phone:      "));
        return phone;
    }

    public String displayContact() {
        return ("\n--------------------------------------------\n" +
                        "---- Current Contact -----------------------\n" +
                        "--------------------------------------------\n" +
                        "Name:           " + getFirstName() +  " " + getLastName() + "\n" +
                        "Email Address:  " + getEmail() + "\n" +
                        "Phone Number:   " + getPhone());
    }
}