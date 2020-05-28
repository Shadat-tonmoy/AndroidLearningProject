package com.shadattonmoy.androidJetPackDemo.dataSource.repository;

import android.os.AsyncTask;
import android.util.Log;

import com.shadattonmoy.androidJetPackDemo.constants.Constants;
import com.shadattonmoy.androidJetPackDemo.models.weatherAPIModel.WeatherData;
import com.shadattonmoy.androidJetPackDemo.useCase.WeatherDataFetchUseCase;
import com.shadattonmoy.androidJetPackDemo.weatherAPI.WeatherAPIClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RemoteDataRepository implements WeatherDataRepository
{

    private static final String TAG = "WeatherInfoFetchUseCase";
    private WeatherDataRepository.Listener listener;

    @Override
    public void fetchWeatherData()
    {
        Call<WeatherData> sampleAPIRequest = WeatherAPIClient
                .getAPIService()
                .testSampleAPI(Constants.SAMPLE_LOCATION,Constants.SAMPLE_API_KEY);

        sampleAPIRequest.enqueue(new Callback<WeatherData>()
        {
            @Override
            public void onResponse(Call<WeatherData> call, Response<WeatherData> response)
            {
                if(response.body()!=null)
                {
                    try
                    {
                        WeatherData weatherData = response.body();
                        Log.e(TAG, "onResponse: WeatherData : "+weatherData.toString());
                        if(listener!=null)
                            listener.onWeatherDataFetchSuccess(weatherData);
                    }
                    catch (Exception e)
                    {
                        notifyFailureToListener(e.getMessage());
                    }
                }
            }

            @Override
            public void onFailure(Call<WeatherData> call, Throwable t)
            {
                notifyFailureToListener(t.getMessage());
            }
        });
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

}
