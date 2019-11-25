package com.shadattonmoy.countrylistwithretrofit.tasks;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInstance
{
    private static final String BASE_URL_FOR_GET_REQ = "https://samples.openweathermap.org";
    private static final String BASE_URL_FOR_POST_REQ = "https://jsonplaceholder.typicode.com";
    private static Retrofit retrofitInstanceForGETRequest;
    private static Retrofit retrofitInstanceForPOSTRequest;

    public static WeatherAPI getWeatherAPI()
    {
        if(retrofitInstanceForGETRequest == null)
        {
            retrofitInstanceForGETRequest = new Retrofit.Builder()
                    .baseUrl(BASE_URL_FOR_GET_REQ)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return retrofitInstanceForGETRequest.create(WeatherAPI.class);
    }

    public static UserPostAPI getUserPostAPI()
    {
        if(retrofitInstanceForPOSTRequest == null)
        {
            retrofitInstanceForPOSTRequest = new Retrofit.Builder()
                    .baseUrl(BASE_URL_FOR_POST_REQ)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofitInstanceForPOSTRequest.create(UserPostAPI.class);
    }


}
