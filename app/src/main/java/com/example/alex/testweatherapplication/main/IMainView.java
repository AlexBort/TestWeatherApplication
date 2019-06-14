package com.example.alex.testweatherapplication.main;

import com.example.alex.testweatherapplication.model.CityWeather;
import com.example.alex.testweatherapplication.mvp.IBaseView;

import java.util.List;

public interface IMainView extends IBaseView {

    void showWeatherList(List<CityWeather> cityWeathers);

    void showError();

    void showBadRequest();
}
