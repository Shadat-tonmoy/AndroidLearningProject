package com.shadattonmoy.androidJetPackDemo.weatherAPI;

import com.shadattonmoy.androidJetPackDemo.constants.Constants;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class WeatherAPIClient
{
    private static Retrofit retrofit;
    private static WeatherAPIService apiService;

    private WeatherAPIClient()
    {

    }

    public static WeatherAPIService getAPIService()
    {
        createAPIClient();
        if(apiService==null)
            apiService = retrofit.create(WeatherAPIService.class);
        return apiService;
    }

    private static void createAPIClient()
    {
        if(retrofit==null)
        {
            retrofit = new Retrofit.Builder()
                    .baseUrl(Constants.WEATHER_API_BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
    }
}
