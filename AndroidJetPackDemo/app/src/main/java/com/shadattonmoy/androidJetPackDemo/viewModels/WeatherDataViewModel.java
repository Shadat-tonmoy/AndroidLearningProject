package com.shadattonmoy.androidJetPackDemo.viewModels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.shadattonmoy.androidJetPackDemo.models.weatherAPIModel.WeatherData;
import com.shadattonmoy.androidJetPackDemo.useCase.WeatherDataFetchUseCase;

public class WeatherDataViewModel extends ViewModel implements WeatherDataFetchUseCase.Listener
{
    private MutableLiveData<WeatherData> weatherDataLiveData;

    public LiveData<WeatherData> getWeatherDataLiveData()
    {
        if(weatherDataLiveData ==null)
        {
            weatherDataLiveData = new MutableLiveData<>();
            fetchWeatherDataFromAPI();

        }
        return weatherDataLiveData;
    }

    private void fetchWeatherDataFromAPI()
    {
        WeatherDataFetchUseCase useCase = new WeatherDataFetchUseCase();
        useCase.setListener(this);
        useCase.execute();
    }

    @Override
    public void onWeatherDataFetchSuccess(WeatherData weatherData)
    {
        weatherDataLiveData.setValue(weatherData);
    }

    @Override
    public void onWeatherDataFetchFailure(String failureMessage)
    {

    }
}
