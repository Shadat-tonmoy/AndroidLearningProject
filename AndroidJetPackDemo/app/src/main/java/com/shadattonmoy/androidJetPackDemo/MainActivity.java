package com.shadattonmoy.androidJetPackDemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.shadattonmoy.androidJetPackDemo.dataSource.DummyDataSource;
import com.shadattonmoy.androidJetPackDemo.databinding.ActivityMainBinding;
import com.shadattonmoy.androidJetPackDemo.uiController.MainActivityController;

public class MainActivity extends AppCompatActivity
{
    private static final String TAG = "MainActivity";
    MainActivityController uiController;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        initUIController();
    }

    private void initUIController()
    {
        uiController = new MainActivityController(this);
        getLifecycle().addObserver(uiController);
    }
}
