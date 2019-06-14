package com.example.alex.testweatherapplication.model;

import io.realm.RealmObject;

public class City extends RealmObject {

    public City(){}

    private int id;

    private String name;

    private String country;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

}
