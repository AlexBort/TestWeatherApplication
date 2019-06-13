package com.example.alex.testweatherapplication.mvp;

interface IBasePresenter<V> {

    void onBindView(V view);

    void onUnbindView();


}
