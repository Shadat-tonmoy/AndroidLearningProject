package com.shadattonmoy.countrylistwithretrofit.tasks;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInstance
{
    private static final String BASE_URL = "https://samples.openweathermap.org";
    private static Retrofit retrofitInstance;

    public static WeatherAPI getWeatherAPI()
    {
        if(retrofitInstance == null)
        {
            retrofitInstance = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return retrofitInstance.create(WeatherAPI.class);
    }
}
