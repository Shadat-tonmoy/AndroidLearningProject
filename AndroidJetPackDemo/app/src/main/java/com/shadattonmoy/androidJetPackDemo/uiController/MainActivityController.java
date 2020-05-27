package com.shadattonmoy.androidJetPackDemo.uiController;

import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;

import com.shadattonmoy.androidJetPackDemo.MainActivity;
import com.shadattonmoy.androidJetPackDemo.R;
import com.shadattonmoy.androidJetPackDemo.dataSource.DummyDataSource;
import com.shadattonmoy.androidJetPackDemo.databinding.ActivityMainBinding;

public class MainActivityController implements LifecycleObserver
{
    private static final String TAG = "MainActivityController";

    private AppCompatActivity activity;
    private ActivityMainBinding dataBinder;

    public MainActivityController(AppCompatActivity activity)
    {
        this.activity = activity;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public void onCreate()
    {
        Log.e(TAG, "onCreate: FromUIController");
        initDataBinder();
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

    private void initDataBinder()
    {
        dataBinder = DataBindingUtil.setContentView(activity, R.layout.activity_main);
        dataBinder.setPerson(DummyDataSource.getDummyPerson());
//        clickListener = new MainActivity.MainActivityClickListener();
        dataBinder.setClickListener(this);
        activity.setContentView(dataBinder.getRoot());
        startHandler();
    }

    private void startHandler()
    {
        final Handler handler = new Handler();
        Thread waitingThread = new Thread(new Runnable() {
            @Override
            public void run()
            {
                try
                {
                    Log.e(TAG, "run: WaitingForUpdate");
                    Thread.sleep(5000);
                    handler.post(new Runnable()
                    {
                        @Override
                        public void run()
                        {

                            Log.e(TAG, "run: WaitCompleted");
                            dataBinder.setPerson(DummyDataSource.getUpdatedPerson());

                        }
                    });

                }catch (Exception e)
                {

                }

            }
        });
        waitingThread.start();
    }

    public void onEmailButtonClicked(View view)
    {
        Toast.makeText(view.getContext(), "ClickedOnEmail", Toast.LENGTH_SHORT).show();

    }

    public void onPhoneButtonClicked(View view)
    {
        Toast.makeText(view.getContext(), "ClickedOnPhone", Toast.LENGTH_SHORT).show();
    }

    public void onMessageButtonClicked(View view)
    {
        Toast.makeText(view.getContext(), "ClickedOnMessage", Toast.LENGTH_SHORT).show();
    }

    public void onUpdateDataClicked(View view)
    {
        dataBinder.setPerson(DummyDataSource.getUpdatedPerson());
    }




}
