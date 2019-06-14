package com.example.alex.testweatherapplication.model;

import io.realm.RealmObject;

public class Main extends RealmObject {

    public Main() {
    }

    private double temp;
    private double pressure;
    private int humidity;


    public double getTemp() {
        return temp;
    }

    public double getPressure() {
        return pressure;
    }

    public int getHumidity() {
        return humidity;
    }

}
