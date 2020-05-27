package com.shadattonmoy.androidJetPackDemo.useCase;

import android.os.AsyncTask;
import android.util.Log;

import com.shadattonmoy.androidJetPackDemo.constants.Constants;
import com.shadattonmoy.androidJetPackDemo.models.weatherAPIModel.WeatherData;
import com.shadattonmoy.androidJetPackDemo.weatherAPI.WeatherAPIClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class WeatherInfoFetchUseCase extends AsyncTask<Void,Void,Void>
{

    private static final String TAG = "WeatherInfoFetchUseCase";

    @Override
    protected void onPreExecute()
    {
        super.onPreExecute();
    }

    @Override
    protected Void doInBackground(Void... voids)
    {
        Call<WeatherData> sampleAPIRequest = WeatherAPIClient.getAPIService().testSampleAPI(Constants.SAMPLE_LOCATION,Constants.SAMPLE_API_KEY);
        sampleAPIRequest.enqueue(new Callback<WeatherData>() {
            @Override
            public void onResponse(Call<WeatherData> call, Response<WeatherData> response)
            {
                if(response.body()!=null)
                {
                    try {
                        WeatherData weatherData = response.body();
                    }
                    catch (Exception e)
                    {
                        Log.e(TAG, "onResponse: Exception : "+e.getMessage());
                    }

                }

            }

            @Override
            public void onFailure(Call<WeatherData> call, Throwable t)
            {
                Log.e(TAG, "onFailure: "+t.getMessage());

            }
        });
        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid)
    {
        super.onPostExecute(aVoid);
    }
}
