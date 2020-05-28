package com.shadattonmoy.androidJetPackDemo.viewModels;

import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.lifecycle.ViewModel;

import com.shadattonmoy.androidJetPackDemo.dataSource.repository.LocalDataRepository;
import com.shadattonmoy.androidJetPackDemo.dataSource.repository.RemoteDataRepository;
import com.shadattonmoy.androidJetPackDemo.dataSource.repository.WeatherDataRepository;
import com.shadattonmoy.androidJetPackDemo.helpers.NetworkHelper;
import com.shadattonmoy.androidJetPackDemo.models.weatherAPIModel.WeatherData;
import com.shadattonmoy.androidJetPackDemo.useCase.WeatherDataFetchUseCase;

public class WeatherDataViewModel extends ViewModel implements WeatherDataFetchUseCase.Listener, LifecycleObserver
{
    private MutableLiveData<WeatherData> weatherDataLiveData;
    private WeatherDataRepository dataRepository;
    private static final String TAG = "WeatherDataViewModel";

    public LiveData<WeatherData> getWeatherDataLiveData()
    {
        if(weatherDataLiveData ==null)
        {
            weatherDataLiveData = new MutableLiveData<>();
            fetchWeatherData();
        }
        return weatherDataLiveData;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public void onCreate()
    {
        Log.e(TAG, "onCreate: FromUIController");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    public void onStart()
    {
        Log.e(TAG, "onStart: FromUIController");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public void onStop()
    {
        Log.e(TAG, "onStop: FromUIController");
    }

    public void onGetWeatherByLocationButtonClicked(View view)
    {
        Toast.makeText(view.getContext(), "Not Implemented Yet!", Toast.LENGTH_SHORT).show();
    }

    public void onRefreshDataButtonClicked(View view)
    {
        fetchWeatherData();
        Toast.makeText(view.getContext(), "Refresh Data Not Implemented Yet!", Toast.LENGTH_SHORT).show();
    }

    private void fetchWeatherData()
    {
        showLoadingWeatherData();
        WeatherDataFetchUseCase useCase = new WeatherDataFetchUseCase();
        useCase.setListener(this);
        useCase.fetchData();
    }

    private void showLoadingWeatherData()
    {
        WeatherData weatherData = weatherDataLiveData.getValue();
        if(weatherData!=null)
        {
            weatherData.setLoadingData(true);
            weatherDataLiveData.setValue(weatherData);
        }
    }

    @Override
    public void onWeatherDataFetchSuccess(WeatherData weatherData)
    {
        weatherData.setLoadingData(false);
        weatherDataLiveData.setValue(weatherData);
    }

    @Override
    public void onWeatherDataFetchFailure(String failureMessage)
    {

    }
}
