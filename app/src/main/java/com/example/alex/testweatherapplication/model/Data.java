package com.example.alex.testweatherapplication.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import io.realm.RealmList;
import io.realm.RealmObject;

public class Data extends RealmObject {

    public Data() {
    }

    //    @SerializedName("dt")
//    @Expose
    private int dt;
    //    @SerializedName("main")
//    @Expose
    private Main main;
    //    @SerializedName("weather")
//    @Expose
    private RealmList<Weather> weather = null;
    //    @SerializedName("dt_txt")
//    @Expose
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
