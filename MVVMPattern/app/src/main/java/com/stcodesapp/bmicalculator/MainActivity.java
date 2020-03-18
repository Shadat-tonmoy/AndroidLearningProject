package com.stcodesapp.bmicalculator;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.stcodesapp.bmicalculator.ui.views.screenViews.activityScreenViews.MainActivityScreenView;
import com.stcodesapp.controller.activityController.MainActivityController;

public class MainActivity extends AppCompatActivity
{

    private static final String TAG = "MainActivity";
    private MainActivityController controller;
    private MainActivityScreenView screenView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        init();
    }

    private void init()
    {
        screenView = new MainActivityScreenView(getLayoutInflater(),null);
        controller = new MainActivityController(this);
        controller.bindView(screenView);
        getLifecycle().addObserver(controller);
        setContentView(screenView.getRootView());
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
