package com.example.alex.testweatherapplication.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CityWeather {

    @SerializedName("message")
    @Expose
    private double message;
    @SerializedName("list")
    @Expose
    private List<Data> list = null;
    @SerializedName("city")
    @Expose
    private City city;

    public double getMessage() {
        return message;
    }

    public void setMessage(double message) {
        this.message = message;
    }

    public List<Data> getList() {
        return list;
    }

    public City getCity() {
        return city;
    }

}
