package com.example.alex.testweatherapplication.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import io.realm.RealmObject;

public class Weather extends RealmObject {

    public Weather() {
    }

    //    @SerializedName("id")
//    @Expose
    private int id;
    //    @SerializedName("main")
//    @Expose
    private String main;
    //    @SerializedName("description")
//    @Expose
    private String description;
    //    @SerializedName("icon")
//    @Expose
    private String icon;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

}
