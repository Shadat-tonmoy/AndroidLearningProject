package com.shadattonmoy.countrylistwithretrofit.view;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.shadattonmoy.countrylistwithretrofit.R;
import com.shadattonmoy.countrylistwithretrofit.model.User;
import com.shadattonmoy.countrylistwithretrofit.model.WeatherData;
import com.shadattonmoy.countrylistwithretrofit.tasks.RetrofitInstance;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void checkGETRequest(View view)
    {
        Log.e("Req","Sending...");
        Call<WeatherData> weatherDataRequest =  RetrofitInstance.getWeatherAPI().getWeatherData("London,uk","b6907d289e10d714a6e88b30761fae22");
        weatherDataRequest.enqueue(new Callback<WeatherData>() {
            @Override
            public void onResponse(Call<WeatherData> call, Response<WeatherData> response)
            {
                Log.e("FetchedWeatherData",response.body().toString());

            }

            @Override
            public void onFailure(Call<WeatherData> call, Throwable t)
            {

                Log.e("Error",t.getMessage()+" ");

            }
        });
    }

    public void checkPostRequest(View view)
    {
        User user = new User();
        user.setUserName("Shadat Tonmoy");
        user.setPassword("123456");
        Call<User> userPostRequest = RetrofitInstance.getUserPostAPI().getUserPostResult(user);
        userPostRequest.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                Log.e("ResultFromPostReq",response.body().getId()+" is new ID ");
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Log.e("Error","In Post Request "+t.getMessage()+" ");

            }
        });

    }
}
