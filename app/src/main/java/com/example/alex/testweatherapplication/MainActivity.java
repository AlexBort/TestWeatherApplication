package com.example.alex.testweatherapplication;

import android.os.Bundle;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.alex.testweatherapplication.main.IMainView;
import com.example.alex.testweatherapplication.main.MainPresenter;
import com.example.alex.testweatherapplication.model.CityWeather;
import com.example.alex.testweatherapplication.mvp.BaseActivity;

import java.util.List;

public class MainActivity extends BaseActivity<MainPresenter> implements IMainView {

    private RecyclerView recyclerView;
    private RecyclerWeatherAdapter adapter;
    private View addButton;
    private AppCompatEditText editCity;
    private IMainView mainView;

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
        addButton = findViewById(R.id.button_add_city);
        editCity = findViewById(R.id.et_query);

        mainView = this;

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.onAddButtonPressed(editCity.getText().toString(), mainView);
            }
        });

        LinearLayoutManager manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);
        adapter = new RecyclerWeatherAdapter();
        recyclerView.setAdapter(adapter);
    }


    @Override
    public void showBadRequest() {
        Toast.makeText(MainActivity.this, "BAD REQUEST", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showError() {
        String message = getResources().getString(R.string.empty_message);
        editCity.setError(message);
    }

    @Override
    public void showWeatherList(List<CityWeather> cityWeathers) {
        adapter.setData(cityWeathers);
    }
}
