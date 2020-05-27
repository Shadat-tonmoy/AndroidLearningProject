package com.shadattonmoy.androidJetPackDemo.useCase;

import android.os.AsyncTask;

import com.shadattonmoy.androidJetPackDemo.constants.Constants;
import com.shadattonmoy.androidJetPackDemo.models.weatherAPIModel.WeatherData;
import com.shadattonmoy.androidJetPackDemo.weatherAPI.WeatherAPIClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class WeatherDataFetchUseCase extends AsyncTask<Void,Void,Void>
{

    public interface Listener
    {
        void onWeatherDataFetchSuccess(WeatherData weatherData);
        void onWeatherDataFetchFailure(String failureMessage);
    }

    private static final String TAG = "WeatherInfoFetchUseCase";
    private Listener listener;

    @Override
    protected void onPreExecute()
    {
        super.onPreExecute();
    }

    @Override
    protected Void doInBackground(Void... voids)
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
                    try {
                        WeatherData weatherData = response.body();
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
        return null;
    }

    private void notifyFailureToListener(String failureMessage)
    {
        if(listener!=null)
            listener.onWeatherDataFetchFailure(failureMessage);
    }

    @Override
    protected void onPostExecute(Void aVoid)
    {
        super.onPostExecute(aVoid);
    }

    public void setListener(Listener listener)
    {
        this.listener = listener;
    }


}
