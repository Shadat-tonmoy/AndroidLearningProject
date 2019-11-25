package com.shadattonmoy.countrylistwithretrofit.tasks;

import com.shadattonmoy.countrylistwithretrofit.model.WeatherData;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface WeatherAPI
{

    @GET("data/2.5/weather")
    Call<WeatherData> getWeatherData(@Query("q") String cityName, @Query("appid") String appId);
}
