package com.example.tablecrafters.models;

public class user {

    private int id;
    private String name;
    private String secretKey;
    private String mailingAddress;
    private String gender;

    public user(int id, String name, String secretKey, String mailingAddress, String gender) {
        this.id = id;
        this.name = name;
        this.secretKey = secretKey;
        this.mailingAddress = mailingAddress;
        this.gender = gender;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    public String getMailingAddress() {
        return mailingAddress;
    }

    public void setMailingAddress(String mailingAddress) {
        this.mailingAddress = mailingAddress;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "user{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", secretKey='" + secretKey + '\'' +
                ", mailingAddress='" + mailingAddress + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }
}
