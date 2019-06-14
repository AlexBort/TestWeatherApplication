package com.example.alex.testweatherapplication.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import io.realm.RealmObject;

public class Main extends RealmObject {

    public Main() {
    }

    //    @SerializedName("temp")
//    @Expose
    private double temp;
    //    @SerializedName("pressure")
//    @Expose
    private double pressure;
    //    @SerializedName("humidity")
//    @Expose
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
