package com.example.alex.testweatherapplication.api;

import com.example.alex.testweatherapplication.model.CityWeather;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface IRequestsApi {

    @GET("forecast?APPID=f31a6566bc8f4ab982405f1f35ea63b9&units=metric")
    Call<CityWeather> getCityWeather(@Query("q") String city);

}
