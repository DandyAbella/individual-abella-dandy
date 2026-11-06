package com.joysistvi.day20.encapsulation;

public class UserAccount {

    // Private fields (Encapsulation)
    private String firstName;
    private String middleName;
    private String lastName;
    private String address;
    private String email;
    private String password;

    // Getters and Setters
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    // Email Validation
    public void setEmail(String email) {
        if(email.contains("@") && email.contains(".")) {
            this.email = email;
        } else {
            this.email = "Invalid Email";
        }
    }

    public String getPassword() {
        return password;
    }

    // Password Validation
    public void setPassword(String password) {
        if(password.length() >= 8) {
            this.password = password;
        } else {
            this.password = "Invalid Password";
        }
    }

    // Full Name
    public String getFullName() {
        return firstName + " " + middleName + " " + lastName;
    }
}