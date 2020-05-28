package com.shadattonmoy.androidJetPackDemo;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import com.shadattonmoy.androidJetPackDemo.databinding.WeatherScreenLayoutBinding;
import com.shadattonmoy.androidJetPackDemo.viewModels.WeatherDataViewModel;

public class MainActivity extends AppCompatActivity
{
    private static final String TAG = "MainActivity";
    private WeatherDataViewModel viewModel;
    private WeatherScreenLayoutBinding dataBinder;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        init();
    }

    private void init()
    {
        initViewModel();
        initDataBinder();
    }

    private void initViewModel()
    {
        viewModel = new ViewModelProvider(this).get(WeatherDataViewModel.class);
        getLifecycle().addObserver(viewModel);
        viewModel.getWeatherDataLiveData().observe(this, weatherData -> dataBinder.setWeatherData(weatherData));
    }

    private void initDataBinder()
    {
        dataBinder = DataBindingUtil.setContentView(this, R.layout.weather_screen_layout);
        dataBinder.setContext(this);
        dataBinder.setClickListener(viewModel);
        setContentView(dataBinder.getRoot());
    }
}
