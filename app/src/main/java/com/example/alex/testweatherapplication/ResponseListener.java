package com.example.alex.testweatherapplication;

import com.example.alex.testweatherapplication.model.CityWeather;

public interface ResponseListener {


    void successResponse(CityWeather response);

    void failureResponse();

}
