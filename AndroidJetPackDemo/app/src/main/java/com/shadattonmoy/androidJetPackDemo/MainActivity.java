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
    MainActivityClickListener clickListener;
    ActivityMainBinding dataBinder;
    MainActivityController uiController;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        initDataBinder();
        initUIController();
    }

    private void initDataBinder()
    {
        dataBinder = DataBindingUtil.setContentView(this,R.layout.activity_main);
        dataBinder.setPerson(DummyDataSource.getDummyPerson());
        clickListener = new MainActivityClickListener();
        dataBinder.setClickListener(clickListener);
        setContentView(dataBinder.getRoot());
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

    private void initUIController()
    {
        uiController = new MainActivityController(this);
        getLifecycle().addObserver(uiController);
    }

    public class MainActivityClickListener
    {
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
}
