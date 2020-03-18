package com.stcodesapp.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.stcodesapp.bmicalculator.dataSource.RandomNumberGenerator;
import com.stcodesapp.bmicalculator.observer.MainActivityObserver;

public class MainActivity extends AppCompatActivity
{

    private static final String TAG = "MainActivity";
    private TextView randomNumberOutputView;
    private Button generateRandomNumberButton;

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
        generateRandomNumberButton = findViewById(R.id.generate_random_number_button);
    }

    private void generateRandomNumber()
    {
        final RandomNumberGenerator randomNumberGenerator = new ViewModelProvider(this).get(RandomNumberGenerator.class);
        LiveData<String> randomNumberLiveData = randomNumberGenerator.getRandomNumber();
        randomNumberLiveData.observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                randomNumberOutputView.setText(s);
            }
        });

        generateRandomNumberButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                randomNumberGenerator.createRandomNumber();

            }
        });

    }

    private void startObservingRandomNumber()
    {

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
