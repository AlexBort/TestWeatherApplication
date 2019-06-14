package com.example.alex.testweatherapplication.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import io.realm.RealmObject;

public class City extends RealmObject {

    public City(){}

//    @SerializedName("id")
//    @Expose
    private int id;
//    @SerializedName("name")
//    @Expose
    private String name;
//    @SerializedName("country")
//    @Expose
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
