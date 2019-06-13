package com.example.alex.testweatherapplication;

import android.os.Bundle;

import com.example.alex.testweatherapplication.main.IMainView;
import com.example.alex.testweatherapplication.main.MainPresenter;
import com.example.alex.testweatherapplication.model.CityWeather;
import com.example.alex.testweatherapplication.mvp.BaseActivity;

import java.util.List;

public class MainActivity extends BaseActivity<MainPresenter> implements IMainView {

    private RecyclerWeatherAdapter adapter;

    @Override
    protected MainPresenter createPresenter() {
        return new MainPresenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void showWeatherList(List<CityWeather> cityWeathers) {
        adapter = new RecyclerWeatherAdapter();
        adapter.setData(cityWeathers);
    }
}
