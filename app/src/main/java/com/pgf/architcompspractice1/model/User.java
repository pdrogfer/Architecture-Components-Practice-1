package com.pgf.architcompspractice1.model;

public class User {

    private int id;
    private String firstName;
    private String lastName;
    private String avatarUrl;

    public User(int id, String firstName, String lastName, String avatarUrl) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.avatarUrl = avatarUrl;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", avatarUrl='" + avatarUrl + '\'' +
                '}';
    }
}
