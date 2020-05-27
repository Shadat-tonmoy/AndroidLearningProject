package com.shadattonmoy.androidJetPackDemo.weatherAPI;

import com.shadattonmoy.androidJetPackDemo.helpers.StringHelper;
import com.shadattonmoy.androidJetPackDemo.models.weatherAPIModel.WeatherData;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public interface WeatherAPIService
{
    @Headers("Content-Type: text/html")
    @GET("data/2.5/weather")
    Call<WeatherData> testSampleAPI(@Query("q") String location, @Query("appid") String apiKey);
}
