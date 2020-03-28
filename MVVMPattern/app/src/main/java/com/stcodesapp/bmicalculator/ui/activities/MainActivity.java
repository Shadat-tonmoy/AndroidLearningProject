package com.stcodesapp.bmicalculator.ui.activities;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends BaseNavigationDrawerActivity
{

    private static final String TAG = "MainActivity";
//    private MainActivityScreenView screenView;
//    @Inject MainActivityController controller;
//    @Inject ViewFactory viewFactory;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
//        getPresentationComponent().inject(this);
//        init();
    }

    private void init()
    {
        /*screenView = viewFactory.getMainActivityScreenView(null);
        controller.bindView(screenView);
        getLifecycle().addObserver(controller);
        setContentView(screenView.getRootView());*/
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
