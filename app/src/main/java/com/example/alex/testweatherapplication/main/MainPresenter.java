package com.example.alex.testweatherapplication.main;

import com.example.alex.testweatherapplication.ResponseListener;
import com.example.alex.testweatherapplication.api.ApiManager;
import com.example.alex.testweatherapplication.model.CityWeather;
import com.example.alex.testweatherapplication.mvp.BasePresenter;

public class MainPresenter extends BasePresenter<IMainView> {


    private ApiManager apiManager = new ApiManager();

    @Override
    public void onBindView(IMainView view) {
        super.onBindView(view);
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
}
