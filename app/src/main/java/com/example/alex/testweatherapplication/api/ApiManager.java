package com.example.alex.testweatherapplication.api;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
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

}
