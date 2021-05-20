package com.company;

public class Address {
    int id;
    String city;
    String street;
    int house_number;
    String body;
    int flat;

    public Address(int id, String city, String street, int house_number) {
        this.id = id;
        this.city = city;
        this.street = street;
        this.house_number = house_number;
        this.body = body;
        this.flat = flat;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getHouse_number() {
        return house_number;
    }

    public void setHouse_number(int house_number) {
        this.house_number = house_number;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public int getFlat() {
        return flat;
    }

    public void setFlat(int flat) {
        this.flat = flat;
    }
}
