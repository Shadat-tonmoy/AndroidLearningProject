package com.shadattonmoy.androidJetPackDemo.useCase;

import android.os.AsyncTask;
import android.util.Log;

import com.shadattonmoy.androidJetPackDemo.constants.Constants;
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
        Call<Object> sampleAPIRequest = WeatherAPIClient.getAPIService().testSampleAPI(Constants.SAMPLE_LOCATION,Constants.SAMPLE_API_KEY);
        sampleAPIRequest.enqueue(new Callback<Object>() {
            @Override
            public void onResponse(Call<Object> call, Response<Object> response)
            {

                Log.e(TAG, "onResponse: Response "+response.body());

            }

            @Override
            public void onFailure(Call<Object> call, Throwable t)
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
