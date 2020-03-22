package com.stcodesapp.bmicalculator;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.stcodesapp.bmicalculator.common.BaseActivity;
import com.stcodesapp.bmicalculator.factory.ViewFactory;
import com.stcodesapp.bmicalculator.ui.views.screenView.activityScreenViews.MainActivityScreenView;
import com.stcodesapp.bmicalculator.controller.activityController.MainActivityController;

import javax.inject.Inject;

public class MainActivity extends BaseActivity
{

    private static final String TAG = "MainActivity";
    private MainActivityScreenView screenView;
    @Inject MainActivityController controller;
    @Inject ViewFactory viewFactory;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        getPresentationComponent().inject(this);
        init();
    }

    private void init()
    {
        screenView = viewFactory.getMainActivityScreenView(null);
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
