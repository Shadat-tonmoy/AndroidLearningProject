package com.shadattonmoy.androidJetPackDemo.uiController;

import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;

public class MainActivityController implements LifecycleObserver
{
    private static final String TAG = "MainActivityController";

    private AppCompatActivity activity;

    public MainActivityController(AppCompatActivity activity)
    {
        this.activity = activity;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public void onCreate()
    {
        Log.e(TAG, "onCreate: FromUIController");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    public void onStart()
    {
        Log.e(TAG, "onStart: FromUIController");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public void onStop()
    {
        Log.e(TAG, "onStop: FromUIController");
    }



}
