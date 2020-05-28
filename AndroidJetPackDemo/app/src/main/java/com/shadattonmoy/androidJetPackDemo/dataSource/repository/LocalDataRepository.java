package com.shadattonmoy.androidJetPackDemo.dataSource.repository;

import android.os.AsyncTask;

import com.shadattonmoy.androidJetPackDemo.models.weatherAPIModel.WeatherData;

public class LocalDataRepository implements WeatherDataRepository
{
    private WeatherDataRepository.Listener listener;

    @Override
    public void fetchWeatherData()
    {
    }

    @Override
    public void setListener(WeatherDataRepository.Listener listener)
    {
        this.listener = listener;
    }

    private void notifyFailureToListener(String failureMessage)
    {
        if(listener!=null)
            listener.onWeatherDataFetchFailure(failureMessage);
    }

    private void notifySuccessToListener(WeatherData weatherData)
    {
        if(listener!=null)
            listener.onWeatherDataFetchSuccess(weatherData);
    }
}
