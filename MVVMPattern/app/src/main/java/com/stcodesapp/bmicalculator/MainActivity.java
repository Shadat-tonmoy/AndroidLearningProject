package com.stcodesapp.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.stcodesapp.bmicalculator.dataSource.RandomNumberGenerator;
import com.stcodesapp.bmicalculator.observer.MainActivityObserver;

public class MainActivity extends AppCompatActivity
{

    private static final String TAG = "MainActivity";
    private TextView randomNumberOutputView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getLifecycle().addObserver(new MainActivityObserver());
        init();
        generateRandomNumber();
    }

    private void init()
    {
        randomNumberOutputView = findViewById(R.id.random_number_output);
    }

    private void generateRandomNumber()
    {
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
        randomNumberOutputView.setText(randomNumberGenerator.getRandomNumber());
    }

    @Override
    protected void onStart()
    {
        super.onStart();
        Log.e(TAG, "onStart: ActivityCalled");
    }

    @Override
    protected void onResume()
    {
        super.onResume();
        Log.e(TAG, "onResume: ActivityCalled");
    }

    @Override
    protected void onPause()
    {
        super.onPause();
        Log.e(TAG, "onPause: ActivityCalled");
    }

    @Override
    protected void onStop()
    {
        super.onStop();
        Log.e(TAG, "onStop: ActivityCalled");
    }

    @Override
    protected void onDestroy()
    {
        super.onDestroy();
        Log.e(TAG, "onDestroy: ActivityCalled");
    }
}
