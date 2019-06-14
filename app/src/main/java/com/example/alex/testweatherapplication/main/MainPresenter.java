package com.example.alex.testweatherapplication.main;

import com.example.alex.testweatherapplication.ResponseListener;
import com.example.alex.testweatherapplication.api.ApiManager;
import com.example.alex.testweatherapplication.model.CityWeather;
import com.example.alex.testweatherapplication.mvp.BasePresenter;

import java.util.LinkedList;
import java.util.List;

public class MainPresenter extends BasePresenter<IMainView> {

    private ApiManager apiManager = new ApiManager();

    @Override
    public void onBindView(IMainView view) {
    }


    private void defaultRequest(String cityName, final IMainView view) {
        apiManager.getCityWeather(null, cityName, new ResponseListener() {
            @Override
            public void successResponse(CityWeather response) {
                if (response == null) {
                    view.showBadRequest();
                } else {
                    response.getCity().getName();
                    List<CityWeather> list = new LinkedList<>();
                    list.add(response);
                    view.showWeatherList(list);
                }
            }

            @Override
            public void failureResponse() {

            }
        });
    }

    public void onAddButtonPressed(String text, IMainView view) {
        if (text == null || text.isEmpty()) {
            view.showError();
        } else {
            defaultRequest("Kiev", view);
            defaultRequest("Vinnytsia", view);
        }

    }
}