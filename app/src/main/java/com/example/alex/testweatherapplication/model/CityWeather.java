package com.example.alex.testweatherapplication.model;

import io.realm.RealmList;
import io.realm.RealmObject;

public class CityWeather extends RealmObject {

    public CityWeather() {
    }

    private double message;

    private RealmList<Data> list;


    private City city;

    public double getMessage() {
        return message;
    }

    public void setMessage(double message) {
        this.message = message;
    }

    public RealmList<Data> getList() {
        return list;
    }

    public City getCity() {
        return city;
    }

}
