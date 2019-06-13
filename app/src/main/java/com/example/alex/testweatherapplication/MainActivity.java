package com.example.alex.testweatherapplication;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;

import com.example.alex.testweatherapplication.main.IMainView;
import com.example.alex.testweatherapplication.main.MainPresenter;
import com.example.alex.testweatherapplication.model.CityWeather;
import com.example.alex.testweatherapplication.mvp.BaseActivity;

import java.util.List;

public class MainActivity extends BaseActivity<MainPresenter> implements IMainView {

    private RecyclerView recyclerView;
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
        recyclerView = findViewById(R.id.recycler_view);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);
    }

    @Override
    public void showWeatherList(List<CityWeather> cityWeathers) {
        adapter = new RecyclerWeatherAdapter();
        recyclerView.setAdapter(adapter);
        adapter.setData(cityWeathers);
    }
}
