package com.example.alex.testweatherapplication.main;

import com.example.alex.testweatherapplication.ResponseListener;
import com.example.alex.testweatherapplication.api.ApiManager;
import com.example.alex.testweatherapplication.model.CityWeather;
import com.example.alex.testweatherapplication.mvp.BasePresenter;

import java.util.LinkedList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmResults;

public class MainPresenter extends BasePresenter<IMainView> {

    private ApiManager apiManager = new ApiManager();

    @Override
    public void onBindView(IMainView view) {
        presentSavedData(view);

    }

    private Realm configRealm() {
        RealmConfiguration configuration = new RealmConfiguration.Builder().build();
        Realm.setDefaultConfiguration(configuration);
        return Realm.getDefaultInstance();
    }

    private void workingWithDb(final CityWeather cityWeather) {
        Realm realm = configRealm();
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                List<CityWeather> list = new LinkedList<>();
                list.add(cityWeather);
                for (int i = 0; i < list.size(); i++) {
                    realm.copyToRealm(list.get(i));
                }
            }
        });
    }

    private RealmResults<CityWeather> getSavedList() {
        Realm realm = Realm.getDefaultInstance();
        return realm.where(CityWeather.class).findAll();
    }

    private void presentSavedData(IMainView view) {
        if (getSavedList() != null && !getSavedList().isEmpty()) {
            view.showWeatherList(getSavedList());
        } else {
            sendWeatherRequest("Kiev", view);
            sendWeatherRequest("Vinnytsia", view);
        }

    }


    private void sendWeatherRequest(String cityName, final IMainView view) {
        apiManager.getCityWeather(null, cityName, new ResponseListener() {
            @Override
            public void successResponse(CityWeather response) {
                if (response == null) {
                    view.showBadRequest();
                } else {
                    workingWithDb(response);
                    Realm realm = Realm.getDefaultInstance();
                    RealmResults<CityWeather> results = realm.where(CityWeather.class).findAll();
                    view.showWeatherList(results);
                }
            }

            @Override
            public void failureResponse() {
                view.showBadRequest();
            }
        });
    }

    public void onAddButtonPressed(String text, IMainView view) {
        if (text == null || text.isEmpty()) {
            view.showError();
        } else {
            sendWeatherRequest(text, view);
        }
    }
}