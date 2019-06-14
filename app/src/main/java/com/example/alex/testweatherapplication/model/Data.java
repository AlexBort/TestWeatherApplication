package com.example.alex.testweatherapplication.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import io.realm.RealmList;
import io.realm.RealmObject;

public class Data extends RealmObject {

    public Data() {
    }


    private int dt;
    private Main main;

    private RealmList<Weather> weather = null;
    private String dtTxt;


    public int getDt() {
        return dt;
    }

    public Main getMain() {
        return main;
    }

    public RealmList<Weather> getWeather() {
        return weather;
    }

    public String getDtTxt() {
        return dtTxt;
    }
}
