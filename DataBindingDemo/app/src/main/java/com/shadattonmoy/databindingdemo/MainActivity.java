package com.shadattonmoy.databindingdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.shadattonmoy.databindingdemo.dataSource.DummyDataSource;
import com.shadattonmoy.databindingdemo.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity
{
    ActivityMainBinding dataBinder;
    MainActivityClickListener clickListener;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initDataBinder();
    }

    private void initDataBinder()
    {
        dataBinder = DataBindingUtil.setContentView(this,R.layout.activity_main);
        dataBinder.setPerson(DummyDataSource.getDummyPerson());
        clickListener = new MainActivityClickListener();
        dataBinder.setClickListener(clickListener);
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


    }
}
