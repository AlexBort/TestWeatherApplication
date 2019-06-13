package com.example.alex.testweatherapplication.main;

import com.example.alex.testweatherapplication.ResponseListener;
import com.example.alex.testweatherapplication.api.ApiManager;
import com.example.alex.testweatherapplication.model.CityWeather;
import com.example.alex.testweatherapplication.mvp.BasePresenter;

public class MainPresenter extends BasePresenter<IMainView> {

    private ApiManager apiManager = new ApiManager();


    private void requestGetWeather(IMainView view) {
        apiManager.getCityWeather(null, new ResponseListener() {
            @Override
            public void successResponse(CityWeather response) {
//                response.getCity();
            }

            @Override
            public void failureResponse() {

            }
        });
    }

    // TODO: 13.06.2019 when we have db, we won't pass every time request for getting weather
    

    @Override
    public void onBindView(IMainView view) {
        super.onBindView(view);
        requestGetWeather(view);
    }
}