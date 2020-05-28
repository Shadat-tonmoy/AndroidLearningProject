package com.shadattonmoy.androidJetPackDemo.dataSource.repository;

import com.shadattonmoy.androidJetPackDemo.models.weatherAPIModel.WeatherData;

public interface WeatherDataRepository
{
    interface Listener
    {
        void onWeatherDataFetchSuccess(WeatherData weatherData);
        void onWeatherDataFetchFailure(String failureMessage);
    }

    void fetchWeatherData();

    void setListener(Listener listener);
}
