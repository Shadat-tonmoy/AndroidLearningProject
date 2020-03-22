package com.stcodesapp.bmicalculator.controller.activityController;

import android.app.Activity;
import android.util.Log;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;

import com.stcodesapp.bmicalculator.dataSource.RandomNumberGenerator;
import com.stcodesapp.bmicalculator.ui.views.screen.activityScreen.MainActivityScreen;
import com.stcodesapp.bmicalculator.ui.views.screenView.activityScreenViews.MainActivityScreenView;

public class MainActivityController implements MainActivityScreen.Listener, LifecycleObserver
{

    private static final String TAG = "MainActivityController";
    private Activity activity;
    private MainActivityScreenView screenView;
    private RandomNumberGenerator randomNumberGenerator;
    private LiveData<String> randomNumberString;

    public MainActivityController(Activity activity)
    {
        this.activity = activity;
        randomNumberGenerator = new ViewModelProvider((ViewModelStoreOwner) activity).get(RandomNumberGenerator.class);
    }

    public void bindView(MainActivityScreenView screenView)
    {
        this.screenView = screenView;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    public void onStart()
    {
        Log.e(TAG, "onStart: RegisteringListener");
        initRandomNumberObserver();
        screenView.registerListener(this);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public void onStop()
    {
        screenView.unregisterListener(this);
    }

    @Override
    public void onGenerateRandomNumberButtonClicked()
    {
        generateNewRandomNumber();
    }

    private void initRandomNumberObserver()
    {
        randomNumberString = randomNumberGenerator.getRandomNumber();
        screenView.getRandomNumberView().setText(randomNumberString.getValue());
        randomNumberString.observe((LifecycleOwner) activity, new Observer<String>() {
            @Override
            public void onChanged(String s)
            {
                Log.e(TAG, "onChanged: "+s);
                screenView.getRandomNumberView().setText(s);
            }
        });
    }

    private void generateNewRandomNumber()
    {
        randomNumberGenerator.createRandomNumber();
    }
}
