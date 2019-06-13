package com.example.alex.testweatherapplication;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.example.alex.testweatherapplication.model.CityWeather;
import com.thoughtbot.expandablerecyclerview.viewholders.GroupViewHolder;

import java.util.LinkedList;
import java.util.List;

public class RecyclerWeatherAdapter extends RecyclerView.Adapter<RecyclerWeatherAdapter.CityViewHolder> {

    private List<CityWeather> data;

    public RecyclerWeatherAdapter() {
        data = new LinkedList<>(); // TODO: 13.06.2019 why did she use LinkedList
    }

    public RecyclerWeatherAdapter getAdapter() {
        return this;
    }

    @NonNull
    @Override
    public RecyclerWeatherAdapter.CityViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_city, null);
//        view.setLayoutParams(new RecyclerView.LayoutParams(RecyclerView.LayoutParams.MATCH_PARENT, RecyclerView.LayoutParams.WRAP_CONTENT));
        return new CityViewHolder(view);
    }

    @SuppressLint("StringFormatInvalid")
    @Override
    public void onBindViewHolder(@NonNull RecyclerWeatherAdapter.CityViewHolder holder, int i) {
        CityWeather cityWeather = data.get(i);
        holder.city.setText(holder.context.getString(R.string.title_city, cityWeather.getCity().getName()));
        holder.temperature.setText(holder.context.getString(R.string.title_temperature, cityWeather.getList().get(0).getMain().getTemp()));
        holder.humidity.setText(holder.context.getString(R.string.title_humidity, String.valueOf(cityWeather.getList().get(0).getMain().getHumidity())));
        holder.date.setText(holder.context.getString(R.string.title_date, cityWeather.getList().get(0).getDtTxt()));
        holder.pressure.setText(holder.context.getString(R.string.title_pressure, cityWeather.getList().get(0).getMain().getPressure()));
        setWeatherIcon(holder.context, cityWeather.getList().get(0).getWeather().get(0).getIcon(), holder.imageView);

        onBindDayTemperature(holder.context, 1, holder.tmpFirstDay, cityWeather);
        onBindDayTemperature(holder.context, 2, holder.tmpSecondDay, cityWeather);
        onBindDayTemperature(holder.context, 3, holder.tmpThirdDay, cityWeather);

        onBindDayIcon(1, holder.context, holder.firstImageView, cityWeather);
        onBindDayIcon(2, holder.context, holder.secondImageView, cityWeather);
        onBindDayIcon(3, holder.context, holder.thirdImageView, cityWeather);

        onBindDayDate(holder.context, 1, holder.dateFirstDay, cityWeather);
        onBindDayDate(holder.context, 2, holder.dateSecondDay, cityWeather);
        onBindDayDate(holder.context, 3, holder.dateThirdDay, cityWeather);
    }

    private void onBindDayDate(Context context, int day, AppCompatTextView textView, CityWeather cityWeather) {
        textView.setText(context.getString(R.string.title_date, cityWeather.getList().get(day).getDtTxt()));
    }

    private void onBindDayIcon(int day, Context context, ImageView imageView, CityWeather cityWeather) {
        setWeatherIcon(context, cityWeather.getList().get(day).getWeather().get(0).getIcon(), imageView);
    }

    private void onBindDayTemperature(Context context, int day, AppCompatTextView textView, CityWeather cityWeather) {
        textView.setText(context.getString(R.string.title_temperature, cityWeather.getList().get(day).getMain().getTemp()));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public void setData(List<CityWeather> data) {
        this.data.addAll(data);
        notifyDataSetChanged();
    }

    private void setWeatherIcon(Context context, String url, ImageView view) {
        Glide.with(context)
                .load("http://openweathermap.org/img/w/" + url + ".png")
                .transition(DrawableTransitionOptions.withCrossFade())
                .into(view);
    }


    public static class CityViewHolder extends GroupViewHolder {

        private AppCompatTextView tmpFirstDay;
        private AppCompatTextView tmpSecondDay;
        private AppCompatTextView tmpThirdDay;
        private AppCompatTextView dateFirstDay;
        private AppCompatTextView dateSecondDay;
        private AppCompatTextView dateThirdDay;
        private SquareImageView firstImageView;
        private SquareImageView secondImageView;
        private SquareImageView thirdImageView;

        private LinearLayout firstDayItem;
        private LinearLayout secondDayItem;
        private LinearLayout thirdDayItem;

        private Context context;
        private AppCompatTextView date;
        private AppCompatTextView humidity;
        private AppCompatTextView pressure;
        private AppCompatTextView temperature;
        private AppCompatTextView city;
        private SquareImageView imageView;


        public CityViewHolder(View itemView) {
            super(itemView/*.getRootView()*/);
            this.context = itemView.getContext();
            date = itemView.findViewById(R.id.tv_date);
            humidity = itemView.findViewById(R.id.tv_humidity);
            pressure = itemView.findViewById(R.id.tv_pressure);
            temperature = itemView.findViewById(R.id.tv_temperature);
            city = itemView.findViewById(R.id.tv_city);
            imageView = itemView.findViewById(R.id.iv_weather_icon);

            firstDayItem = itemView.findViewById(R.id.view_first_day);
            secondDayItem = itemView.findViewById(R.id.view_sec_day);
            thirdDayItem = itemView.findViewById(R.id.view_third_day);

            tmpFirstDay = firstDayItem.findViewById(R.id.tv_temperature);
            tmpSecondDay = secondDayItem.findViewById(R.id.tv_temperature);
            tmpThirdDay = thirdDayItem.findViewById(R.id.tv_temperature);

            firstImageView = firstDayItem.findViewById(R.id.iv_weather_icon);
            secondImageView = secondDayItem.findViewById(R.id.iv_weather_icon);
            thirdImageView = thirdDayItem.findViewById(R.id.iv_weather_icon);

            dateFirstDay = firstDayItem.findViewById(R.id.tv_date);
            dateSecondDay = secondDayItem.findViewById(R.id.tv_date);
            dateThirdDay = thirdDayItem.findViewById(R.id.tv_date);
        }


    }

}
