package com.example.alex.testweatherapplication.api;

import com.example.alex.testweatherapplication.ResponseListener;
import com.example.alex.testweatherapplication.db.CityEntity;
import com.example.alex.testweatherapplication.model.CityWeather;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiManager {

    IRequestsApi requestsApi;

    public IRequestsApi getRequestsApi() {
        return requestsApi;
    }

    private final String BASE_URL = "http://api.openweathermap.org/data/2.5/";

    private Retrofit createRetrofitBuilder() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                /*.readTimeout(5, TimeUnit.MINUTES)*/
                .build();

        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public ApiManager() {
        requestsApi = createRetrofitBuilder().create(IRequestsApi.class);
    }

    public void getCityWeather(CityEntity city, final ResponseListener listener) {

        // TODO: 13.06.2019  insert CityEntity
        Call<CityWeather> call = requestsApi.getCityWeather("Kiev"/*city.getCity()*/);
        call.enqueue(new Callback<CityWeather>() {
            @Override
            public void onResponse(Call<CityWeather> call, Response<CityWeather> response) {
                listener.successResponse(response.body());
            }

            @Override
            public void onFailure(Call<CityWeather> call, Throwable t) {
                listener.failureResponse();
            }
        });
    }

}
