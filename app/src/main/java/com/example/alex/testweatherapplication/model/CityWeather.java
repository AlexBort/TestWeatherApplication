package com.example.alex.testweatherapplication.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.RealmResults;

public class CityWeather extends RealmObject {

    public CityWeather() {
    }

    //    @SerializedName("message")
//    @Expose
    private double message;
//    @SerializedName("list")
//    @Expose

    private RealmList<Data> list;

//    private List<Data> list = null;

    //    @SerializedName("city")
//    @Expose
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
