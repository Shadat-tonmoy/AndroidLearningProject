package com.shadattonmoy.androidJetPackDemo.useCase;

import android.util.Log;

import com.shadattonmoy.androidJetPackDemo.dataSource.repository.LocalDataRepository;
import com.shadattonmoy.androidJetPackDemo.dataSource.repository.RemoteDataRepository;
import com.shadattonmoy.androidJetPackDemo.dataSource.repository.WeatherDataRepository;
import com.shadattonmoy.androidJetPackDemo.helpers.NetworkHelper;
import com.shadattonmoy.androidJetPackDemo.models.weatherAPIModel.Weather;
import com.shadattonmoy.androidJetPackDemo.models.weatherAPIModel.WeatherData;

public class WeatherDataFetchUseCase implements WeatherDataRepository.Listener
{

    public interface Listener
    {
        void onWeatherDataFetchSuccess(WeatherData weatherData);
        void onWeatherDataFetchFailure(String failureMessage);
    }

    private static final String TAG = "WeatherInfoFetchUseCase";
    private Listener listener;
    private WeatherDataRepository dataRepository;


    public void fetchData()
    {
        if(NetworkHelper.isInternetAvailable())
        {
            Log.e(TAG, "fetchData: FromRemoteDataSource");
            dataRepository = new RemoteDataRepository();
        }
        else
        {
            Log.e(TAG, "fetchData: FromLocalDataSource");
            dataRepository = new LocalDataRepository();
        }
        dataRepository.setListener(this);
        dataRepository.fetchWeatherData();
    }

    public void setListener(Listener listener)
    {
        this.listener = listener;
    }

    @Override
    public void onWeatherDataFetchSuccess(WeatherData weatherData)
    {
        if(dataRepository instanceof RemoteDataRepository)
            cacheWeatherData(weatherData);

    }

    @Override
    public void onWeatherDataFetchFailure(String failureMessage)
    {
        notifyFailureToListener(failureMessage);

    }

    private void cacheWeatherData(WeatherData weatherData)
    {
        //TODO cache weather data locally (Can be on Background Thread)
        notifySuccessToListener(weatherData);
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
